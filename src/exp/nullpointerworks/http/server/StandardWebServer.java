/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.util.concurrency.Counter;

import exp.nullpointerworks.http.RequestListener;
import exp.nullpointerworks.http.SocketListener;
import exp.nullpointerworks.http.SocketWorker;

/**
 * 
 * @author Michiel Drost - Nullpointer Works
 * @since 1.0.0
 */
public abstract class StandardWebServer extends GenericWebServer
implements SocketListener, RequestListener, Runnable
{
	private int max_thread= 256;
	private List<SocketListener> sla;
	private Counter cnt;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public StandardWebServer()
	{
		cnt = new Counter();
		sla = new ArrayList<SocketListener>();
	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public boolean allowConnection()
	{
		return cnt.value() < max_thread;
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
	 * Add a listener for when a client connects to the server
	 * @since 1.0.0
	 */
	public final void addSocketListener(SocketListener sl)
	{
		sla.add(sl);
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
	 * Start the server with a custom port.
	 * @since 1.0.0
	 */
	public void start(int port) throws IOException
	{
		setPort(port);
		start();
	}
	
	/**
	 * Start the server with a custom port and IP.
	 * @since 1.0.0
	 */
	public void start(String ip, int port) throws IOException
	{
		setAddress(ip);
		setPort(port);
		start();
	}
	
	/**
	 * Starts the server.
	 * @since 1.0.0
	 */
	public final void start() throws IOException
	{
		(new Thread(this)).start();
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
			listen(this,this);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
