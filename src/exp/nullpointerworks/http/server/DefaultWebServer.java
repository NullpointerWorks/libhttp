/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http.server;

import java.io.IOException;
import java.net.Socket;

import exp.nullpointerworks.http.RequestListener;
import exp.nullpointerworks.http.ResponseListener;
import exp.nullpointerworks.http.WebSocket;
import exp.nullpointerworks.http.util.NullWebSocket;

/**
 * 
 * @since 1.0.0
 */
public abstract class DefaultWebServer extends AbstractWebServer implements RequestListener, ResponseListener
{
	public DefaultWebServer()
	{
		
	}
	
	@Override
	public WebSocket onNewConnection(Socket s)
	{
		try
		{
			return new DefaultWebSocket(s, this, this);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return new NullWebSocket();
	}
}
