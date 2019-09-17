/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

import exp.nullpointerworks.http.header.Method;

/**
 * Connection socket. This may be closed or kept alive on request
 * @author Michiel Drost - Nullpointer Works
 * @since 1.0.0
 */
public class SocketWorker extends Thread  
{ 
	private final InputStream is;
	private final OutputStream os;
	private final Socket s;
	private final RequestListener rl;
	private final SocketListener sl;
	private long timeout = 60_000_000_000l; // nano
	private long timealive = 0;
	private int read_buffer_size = 512 * 1024; // 512 KiB
	private Boolean isRunning = false;
	private boolean verbose = false;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public SocketWorker(Socket s, WebServer ws) throws IOException
 	{ 
        is = s.getInputStream();
        os = s.getOutputStream();
 		this.s 		= s;
 		this.rl		= (RequestListener)ws;
 		this.sl 	= (SocketListener)ws;
 	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
 	public SocketWorker(Socket s, RequestListener rl, SocketListener sl, boolean verbose) 
 			throws IOException
 	{ 
        is = s.getInputStream();
        os = s.getOutputStream();
 		this.s 	= s;
 		this.rl	= rl;
 		this.sl = sl;
 		this.verbose = verbose;
 	}
 	
 	/**
 	 * Set the connection timeout in milliseconds
	 * @since 1.0.0
 	 */
 	public void setTimeoutLimit(int timeout) 
 	{
 		this.timeout = timeout * 1000_000;
 	}
 	
	/**
	 * Set the read data buffer
	 * @since 1.0.0
	 */
	public void setReadBufferSize(int rbs)
	{
		read_buffer_size = rbs;
	}
 	
	@Override
 	public void run()  
 	{
		long timestart = System.nanoTime();
		boolean ka = false;
		
		sl.onConnect(this);
		
		// check for connection data. 
		// its rare that I can actually use a do-while loop in a useful manner
		do
		{
			synchronized(isRunning)
			{
				isRunning = true;
			}
			
	 		Request req = null;
	 		
	 		try
			{
	 			byte[] inp = readBytes(is);
	 			if (inp.length > 0)
	 			{
					req = RequestParser.generate(inp, verbose);
	 			}
			}
	 		catch(SocketException ex)
	 		{
	 			ex.printStackTrace();
	 			// if something went wrong with the socket, break out of the loop
	 			break;
	 		}
	 		catch (IOException e)
			{
				e.printStackTrace();
	 			break;
			}
	 		
	 		// if we have a request
	 		if (req != null)
	 		{
		 		Response resp = null;
		 		
	 			int mtype = req.getMethod().getMethodType();
	 			switch(mtype)
	 			{
	 			case Method.PUT: resp = rl.onPUT(req); break;
	 			case Method.GET: resp = rl.onGET(req); break;
	 			case Method.HEAD: resp = rl.onHEAD(req); break;
	 			case Method.POST: resp = rl.onPOST(req); break;
	 			case Method.TRACE: resp = rl.onTRACE(req); break;
	 			case Method.DELETE: resp = rl.onDELETE(req); break;
	 			case Method.CONNECT: resp = rl.onCONNECT(req); break;
	 			case Method.OPTIONS: resp = rl.onOPTIONS(req); break;
	 			default: resp = rl.onUNKNOWN(req); break;
	 			}
	 			
	 			// did we get a response
		 		if (resp!=null)
		 		{
			 		try
					{
						sendBytes( resp.getBytes() );
					}
			 		catch (IOException e)
					{
						e.printStackTrace();
			 			break;
					}
		 		}
		 		
		 		// check if we keep the connection alive
		 		ka = req.getConnectionHeader().isKeepAlive();
	 		}
	 		else
	 		{
	 			// check the idle time
	 			long time = System.nanoTime() - timestart;
	 			timealive += time;
	 			ka = !(timealive > timeout);
	 		}
	 		
 			try
			{
				Thread.sleep(100);
			} 
 			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
	 	}
		while(ka);
 		
		synchronized(isRunning)
		{
			isRunning = false;
		}
     	
     	try
		{
			close();
		}
     	catch (IOException e)
		{
			e.printStackTrace();
		}
     	
		sl.onDisconnect(this);
 	}
	
	/**
	 * Returns the byte array of the read bytes. Set the buffer size to adjust the byte stream data limit.
	 * @throws IOException 
	 * @since 1.0.0
	 */
	public final synchronized byte[] readBytes(InputStream in) throws IOException
    {
    	byte[] bytes 	= new byte[0];
    	byte[] toread 	= new byte[read_buffer_size];
    	int allocate = in.read(toread);
		if (allocate>0)
		{
			bytes = new byte[allocate];
			int i=0;
			for (byte b : toread) 
			{ 
				if (i>=allocate)break;
				bytes[i++]=b;
			}
		}
		return bytes;
    }
	
	/**
	 * Returns true if the worker is still processing IO streams
	 * @since 1.0.0
	 */
	public boolean isRunning()
	{
		synchronized(isRunning)
		{
			return isRunning;
		}
	}
    
	/**
	 * @throws IOException 
	 * @since 1.0.0
	 */
    public final synchronized void sendBytes(byte[] msg) throws IOException
    {
		os.write(msg);
    	os.flush();
    }
    
 	/**
 	 * Closes all I/O streams.
 	 * @throws IOException 
	 * @since 1.0.0
 	 */
 	private final synchronized void close() throws IOException
 	{
 		is.close();
 		os.close();
 		s.close();
 	}
}
