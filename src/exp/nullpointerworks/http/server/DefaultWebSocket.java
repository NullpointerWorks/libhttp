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
import exp.nullpointerworks.http.WebSocketListener;
import exp.nullpointerworks.http.util.RequestParser;

/**
 * 
 * @since 1.0.0
 */
public class DefaultWebSocket extends AbstractWebSocket
{
	private final RequestListener rl;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public DefaultWebSocket(Socket s, RequestListener rl) throws IOException
	{
		this.rl = rl;
		setSocket(s);
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public DefaultWebSocket(Socket s, RequestListener rl, WebSocketListener wsl) throws IOException
	{
		this(s,rl);
		setWebSocketListener(wsl);
	}
	
	@Override
	public synchronized void onIncomingBytes(byte[] data)
	{
		RequestParser parser = new RequestParser();
		Request req = parser.parse(data);
		onRequest(req);
	}
	
	private void onRequest(Request req)
	{
		if (!req.isValid()) return;
		Response resp = rl.onRequest(req);
		sendResponse(resp);
	}
	
	public synchronized void sendResponse(Response resp)
	{
		if (!resp.isValid()) return;
		try
		{
			keepAlive();
			sendBytes(resp.getBytes());
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
