/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http.server;

import java.io.IOException;
import java.net.Socket;

import exp.nullpointerworks.http.RequestListener;
import exp.nullpointerworks.http.WebSocket;
import exp.nullpointerworks.http.WebSocketListener;
import exp.nullpointerworks.http.util.ConcurrentCounter;
import exp.nullpointerworks.http.util.NullWebSocket;

/**
 * 
 * @since 1.0.0
 */
public abstract class DefaultWebServer extends AbstractWebServer implements RequestListener, WebSocketListener
{
	private final ConcurrentCounter cc = new ConcurrentCounter();
	
	public DefaultWebServer()
	{
		
	}
	
	@Override
	public WebSocket onNewConnection(Socket s)
	{
		if (allowConnection())
		{
			try
			{
				return new DefaultWebSocket(s, this, this);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.err.println( DefaultWebServer.class.getName()+": Maximum number of server socket threads reached!");
		}
		
		return new NullWebSocket();
	}
	
	private boolean allowConnection()
	{
		return cc.lessThen(getMaxThreads());
	}
	
	/*
	 * web socket activity feedback
	 */
	
	@Override
	public void onSocketStart(WebSocket s) {}
	
	@Override
	public final void onSocketOpen(WebSocket s) 
	{
		cc.increment();
	}
	
	@Override
	public final void onSocketClose(WebSocket s) 
	{
		cc.decrement();
	}
	
	@Override
	public void onSocketStop(WebSocket s) {}
	
	@Override
	public void onSocketRecieving(WebSocket s) {}
	
	@Override
	public void onSocketTransmitting(WebSocket s) {}
	
}
