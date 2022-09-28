/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http.server;

import static exp.nullpointerworks.http.util.NetworkUtil.decodeString;

import java.io.IOException;
import java.net.Socket;

import exp.nullpointerworks.http.Method;
import exp.nullpointerworks.http.Request;
import exp.nullpointerworks.http.RequestListener;
import exp.nullpointerworks.http.Response;
import exp.nullpointerworks.http.ResponseListener;
import exp.nullpointerworks.http.util.BytePackage;
import exp.nullpointerworks.http.util.RequestParser;
import exp.nullpointerworks.http.util.ResponseParser;

/**
 * 
 * @since 1.0.0
 */
public class DefaultWebSocket extends AbstractWebSocket
{
	private final RequestListener rl;
	private final ResponseListener rpl;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public DefaultWebSocket(Socket s, RequestListener rl, ResponseListener rpl) throws IOException
	{
		this.rl = rl;
		this.rpl = rpl;
		setSocket(s);
	}
	
	@Override
	public synchronized void onIncomingBytes(byte[] data)
	{
		// first determine if the received data is a request, or response
		int i = 0;
		int l = data.length;
		byte c=0;
		byte[] buffer = new byte[l];
		int length = 0;
		for (; i<l; i++)
		{
			c = data[i];
			buffer[length] = c;
			length++;
			if (c == 20)
			{
				break;
			}
		}
		String line = decodeString(buffer,length-1);
		
		// if the first word is not an HTTP Method, this the data constitutes a response.
		if (Method.fromString(line) == Method.UNKNOWN)
		{
			ResponseParser parser = new ResponseParser();
			Response resp = parser.parse(data);
			onResponse(resp);
		}
		// otherwise it's a request
		else
		{
			RequestParser parser = new RequestParser();
			Request req = parser.parse(data);
			onRequest(req);
		}
	}
	
	private void onResponse(Response resp)
	{
		if (!resp.isValid()) return;
		Request req = rpl.onResponse(resp);
		if (!req.isValid()) return;
		send(req);
	}
	
	private void onRequest(Request req)
	{
		if (!req.isValid()) return;
		Response resp = rl.onRequest(req);
		if (!resp.isValid()) return;
		send(resp);
	}
	
	// ==== send data =======================================
	
	public synchronized void send(BytePackage req)
	{
		try
		{
			keepAlive();
			sendBytes(req.getBytes());
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
