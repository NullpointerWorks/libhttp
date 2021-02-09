package exp.nullpointerworks.http.request;

import java.util.ArrayList;
import java.util.List;

import exp.nullpointerworks.http.Header;
import exp.nullpointerworks.http.HeaderType;
import exp.nullpointerworks.http.Method;
import exp.nullpointerworks.http.Protocol;
import exp.nullpointerworks.http.Request;
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
	private byte[] data;
	
	public GenericRequest()
	{
		params = new ArrayList<Parameter>();
		headers = new ArrayList<Header>();
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
	 * ==== finders =========================================================
	 */
	
	@Override
	public Parameter findParameter(String name)
	{
		for (Parameter p : params)
		{
			if (p.getName().equalsIgnoreCase(name))
			{
				return p;
			}
		}
		return new Parameter("", ""); // null parameter
	}
	
	@Override
	public Header findHeader(String name)
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
	public Header findHeader(HeaderType hdr)
	{
		String name = hdr.getString().toLowerCase();
		return findHeader(name);
	}
	
	/*
	 * ==== getters =========================================================
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
	public byte[] getBodyData()
	{
		return data;
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
	
	void setBodyData(byte[] raw)
	{
		// perform a copy to decouple references
		int l = raw.length;
		data = new byte[l];
		for (int i=0; i<l; i++) data[i] = raw[i];
	}
}
