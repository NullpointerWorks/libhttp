package exp.nullpointerworks.http.service;

import java.io.IOException;
import java.net.Socket;

import exp.nullpointerworks.http.RequestListener;
import exp.nullpointerworks.http.WebSocket;

/**
 * 
 * @since 1.0.0
 */
public abstract class DefaultWebServer extends AbstractWebServer implements RequestListener
{
	@Override
	public WebSocket onNewConnection(Socket s)
	{
		try
		{
			return new DefaultWebSocket(s, this);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return new NullWebSocket();
	}
}
