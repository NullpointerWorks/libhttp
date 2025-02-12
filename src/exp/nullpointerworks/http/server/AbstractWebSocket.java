/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

import exp.nullpointerworks.http.WebSocket;
import exp.nullpointerworks.http.util.ConcurrentCounter;

/**
 * 
 * 
 */
public abstract class AbstractWebSocket implements WebSocket
{
	private int bufferSize = 512 * 1024; // 512 KiB
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private Boolean isOpen = false;
	private Boolean keepalive = true;
	private ConcurrentCounter serverCounter = new ConcurrentCounter(0);
	
	public abstract void onIncomingBytes(byte[] data);
	
	/*
	 * receiver thread
	 */
 	private final Runnable rx = new Runnable()
	{
 		public void run()
 	 	{
 			// check for connection data. 
 			// its rare that I can actually use a do-while loop in a useful manner
 			do
 			{
 				try
 				{
 		 			byte[] inp = readBytes();
 		 			if (inp.length>0)
 		 			{
 		 				onIncomingBytes(inp);
 		 			}
 				}
 		 		catch (SocketTimeoutException e)
 				{
 					//e.printStackTrace();
 		 			System.out.println( AbstractWebSocket.class.getName()+": Read timed out");
 		 			continue;
 				}
 				
 	 			// if something goes wrong with the socket, stop the connection
 		 		catch(SocketException ex)
 		 		{
 		 			ex.printStackTrace();
 		 			break;
 		 		}
 		 		catch (IOException e)
 				{
 					e.printStackTrace();
 		 			break;
 				}
 				
 				sleep(100);
 			}
 			while(keepalive);
 			
 	     	try
 			{
 				close();
 			}
 	     	catch (IOException e)
 			{
 				e.printStackTrace();
 			}
 	 	}
	};
	
	// ===========================================================================
	
	@Override
	public synchronized void open() 
	{
		if (!isOpen)
		{
			serverCounter.increment();
			isOpen = true;
			Thread t_rx = new Thread(rx);
			t_rx.start();
		}
	}
	
	public synchronized void setSocket(Socket s) throws IOException
	{
		socket = s;
		is = socket.getInputStream();
        os = socket.getOutputStream();
	}
	
	public synchronized void setBufferSize(int bytes)
	{
		bufferSize = bytes;
	}

	@Override
	public void setCounter(ConcurrentCounter cc)
	{
		serverCounter = cc;
	}
	
	private synchronized void sleep(long sl)
	{
		try
		{
			Thread.sleep(sl);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	// ===========================================================================
	
	@Override
	public void keepAlive(boolean ka)
	{
		keepalive = ka;
	}
	
	@Override
	public synchronized boolean isOpen()
	{
		return isOpen;
	}
	
	@Override
	public synchronized byte[] readBytes() throws IOException
	{
		byte[] bytes = new byte[0];
		if (isOpen)
		{
			int avail = is.available();
			if(avail > 0)
			{
		    	byte[] toread = new byte[bufferSize];
		    	int allocate = is.read(toread);
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
			}
		}
		return bytes;
	}
	
	@Override
	public synchronized void sendBytes(byte[] msg) throws IOException
	{
		if (isOpen)
		{
			os.write(msg);
	    	os.flush();
		}
	}
	
	@Override
	public synchronized void close() throws IOException
	{
		if (isOpen)
		{
			keepalive = false;
			isOpen = false;
			serverCounter.decrement();
			is.close();
			os.close();
			socket.close();
		}
	}
}
