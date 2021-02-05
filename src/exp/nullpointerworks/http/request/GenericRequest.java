package exp.nullpointerworks.http.request;

import java.util.ArrayList;
import java.util.List;

import exp.nullpointerworks.http.Header;
import exp.nullpointerworks.http.Method;
import exp.nullpointerworks.http.Protocol;
import exp.nullpointerworks.http.Request;
import exp.nullpointerworks.http.header.NullHeader;
import exp.nullpointerworks.http.util.Parameter;

public class GenericRequest implements Request
{
	private Method method = null;
	private Protocol protocol = null;
	private String target = null;
	private byte[] data;
	
	private List<Parameter> params;
	private List<Header> headers;
	
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
	
	/*
	 * ==== adders =========================================================
	 */
	
	@Override
	public void addParameter(Parameter p)
	{
		params.add(p);
	}
	
	@Override
	public void addHeader(Header h)
	{
		headers.add(h);
	}
	
	/*
	 * ==== setters =========================================================
	 */
	
	@Override
	public void setMethod(Method m)
	{
		method = m;
	}
	
	@Override
	public void setProtocol(Protocol p)
	{
		protocol = p;
	}
	
	@Override
	public void setTarget(String t)
	{
		target = t;
	}

	@Override
	public void setBodyData(byte[] raw)
	{
		data = raw;
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
}
