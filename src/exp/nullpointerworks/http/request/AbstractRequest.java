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
import exp.nullpointerworks.http.Parameter;
import exp.nullpointerworks.http.Protocol;
import exp.nullpointerworks.http.Request;
import exp.nullpointerworks.http.header.NullHeader;

/**
 * 
 * @since 1.0.0
 */
public abstract class AbstractRequest implements Request
{
	final List<Parameter> params;
	final List<Header> headers;
	
	private Method method = null;
	private Protocol protocol = null;
	private String target = null;
	
	private byte[] bodyData;
	
	public AbstractRequest()
	{
		params = new ArrayList<Parameter>();
		headers = new ArrayList<Header>();
		bodyData = new byte[]{};
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
	public byte[] getBodyData()
	{
		return bodyData;
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
	
	void setBodyData(byte[] raw)
	{
		int l = raw.length;
		bodyData = new byte[l];
		for (int i=0; i<l; i++) bodyData[i] = raw[i];
	}
	
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
}
