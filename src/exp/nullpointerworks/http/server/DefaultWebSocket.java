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
import exp.nullpointerworks.http.request.BytesRequest;
import exp.nullpointerworks.http.request.RequestBuilder;
import exp.nullpointerworks.http.util.BytePackage;
import exp.nullpointerworks.http.util.RequestParser;
import exp.nullpointerworks.http.util.ResponseParser;

/**
 * 
 * @since 1.0.0
 */
public abstract class DefaultWebSocket extends AbstractWebSocket implements RequestListener, ResponseListener
{
	/**
	 * 
	 * @since 1.0.0
	 */
	public DefaultWebSocket(Socket s) throws IOException
	{
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
		
		Request req = null;
		
		// if the first word is an HTTP Method, then this data constitutes a request.
		if (Method.fromString(line) != Method.UNKNOWN)
		{
			RequestParser parser = new RequestParser();
			req = parser.parse(data);
		}
		else
		// otherwise it's probably a response
		if (Protocol.fromString(line) != Protocol.NULL)
		{
			ResponseParser parser = new ResponseParser();
			Response resp = parser.parse(data);
			Request q = onResponse(resp); // don't send request down
			if (q!=null) send(q);
			return;
		}
		else
		{
			req = new BytesRequest(data);
		}
		
		new RequestBuilder(req).setWebSocket(this);
		Response resp = onRequest(req);
		if (resp!=null) send(resp);
	}
	
	// ==== send data =======================================
	
	public void send(BytePackage bp)
	{
		if (bp==null) return;
		try
		{
			sendBytes(bp.getBytes());
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public String decodeString(byte data)
	{
		byte[] bytes = {data};
		
		try { return new String(bytes, "ISO-8859-1"); } // RFC 6266 - page 11 
		catch (UnsupportedEncodingException e) { }
		
		var text = new String(bytes);
		return text;
	}
}
