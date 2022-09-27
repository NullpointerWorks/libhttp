/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import exp.nullpointerworks.http.WebServer;
import exp.nullpointerworks.http.WebSocket;
import exp.nullpointerworks.http.util.NetworkUtil;

/**
 * 
 * @since 1.0.0
 */
public abstract class AbstractWebServer implements WebServer, Runnable
{
	private int maxThreads = 32;
	private Boolean running = false;
	private Thread serverThread = null;
	
	private InetAddress serverAddress = null;
	private short serverPort = 80;
	private int serverBacklog = 128;
	private ServerSocket ss = null;
	private int timeout	= 60_000;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public abstract WebSocket onNewConnection(Socket s);
	
	@Override
	public final void setBackLog(int bl)
	{
		if (bl<0) return;
		serverBacklog = bl;
	}
	
	@Override
	public final void setMaxThreads(int max)
	{
		maxThreads = max;
	}
	
	@Override
	public final void setSocketTimeout(int milies)
	{
		timeout = milies;
	}
	
	@Override
	public final void setPort(int port)
	{
		serverPort = (short)(port & 0x0000ffff);
	}
	
	@Override
	public final void setAddress(String ip)
	{
		if (!NetworkUtil.isIPv4Address(ip)) return;
		try
		{
			serverAddress = InetAddress.getByName(ip);
		} 
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public final int getPort()
	{
		if (ss!=null) return ss.getLocalPort();
		else return serverPort;
	}
	
	@Override
	public final String getAddress()
	{
		return serverAddress.getHostAddress();
	}
	
	@Override
	public int getMaxThreads()
	{
		return maxThreads;
	}
	
	@Override
	public final boolean isRunning()
	{
		synchronized(this)
		{
			return running;
		}
	}
	
	@Override
	public final void start()
	{
		if (serverThread!=null)
		if (serverThread.isAlive())
		{
			serverThread.interrupt();
		}
		serverThread = new Thread(this);
		serverThread.start();
	}
	
	@Override
	public final void stop()
	{
		synchronized(this)
		{
			running = false;
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
	
	// ============================================================================
	
	@Override
	public final void run()
	{
		try
		{
			close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
			return;
		}
		
		try
		{
			ss = new ServerSocket();
			ss.setReuseAddress(true); // be able to bind again after closing
			ss.bind(new InetSocketAddress(serverAddress, serverPort), serverBacklog);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
			return;
		}
		
		running = true;
        while (running)
        {
            try
			{
				Thread.sleep(200);
			}
            catch (InterruptedException e)
			{
				e.printStackTrace();
			}
            
            Socket s = null;
            
            try
            {
                s = ss.accept();
                s.setSoTimeout(timeout);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                continue;
            }
            
            if (s != null)
			{
	            WebSocket ws = onNewConnection(s);
	    		ws.open();
        	}
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
	
	private void close() throws IOException
 	{
		if (ss==null) return;
		ss.close();
 	}
}
