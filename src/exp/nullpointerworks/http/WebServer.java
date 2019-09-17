/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
	public static final short DEFAULT 	= 5056;
	public static final short WEBS 		= 80; // TCP web servers
	public static final short SMTP 		= 25; // email
	
	// ========================================

	private final String v 		= "v0.2.0a";
	private Boolean running 	= false;
	private short port 			= DEFAULT;
	private int sleep			= 100;
	private boolean verbose 	= false;
	private int max_thread		= 256;
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
	@Override public Response onDELETE(Request o) {return null;}
	@Override public Response onOPTIONS(Request o) {return null;}
	@Override public Response onCONNECT(Request o) {return null;}
	@Override public Response onUNKNOWN(Request o) {return null;}
	
	/**
	 * Start the server with a custom port
	 * @since 1.0.0
	 */
	public void start(int port) throws IOException
	{
		setPort(port);
		start();
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
	 * Returns the name of the server software architecture
	 * @since 1.0.0
	 */
	public final String getServer()
	{
		return "NPW WebServer";
	}

	/**
	 * Returns the current server version
	 * @since 1.0.0
	 */
	public final String getVersion()
	{
		return v;
	}
	
	/**
	 * Set the maximum number of threads for this server
	 * @since 1.0.0
	 */
	public final void setMaxThreads(int mt)
	{
		max_thread = mt;
	}
	
	/**
	 * Allow/disallow console printing
	 * @since 1.0.0
	 */
	public final void setVerbose(boolean b)
	{
		verbose = b;
	}
	
	/**
	 * Set the port for this webserver
	 * @since 1.0.0
	 */
	public final void setPort(int port) 
	{
		this.port = (short)(port & 0x0000FFFF);
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
	 * Stops the server.
	 * @since 1.0.0
	 */
	public final void stop()
	{
		synchronized(running)
		{
			running = false;
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
	
	/**
	 * Starts listening to connections.
	 * @since 1.0.0
	 */
	public final void listen() throws IOException
	{
		close();
		
        ss = new ServerSocket(port); 
        
        while (running)  
        {
            Socket s = null;
            
            try 
            {
                s = ss.accept();
                
                if (cnt.value() < max_thread)
                {
                	if (verbose) System.out.println("\n---- Connecting "+s);
                	SocketWorker sw = new SocketWorker(s, this, this, verbose);
                    sw.start();
                }
            }
            catch (Exception e)
            {
                stop();
                s.close();
                e.printStackTrace(); 
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
	 * Send an array of bytes over the connection of the given SocketWorker
	 * @since 1.0.0
	 */
	protected final void send(SocketWorker worker, byte[] msg)
	{
		if (worker==null) return;
		if (msg==null) return;
		
		try
		{
			worker.sendBytes(msg);
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
	protected final void close() throws IOException
 	{
		if (ss==null) return;
		ss.close();
 	}
}
