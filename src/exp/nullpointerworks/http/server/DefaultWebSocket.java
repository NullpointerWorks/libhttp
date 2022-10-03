/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http.server;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

import exp.nullpointerworks.http.Method;
import exp.nullpointerworks.http.Protocol;
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
		keepAlive(true);
	}
	
	@Override
	public synchronized void onIncomingBytes(byte[] data)
	{
		// first determine if the received data is a request, or response
		String line = "";
		int i = 0;
		int l = data.length;
		String c = "";
		for (; i<l; i++)
		{
			c = decodeString(data[i]);
			if (c.equalsIgnoreCase(" ")) break;
			line += c;
		}
		
		// if the first word is not an HTTP Method, this the data constitutes a response.
		if (Method.fromString(line) == Method.UNKNOWN)
		{
			ResponseParser parser = new ResponseParser();
			Response resp = parser.parse(data);
			onResponse(resp);
		}
		
		// otherwise it's a request
		else
		if (Protocol.fromString(line) != Protocol.NULL)
		{
			RequestParser parser = new RequestParser();
			Request req = parser.parse(data);
			onRequest(req);
		}
		else
		{
			System.err.println(DefaultWebSocket.class.getName()+": Could not identify the received data to be a request or a response!");
			onUnidentifiedData(data);
		}
	}
	
	private void onResponse(Response resp)
	{
		if (!resp.isValid()) return;
		Request req = rpl.onResponse(resp);
		
		if (req == null) return;
		if (!req.isValid()) return;
		send(req);
	}
	
	private void onRequest(Request req)
	{
		if (!req.isValid()) return;
		Response resp = rl.onRequest(req);
		
		if (resp == null) return;
		if (!resp.isValid()) return;
		send(resp);
	}
	
	public String decodeString(byte data)
	{
		byte[] bytes = {data};
		
		try { return new String(bytes, "ISO-8859-1"); } // RFC 6266 - page 11 
		catch (UnsupportedEncodingException e) { }
		
		var text = new String(bytes);
		return text;
	}
	
	// ==== send data =======================================
	
	public synchronized void onUnidentifiedData(byte[] data)
	{
		
	}
	
	public void send(BytePackage req)
	{
		try
		{
			sendBytes(req.getBytes());
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
