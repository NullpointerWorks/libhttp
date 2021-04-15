/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.http.request;

import exp.nullpointerworks.http.Header;
import exp.nullpointerworks.http.Method;
import exp.nullpointerworks.http.Protocol;
import exp.nullpointerworks.http.Request;
import exp.nullpointerworks.http.util.Parameter;

/**
 * Request adapter class to get access to setters.
 * @since 1.0.0
 */
public class RequestBuilder
{
	private GenericRequest genreq;
	
	public RequestBuilder(Request req)
	{
		genreq = (GenericRequest)req;
	}
	
	/*
	 * ==== adders =========================================================
	 */
	
	public void addParameter(Parameter p)
	{
		genreq.addParameter(p);
	}
	
	public void addHeader(Header h)
	{
		genreq.addHeader(h);
	}
	
	/*
	 * ==== setters =========================================================
	 */
	
	public void setMethod(Method m)
	{
		genreq.setMethod(m);
	}
	
	public void setProtocol(Protocol p)
	{
		genreq.setProtocol(p);
	}
	
	public void setTarget(String t)
	{
		genreq.setTarget(t);
	}
	
	public void setBodyData(byte[] raw)
	{
		genreq.setBodyData(raw);
	}
}
