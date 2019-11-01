/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
import java.util.TimeZone;

import com.nullpointerworks.util.concurrency.Counter;

/**
 * 
 * @author Michiel Drost - Nullpointer Works
 * @since 1.0.0
 */
public abstract class WebServer 
implements SocketListener, RequestListener, Runnable
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
	private int max_thread		= 256;
	private int backlog			= 128;
	private ServerSocket ss;
	private List<SocketListener> sla;
	private Counter cnt;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public WebServer()
	{
		cnt = new Counter();
		sla = new ArrayList<SocketListener>();
	}
	
	@Override public Response onGET(Request o) {return null;}
	@Override public Response onPUT(Request o) {return null;}
	@Override public Response onPOST(Request o) {return null;}
	@Override public Response onHEAD(Request o) {return null;}
	@Override public Response onTRACE(Request o) {return null;}
	@Override public Response onPATCH(Request o) {return null;}
	@Override public Response onDELETE(Request o) {return null;}
	@Override public Response onOPTIONS(Request o) {return null;}
	@Override public Response onCONNECT(Request o) {return null;}
	@Override public Response onUNKNOWN(Request o) {return null;}
	
	/**
	 * Starts the server.
	 * @since 1.0.0
	 */
	public final void start() throws IOException
	{
		synchronized(running)
		{
			running = true;
		}
		(new Thread(this)).start();
	}
	
	/**
	 * Start the server with a custom port
	 * @since 1.0.0
	 */
	public void start(int port) throws IOException
	{
		setPort(port);
		start();
	}
	
	public void start(String ip, int port) throws IOException
	{
		addr = InetAddress.getByName(ip);
		setPort(port);
		start();
	}
	
	
	/**
	 * Returns the time and date of this machine in GMT<br><br>
	 * For example: <br>
	 * EEE, d MMM yyyy hh:mm:ss z<br>
	 * Tue, 11 Jun 2019 11:56:53 GMT<br>
	 * @since 1.0.0
	 */
	public final String getDateTimeStamp()
	{
		final Date currentTime = new Date();
		final SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy hh:mm:ss z");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf.format(currentTime);
	}
	
	/**
	 * Set the maximum number of threads for this server.
	 * @since 1.0.0
	 */
	public final void setMaxThreads(int mt)
	{
		max_thread = mt;
	}
	
	/**
	 * Set the requested maximum length of the queue of incoming connections.
	 * @since 1.0.0
	 */
	public final void setBackLog(int bl)
	{
		backlog = bl;
	}
	
	/**
	 * Allow/disallow console printing.
	 * @since 1.0.0
	 */
	public final void setVerbose(boolean b)
	{
		verbose = b;
	}
	
	/**
	 * Set the port for this webserver.
	 * @since 1.0.0
	 */
	public final void setPort(int port) 
	{
		this.port = (short)(port & 0x0000FFFF);
	}
	
	/**
	 * Set the IP v4 address for this webserver to connect to.
	 * @since 1.0.0
	 */
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
	
	/**
	 * Add a listener for when a client connects to the server
	 * @since 1.0.0
	 */
	public void addSocketListener(SocketListener sl)
	{
		sla.add(sl);
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public boolean isRunning()
	{
		return running;
	}
	
	/**
	 * Stops the server.
	 * @since 1.0.0
	 */
	public final void stop()
	{
		running = false;
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
	 * Returns the port allocated to this server.
	 * @since 1.0.0
	 */
	public final int port()
	{
		if (ss!=null) return ss.getLocalPort();
		else return port;
	}
	
	@Override
	public final void onConnect(SocketWorker sw)
	{
		cnt.increment();
		for (SocketListener sl : sla)
		{
			sl.onConnect(sw);
		}
	}
	
	@Override
	public final void onDisconnect(SocketWorker sw)
	{
		cnt.decrement();
		for (SocketListener sl : sla)
		{
			sl.onDisconnect(sw);
		}
	}
	
	/**
	 * Thread enabled listening. Runs listen() method in a new thread
	 * @since 1.0.0
	 */
	@Override
	public void run()
	{
		try
		{
			listen();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Starts listening to connections.
	 * @since 1.0.0
	 */
	public final void listen() throws IOException
	{
		close();

		if (verbose) System.out.println("\n---- Starting Server ----\n");
		
		ss = new ServerSocket();
		ss.setReuseAddress(true); // be able to bind again after closing
		ss.bind(new InetSocketAddress(addr, port), backlog);
		
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
            if (cnt.value() < max_thread)
            {
            	if (verbose) System.out.println("\n---- Connecting "+s+" ----\n");
            	SocketWorker sw = new SocketWorker(s, this, this, verbose);
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
	
	/**
	 * 
	 * @since 1.0.0
	 */
	protected final void close() throws IOException
 	{
		if (ss==null) return;
		if (verbose) System.out.println("\n---- Closing Server ----\n");
		ss.close();
 	}
}
