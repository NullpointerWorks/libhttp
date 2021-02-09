package exp.nullpointerworks.http.request;

import exp.nullpointerworks.http.Header;
import exp.nullpointerworks.http.Method;
import exp.nullpointerworks.http.Protocol;
import exp.nullpointerworks.http.util.Parameter;

/**
 * 
 * @since 1.0.0
 */
public class CreatorRequest extends GenericRequest 
{
	public CreatorRequest()
	{
		super();
	}
	
	/*
	 * ==== adders =========================================================
	 */
	
	@Override
	public void addParameter(Parameter p)
	{
		super.addParameter(p);
	}
	
	@Override
	public void addHeader(Header h)
	{
		super.addHeader(h);
	}
	
	/*
	 * ==== setters =========================================================
	 */
	
	@Override
	public void setMethod(Method m)
	{
		super.setMethod(m);
	}
	
	@Override
	public void setProtocol(Protocol p)
	{
		super.setProtocol(p);
	}
	
	@Override
	public void setTarget(String t)
	{
		super.setTarget(t);
	}
	
	@Override
	public void setBodyData(byte[] raw)
	{
		super.setBodyData(raw);
	}
}
