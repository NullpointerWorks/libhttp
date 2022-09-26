/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http.request;

import java.util.ArrayList;
import java.util.List;

import exp.nullpointerworks.http.Header;
import exp.nullpointerworks.http.HeaderType;
import exp.nullpointerworks.http.Method;
import exp.nullpointerworks.http.Protocol;
import exp.nullpointerworks.http.Request;
import exp.nullpointerworks.http.WebSocket;
import exp.nullpointerworks.http.header.NullHeader;
import exp.nullpointerworks.http.util.Parameter;

/**
 * 
 * @since 1.0.0
 */
public class GenericRequest implements Request
{
	final List<Parameter> params;
	final List<Header> headers;
	
	private Method method = null;
	private Protocol protocol = null;
	private String target = null;
	private byte[] req = null;
	private byte[] data = null;
	private WebSocket socket = null;
	
	public GenericRequest()
	{
		params = new ArrayList<Parameter>();
		headers = new ArrayList<Header>();
	}
	
	public GenericRequest(WebSocket s)
	{
		this();
		setWebSocket(s);
	}
	
	@Override
	public boolean isValid()
	{
		if (method==null) return false;
		if (protocol==null) return false;
		if (target==null) return false;
		return true;
	}
	
	/*
	 * ==== getters =========================================================
	 * public
	 */
	
	@Override
	public Method getMethod()
	{
		return method;
	}
	
	@Override
	public Protocol getProtocol()
	{
		return protocol;
	}
	
	@Override
	public String getTarget()
	{
		return target;
	}
	
	@Override
	public Parameter getParameter(String name)
	{
		for (Parameter p : params)
		{
			if (p.getName().equalsIgnoreCase(name))
			{
				return p;
			}
		}
		return new Parameter("","");
	}
	
	@Override
	public Header getHeader(String name)
	{
		for (Header p : headers)
		{
			if (p.getName().equalsIgnoreCase(name))
			{
				return p;
			}
		}
		return new NullHeader();
	}
	
	@Override
	public Header getHeader(HeaderType hdr)
	{
		String name = hdr.getString().toLowerCase();
		return getHeader(name);
	}
	
	@Override
	public byte[] getRequestBytes() 
	{
		return req;
	}
	
	@Override
	public byte[] getBodyData()
	{
		return data;
	}
	
	@Override
	public byte[] getBytes()
	{
		return concatenate(req, data);
	}
	
	@Override
	public WebSocket getWebSocket() 
	{
		return socket;
	}
	
	/*
	 * ==== adders =========================================================
	 * package private
	 */
	
	void addParameter(Parameter p)
	{
		params.add(p);
	}
	
	void addHeader(Header h)
	{
		headers.add(h);
	}
	
	/*
	 * ==== setters =========================================================
	 * package private
	 */
	
	void setMethod(Method m)
	{
		method = m;
	}
	
	void setProtocol(Protocol p)
	{
		protocol = p;
	}
	
	void setTarget(String t)
	{
		target = t;
	}
	
	/**
	 * This method is deprecated and will be deleted in the next major release. Use {@code setRequestBytes(byte[])} instead.
	 */
	@Deprecated
	void setBytes(byte[] r) 
	{
		setRequestBytes(r);
	}
	
	void setRequestBytes(byte[] r) 
	{
		int l = r.length;
		req = new byte[l];
		for (int i=0; i<l; i++) req[i] = r[i];
	}
	
	void setBodyData(byte[] raw)
	{
		// perform a copy to decouple object references
		int l = raw.length;
		data = new byte[l];
		for (int i=0; i<l; i++) data[i] = raw[i];
	}
	
	void setWebSocket(WebSocket soc)
	{
		socket = soc;
	}
	
	
	/*
	 * ==== private =========================================================
	 */
	
	private byte[] concatenate(byte[] arr0, byte[] arr1)
	{
		byte[] totaldata = new byte[arr0.length + arr1.length];
		int i=0;
		for (byte b : arr0)
		{
			totaldata[i] = b;
			i++;
		}
		for (byte b : arr1)
		{
			totaldata[i] = b;
			i++;
		}
		return totaldata;
	}
}
