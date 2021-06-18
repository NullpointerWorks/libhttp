/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.http.header;

import exp.nullpointerworks.http.Header;
import exp.nullpointerworks.http.HeaderType;

public class HttpConnection implements Header
{
	private final Header raw;
	private int kaState = -1;
	
	public HttpConnection(Header r)
	{
		raw = r;
		parse(raw);
	}
	
	public HttpConnection(Connection ct)
	{
		this(ct.getBoolean());
	}
	
	public HttpConnection(boolean keepAlive)
	{
		String data = (keepAlive)?"keep-alive":"close";
		kaState = (keepAlive)?1:0;
		raw = new GenericHeader(getName(), data);
	}
	
	@Override
	public String getName()
	{
		return HeaderType.CONNECTION.getString();
	}
	
	@Override
	public String getData()
	{
		return raw.getData();
	}
	
	@Override
	public boolean isValid()
	{
		return kaState != -1;
	}
	
	/*
	 * =================================================================
	 */
	
	private void parse(Header raw)
	{
		String ka = raw.getData();
		if (ka.equalsIgnoreCase("keep-alive"))
		{
			kaState = 1;
		}
		else
		if (ka.equalsIgnoreCase("close"))
		{
			kaState = 0;
		}
		else
		{
			kaState = -1;
		}
	}
	
	public boolean isKeepAlive()
	{
		return (kaState==1)?true:false;
	}
}
