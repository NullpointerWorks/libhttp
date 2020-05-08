/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import exp.nullpointerworks.http.NetUtil;
import exp.nullpointerworks.http.RequestListener;
import exp.nullpointerworks.http.SocketListener;
import exp.nullpointerworks.http.SocketWorker;
import exp.nullpointerworks.http.WebServer;

/**
 * 
 * @author Michiel Drost - Nullpointer Works
 * @since 1.0.0
 */
public class GenericWebServer implements WebServer
{
	/**
	 * Default TCP-IP port for web servers is assumed to be 80.
	 * @since 1.0.0
	 */
	public static final short DEFAULT = 80;
	
	// ========================================
	
	private Boolean running 	= false;
	private short port 			= DEFAULT;
	private InetAddress addr	= null;
	private int sleep			= 100;
	private boolean verbose 	= false;
	private int backlog			= 128;
	private ServerSocket ss;
	
	@Override
	public boolean allowConnection()
	{
		return true;
	}
	
	@Override
	public final void setBackLog(int bl)
	{
		backlog = bl;
	}
	
	@Override
	public final void setVerbose(boolean b)
	{
		verbose = b;
	}
	
	@Override
	public final void setPort(int port) 
	{
		this.port = (short)(port & 0x0000FFFF);
	}
	
	@Override
	public final void setAddress(String ip) 
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
	public boolean isRunning()
	{
		synchronized(running)
		{
			return running;
		}
	}
	
	@Override
	public final int getPort()
	{
		if (ss!=null) return ss.getLocalPort();
		else return port;
	}
	
	@Override
	public final String getAddress() 
	{
		return addr.getHostAddress();
	}
	
	@Override
	public final void listen(RequestListener rl, SocketListener sl) throws IOException
	{
		close();
		
		if (verbose) System.out.println("\n---- Starting Server ----\n");
		
		ss = new ServerSocket();
		ss.setReuseAddress(true); // be able to bind again after closing
		ss.bind(new InetSocketAddress(addr, port), backlog);

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
                if (s!=null) s.close();
                if (verbose) e.printStackTrace(); 
            }
            
            if (s!=null)
            if (allowConnection())
            {
            	if (verbose) System.out.println("\n---- Connecting "+s+" ----\n");
            	SocketWorker sw = new SocketWorker(s, rl, sl, this, verbose);
                sw.start();
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
        
        close();
	}
	
	@Override
	public final void stop()
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
	
	/**
	 * 
	 * @since 1.0.0
	 */
	private final void close() throws IOException
 	{
		if (ss==null) return;
		if (verbose) System.out.println("\n---- Closing Server ----\n");
		ss.close();
 	}
}
