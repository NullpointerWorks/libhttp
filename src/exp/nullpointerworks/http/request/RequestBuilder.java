/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http.request;

import exp.nullpointerworks.http.Header;
import exp.nullpointerworks.http.HeaderType;
import exp.nullpointerworks.http.Method;
import exp.nullpointerworks.http.Parameter;
import exp.nullpointerworks.http.Protocol;
import exp.nullpointerworks.http.Request;
import exp.nullpointerworks.http.header.GenericHeader;

/**
 * A Request proxy pattern class to get access to setters.
 * @since 1.0.0
 */
public class RequestBuilder
{
	private AbstractRequest genreq;
	
	public RequestBuilder(Request req)
	{
		genreq = (AbstractRequest)req;
	}
	
	/*
	 * ==== adders =========================================================
	 */
	
	/**
	 * 
	 * @param name
	 * @param value
	 * @since 1.0.0
	 */
	public void addParameter(String name, String value)
	{
		addParameter( new Parameter(name, value) );
	}
	
	/**
	 * 
	 * @param p
	 * @since 1.0.0
	 */
	public void addParameter(Parameter p)
	{
		genreq.addParameter(p);
	}
	
	/**
	 * 
	 * @param hname
	 * @param hvalue
	 * @since 1.0.0
	 */
	public void addHeader(String hname, String hvalue)
	{
		addHeader( new GenericHeader(hname, hvalue) );
	}
	
	/**
	 * 
	 * @param htype
	 * @param hvalue
	 * @since 1.0.0
	 */
	public void addHeader(HeaderType htype, String hvalue)
	{
		addHeader( new GenericHeader(htype.getString(), hvalue) );
	}
	
	/**
	 * 
	 * @param h
	 * @since 1.0.0
	 */
	public void addHeader(Header h)
	{
		genreq.addHeader(h);
	}
	
	/*
	 * ==== setters =========================================================
	 */
	
	/**
	 * 
	 * @param m
	 * @since 1.0.0
	 */
	public void setMethod(Method m)
	{
		genreq.setMethod(m);
	}
	
	/**
	 * 
	 * @param p
	 * @since 1.0.0
	 */
	public void setProtocol(Protocol p)
	{
		genreq.setProtocol(p);
	}
	
	/**
	 * 
	 * @param t
	 * @since 1.0.0
	 */
	public void setTarget(String t)
	{
		genreq.setTarget(t);
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public void setBodyData(byte[] bd)
	{
		genreq.setBodyData(bd);
	}
}
