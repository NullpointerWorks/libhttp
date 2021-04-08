/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.http.request;

import java.util.List;

import exp.nullpointerworks.http.Header;
import exp.nullpointerworks.http.HeaderType;
import exp.nullpointerworks.http.Method;
import exp.nullpointerworks.http.Protocol;
import exp.nullpointerworks.http.Request;
import exp.nullpointerworks.http.util.Parameter;

/**
 * 
 * @since 1.0.0
 */
public class DebugRequest implements Request
{
	private final GenericRequest req;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public DebugRequest(Request r)
	{
		req = (GenericRequest)r;
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public List<Parameter> getParameters()
	{
		return req.params;
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public List<Header> getHeaders()
	{
		return req.headers;
	}
	
	@Override
	public boolean isValid() 
	{
		return req.isValid();
	}
	
	@Override
	public Parameter findParameter(String name) 
	{
		return req.findParameter(name);
	}
	
	@Override
	public Header findHeader(String name) 
	{
		return req.findHeader(name);
	}
	
	@Override
	public Header findHeader(HeaderType hdr) 
	{
		return req.findHeader(hdr);
	}
	
	@Override
	public Method getMethod() 
	{
		return req.getMethod();
	}
	
	@Override
	public Protocol getProtocol() 
	{
		return req.getProtocol();
	}
	
	@Override
	public String getTarget() 
	{
		return req.getTarget();
	}
	
	@Override
	public byte[] getBodyData() 
	{
		return req.getBodyData();
	}
}
