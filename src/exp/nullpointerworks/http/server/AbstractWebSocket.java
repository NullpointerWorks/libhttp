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
import exp.nullpointerworks.http.WebSocketListener;
import exp.nullpointerworks.http.util.NullWebSocketListener;
import exp.nullpointerworks.http.util.ThreadedWebSocketListener;

public abstract class AbstractWebSocket implements WebSocket, Runnable
{
	private int bufferSize = 512 * 1024; // 512 KiB
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private Boolean isOpen = false;
	private Boolean keepalive = false;
	private WebSocketListener wsl;
	
	public abstract void onIncomingBytes(byte[] data);
	
	// ===========================================================================
	
	public AbstractWebSocket()
	{
		wsl = new NullWebSocketListener();
	}
	
	public void setWebSocketListener(WebSocketListener wsl)
	{
		this.wsl = new ThreadedWebSocketListener(wsl);
	}
	
	public final void keepAlive()
	{
		keepalive = true;
	}
	
	@Override
 	public final void run()
 	{
		wsl.onSocketStart(this);
		
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
			//
			
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
     	
     	wsl.onSocketStop(this);
 	}
	
	private void sleep(long sl)
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
	
	public synchronized final void setSocket(Socket s) throws IOException
	{
		socket = s;
		is = socket.getInputStream();
        os = socket.getOutputStream();
	}
	
	public synchronized final void setBufferSize(int bytes)
	{
		bufferSize = bytes;
	}
	
	@Override
	public synchronized final void open() 
	{
		if (!isOpen)
		{
			wsl.onSocketOpen(this);
			Thread t = new Thread(this);
			t.start();
			isOpen = true;
		}
	}
	
	@Override
	public synchronized final boolean isOpen()
	{
		return isOpen;
	}
	
	@Override
	public synchronized final byte[] readBytes() throws IOException
	{
		byte[] bytes = new byte[0];
		if (isOpen)
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
			wsl.onSocketRecieving(this);
		}
		return bytes;
	}
	
	@Override
	public synchronized final void sendBytes(byte[] msg) throws IOException
	{
		if (isOpen)
		{
			os.write(msg);
	    	os.flush();
	    	wsl.onSocketTransmitting(this);
		}
	}
	
	@Override
	public synchronized final void close() throws IOException
	{
		if (isOpen)
		{
			is.close();
	 		os.close();
	 		socket.close();
			isOpen = false;
			wsl.onSocketClose(this);
		}
	}
}
