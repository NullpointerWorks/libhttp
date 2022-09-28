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
import exp.nullpointerworks.http.util.NullHeader;

import static exp.nullpointerworks.http.util.NetworkUtil.CRLF;
import static exp.nullpointerworks.http.util.NetworkUtil.concatenate;

/**
 * Though this class is a complete set of code for processing request data, you're not suppose to use this class for constructing one from scratch. Use the {@code DefaultRequest} and {@code RequistBuilder} instead.
 * @since 1.0.0
 */
public abstract class AbstractRequest implements Request
{
	
	private Method method = null;
	private Protocol protocol = null;
	private String target = null;
	private byte[] bodyData = null;
	private List<Parameter> params;
	private List<Header> headers;
	
	public AbstractRequest()
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
	public List<Parameter> getParameters()
	{
		return new ArrayList<Parameter>(params);
	}

	@Override
	public List<Header> getHeaders()
	{
		return new ArrayList<Header>(headers);
	}
	
	@Override
	public byte[] getBodyData()
	{
		return bodyData;
	}

	@Override
	public final byte[] getBytes()
	{
		if (!isValid()) return new byte[] {};
		
		// create the first line which has the method, target page, optional parameters and the protocol
		String methodLine = method.toString()+" "+target;
		if (params.size() > 0)
		{
			methodLine += "?";
			for (int i=0, l=params.size()-1; i<=l; i++)
			{
				Parameter p = params.get(i);
				String par = p.getName()+"="+p.getValue() + ((i<l)?"&":"");
				methodLine += par;
			}
		}
		methodLine += " "+protocol.getString()+CRLF;
		byte[] bData = methodLine.getBytes();
		
		// create header strings
		for (Header h : headers)
		{
			byte[] bHeader = (h.getString()+CRLF).getBytes();
			bData = concatenate(bData, bHeader);
		}
		bData = concatenate(bData, CRLF.getBytes());
		
		// if there's body data to send to the server, include it as well
		if (bodyData.length > 0)
		{
			bData = concatenate(bData, bodyData);
		}
		
		// done
		return bData;
	}
	
	/*
	 * ==== adders =========================================================
	 * package private
	 */
	
	List<Parameter> getLinkedParameter()
	{
		return params;
	}
	
	List<Header> getLinkedHeaders()
	{
		return headers;
	}
	
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
