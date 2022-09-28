/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.http.header;

import exp.nullpointerworks.http.Header;
import exp.nullpointerworks.http.HeaderType;

public class HttpContentLength implements Header
{
	private final Header raw;
	private int length = -1;
	
	public HttpContentLength(Header r)
	{
		raw = r;
		parse(raw);
	}
	
	public HttpContentLength(int l)
	{
		raw = new UnspecifiedHeader(getName(), ""+l);
		length = l;
	}
	
	private void parse(Header raw)
	{
		String s = raw.getData();
		if (s.matches("([\\+-]?\\d+)?"))
		{
			length = Integer.parseInt(s);
		}
	}
	
	@Override
	public boolean isValid()
	{
		return length >= 0;
	}
	
	@Override
	public String getName()
	{
		return HeaderType.CONTENT_LENGTH.getString();
	}
	
	@Override
	public String getData()
	{
		return raw.getData();
	}
	
	public int getContentLength()
	{
		return length;
	}
}
