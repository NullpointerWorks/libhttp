/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2021)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Vector;

import com.nullpointerworks.util.concurrency.Counter;

/**
 * 
 * @author Michiel Drost - Nullpointer Works
 * @since 1.0.0
 */
public abstract class AbstractWebServer implements WebServer, RequestListener, SocketListener
{
	/**
	 * Default TCP-IP port for web servers is assumed to be 80.
	 * @since 1.0.0
	 */
	public static final short DEFAULT_PORT = 80;
	
	// ========================================
	
	private Boolean running 	= false;
	private short port 			= DEFAULT_PORT;
	private InetAddress addr	= null;
	private int sleep			= 100;
	private int backlog			= 128;
	private ServerSocket ss;
	private int maxThreads;
	private Counter count;
	private Thread serverThread;
	
	private List<SocketListener> socketListeners;
	
	public AbstractWebServer()
	{
		socketListeners = new Vector<SocketListener>();
		maxThreads = 265;
		count = new Counter();
	}
	
	@Override
	public void setMaxThreads(int max)
	{
		maxThreads = max;
	}
	
	@Override
	public void setBackLog(int bl)
	{
		backlog = bl;
	}
	
	@Override
	public void setPort(int port) 
	{
		this.port = (short)(port & 0x0000FFFF);
	}
	
	@Override
	public void setAddress(String ip) 
	{
		if (!NetUtil.isIPv4Address(ip)) return;
		
		try
		{
			addr = InetAddress.getByName(ip);
		} 
		catch (UnknownHostException e) 
		{ }
	}
	
	@Override
	public void addSocketListener(SocketListener sl)
	{
		if (!socketListeners.contains(sl))
		{
			socketListeners.add(sl);
		}
	}

	@Override
	public void removeSocketListener(SocketListener sl)
	{
		if (socketListeners.contains(sl))
		{
			socketListeners.remove(sl);
		}
	}
	
	@Override
	public boolean isRunning()
	{
		synchronized(running)
		{
			return running;
		}
	}
	
	@Override
	public int getPort()
	{
		if (ss!=null) return ss.getLocalPort();
		else return port;
	}
	
	@Override
	public String getAddress() 
	{
		return addr.getHostAddress();
	}
	
	@Override
	public void start()
	{
		if (serverThread!=null)
		if (serverThread.isAlive())
		{
			serverThread.interrupt();
		}
		
		serverThread = new Thread(()->
		{
			runThread();
		});
		serverThread.start();
	}
	
	@Override
	public void stop()
	{
		synchronized(running)
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
	
	/*
	 * =========================================================
	 */
	
	@Override
	public void onSocketConnect(SocketWorker sw)
	{
		for (SocketListener sl : socketListeners)
		{
			sl.onSocketConnect(sw);
		}
	}
	
	@Override
	public void onSocketDisconnect(SocketWorker sw)
	{
		for (SocketListener sl : socketListeners)
		{
			sl.onSocketDisconnect(sw);
		}
	}
	
	/*
	 * =========================================================
	 */
	
	private final void runThread()
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
			ss.bind(new InetSocketAddress(addr, port), backlog);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
			return;
		}
		
		running = true;
        while (running)
        {
            Socket s = null;
            
            try
            {
                s = ss.accept();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            
            if (s != null)
			{
	            if (allowConnection())
	            {
	            	try
					{
						SocketWorker sw = new SocketWorker(s, this, this, this);
						sw.start();
					} 
					catch (IOException e)
					{
						e.printStackTrace();
					}
	            }
        	}
            
            try
			{
				Thread.sleep(sleep);
			}
            catch (InterruptedException e)
			{
				e.printStackTrace();
			}
        }
        
        try
		{
			close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
			return;
		}
	}
	
	private final void close() throws IOException
 	{
		if (ss==null) return;
		ss.close();
 	}
	
	private boolean allowConnection()
	{
		if (count.value()<0) return true;
		return count.value() < maxThreads;
	}
}
