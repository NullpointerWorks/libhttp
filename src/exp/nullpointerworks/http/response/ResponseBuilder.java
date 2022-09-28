/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http.response;

import java.util.List;

import exp.nullpointerworks.http.*;
import exp.nullpointerworks.http.header.*;

/**
 * A Response builder class to get access to package private setters.
 * @since 1.0.0
 */
public class ResponseBuilder
{
	private AbstractResponse resp;
	private List<Header> headers;
	
	public ResponseBuilder(Response r)
	{
		this.resp = (AbstractResponse)r;
		headers = resp.getLinkedHeaders();
	}
	
	private boolean containsHeader(String head)
	{
		for (Header h : headers)
		{
			if (h.getName().equalsIgnoreCase(head)) return true;
		}
		return false;
	}
	
	/*
	 * ==== headers =========================================================
	 */
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public void addHeader(String n, String v)
	{
		addHeader( new UnspecifiedHeader(n,v) );
	}

	/**
	 * 
	 * @since 1.0.0
	 */
	public void addHeader(Header h)
	{
		if (!containsHeader(h.getName())) headers.add(h);
	}
	
	/**
	 * 
	 * @param htype
	 * @param hvalue
	 * @since 1.0.0
	 */
	public void addHeader(HeaderType htype, String hvalue)
	{
		addHeader( new UnspecifiedHeader(htype.getString(), hvalue) );
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public void removeHeader(String head)
	{
		int l = headers.size()-1;
		for (;l>=0;l--)
		{
			if (containsHeader(head)) 
			{
				headers.remove(l);
				return;
			}
		}
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public void removeParameter(Header h)
	{
		removeHeader(h.getName());
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public void removeAllHeaders()
	{
		headers.clear();
	}
	
	/*
	 * ==== meta data =========================================================
	 */
	
	/**
	 * 
	 * @param p
	 * @since 1.0.0
	 */
	public void setProtocol(Protocol p)
	{
		resp.setProtocol(p);
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public void setStatusCode(StatusCode sc)
	{
		resp.setStatusCode(sc);
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public void setBodyData(byte[] bd)
	{
		resp.setBodyData(bd);
	}
	
}
