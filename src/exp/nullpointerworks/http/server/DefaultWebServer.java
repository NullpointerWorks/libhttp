/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http.server;

import java.io.IOException;
import java.net.Socket;

import exp.nullpointerworks.http.Request;
import exp.nullpointerworks.http.RequestListener;
import exp.nullpointerworks.http.Response;
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
			return new ImplementedDefaultWebSocket(this, s);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return new NullWebSocket();
	}
	
}

/**
 * 
 * @since 1.0.0
 */
class ImplementedDefaultWebSocket extends DefaultWebSocket
{
	private DefaultWebServer server;
	
	public ImplementedDefaultWebSocket(DefaultWebServer server, Socket s) throws IOException 
	{
		super(s);
		this.server = server;
	}
	
	public Response onRequest(Request req)
	{
		if (req == null) return null;
		if (!req.isValid()) return null;
		Response resp = server.onRequest(req);
		if (resp == null) return null;
		if (!resp.isValid()) return null;
		return resp;
	}
	
	public Request onResponse(Response resp)
	{
		if (resp == null) return null;
		if (!resp.isValid()) return null;
		Request req = server.onResponse(resp);
		if (req == null) return null;
		if (!req.isValid()) return null;
		return req;
	}
}
