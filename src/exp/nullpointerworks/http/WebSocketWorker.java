/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2021)
 * Using this library make you subject to its license terms.
 */
package exp.nullpointerworks.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

import exp.nullpointerworks.http.header.ConnectionHeader;
import exp.nullpointerworks.http.header.Header;
import exp.nullpointerworks.http.types.HeaderType;
import exp.nullpointerworks.http.types.RequestMethod;

/**
 * Connection socket. This may be closed or kept alive on request
 * @author Michiel Drost - Nullpointer Works
 * @since 1.0.0
 */
public class WebSocketWorker implements WebSocket, Runnable
{ 
	private final InputStream is;
	private final OutputStream os;
	private final Socket s;
	private final RequestListener rl;
	private final WebServer ss;
	
	private long timeout = 60_000_000_000l; // nano
	private long timealive = 0;
	private int read_buffer_size = 512 * 1024; // 512 KiB
	private Boolean isRunning = false;
	
	/**
	 * 
	 * @since 1.0.0
	 */
 	public WebSocketWorker(Socket s, WebServer ss, RequestListener rl) throws IOException
 	{
        is = s.getInputStream();
        os = s.getOutputStream();
 		this.s 	= s;
 		this.rl	= rl;
 		this.ss = ss;
 		setReadBufferSize(512);
 	}
    
    @Override
 	public void setTimeoutLimit(int timeout) 
 	{
 		this.timeout = timeout * 1000_000;
 	}
    
    @Override
	public void setReadBufferSize(int rbs)
	{
		read_buffer_size = rbs * 1024;
	}
	
 	@Override
 	public void open()
 	{
 		Thread t = new Thread(this);
		t.start();
 	}
 	
 	@Override
 	public void run()
 	{
		boolean ka = false;
		long timestart = System.nanoTime();
		
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
	 			byte[] inp = readBytes();
	 			if (inp.length > 0)
	 			{
					req = RequestParser.generate(inp);
	 			}
			}
	 		catch(SocketException ex)
	 		{
	 			// if something went wrong with the socket, break out of the loop
	 			ex.printStackTrace();
	 			break;
	 		}
	 		catch (IOException e)
			{
				e.printStackTrace();
	 			break;
			}
	 		
	 		// check server state
	 		if (!ss.isRunning())
	 		{
	 			break;
	 		}
	 		
	 		// if we have a request
	 		if (req != null)
	 		{
				req.setClientSocket(this);
		 		RequestMethod mtype = req.getMethod().getMethodType();
		 		Response resp = null;
	 			switch(mtype)
	 			{
	 			case PUT: resp = rl.onPUT(req); break;
	 			case GET: resp = rl.onGET(req); break;
	 			case HEAD: resp = rl.onHEAD(req); break;
	 			case POST: resp = rl.onPOST(req); break;
	 			case TRACE: resp = rl.onTRACE(req); break;
	 			case DELETE: resp = rl.onDELETE(req); break;
	 			case CONNECT: resp = rl.onCONNECT(req); break;
	 			case OPTIONS: resp = rl.onOPTIONS(req); break;
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
		 		Header h = req.findHeader( HeaderType.CONNECTION );
				ConnectionHeader ch = new ConnectionHeader(h);
		 		ka = ch.isKeepAlive();
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
 	}
    
    @Override
	public final synchronized byte[] readBytes() throws IOException
    {
    	byte[] bytes 	= new byte[0];
    	byte[] toread 	= new byte[read_buffer_size];
    	int allocate	= is.read(toread);
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
	
    @Override
    public final synchronized void sendBytes(byte[] msg) throws IOException
    {
		os.write(msg);
    	os.flush();
    }
    
    @Override
    public final synchronized void close() throws IOException
 	{
 		is.close();
 		os.close();
 		s.close();
 	}
}
