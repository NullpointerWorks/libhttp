/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http.request;

import java.util.List;

import exp.nullpointerworks.http.Header;
import exp.nullpointerworks.http.HeaderType;
import exp.nullpointerworks.http.Method;
import exp.nullpointerworks.http.Parameter;
import exp.nullpointerworks.http.Protocol;
import exp.nullpointerworks.http.Request;
import exp.nullpointerworks.http.header.UnspecifiedHeader;

/**
 * A Request builder class to get access to package private setters.
 * @since 1.0.0
 */
public class RequestBuilder
{
	private AbstractRequest genreq;
	private final List<Parameter> params;
	private final List<Header> headers;
	
	public RequestBuilder(Request req)
	{
		genreq = (AbstractRequest)req;
		params = genreq.getLinkedParameter();
		headers = genreq.getLinkedHeaders();
	}
	
	private boolean containsParameter(String param)
	{
		for (Parameter p : params)
		{
			if (p.getName().equalsIgnoreCase(param)) return true;
		}
		return false;
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
	 * ==== parameters =========================================================
	 */
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public void addParameter(String n, String v)
	{
		addParameter( new Parameter(n,v) );
	}

	/**
	 * 
	 * @since 1.0.0
	 */
	public void addParameter(Parameter param)
	{
		if (!containsParameter(param.getName())) params.add(param);
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public void removeParameter(String param)
	{
		int l = params.size()-1;
		for (;l>=0;l--)
		{
			if (containsParameter(param)) 
			{
				params.remove(l);
				return;
			}
		}
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public void removeParameter(Parameter param)
	{
		removeParameter(param.getName());
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public void removeAllParameters()
	{
		params.clear();
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

	/**
	 * 
	 * @since 1.0.0
	 */
	public void setWebsocketHashCode(int hashCode)
	{
		genreq.setWebsocketHashCode(hashCode);
	}
}
