/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.http.header;

import exp.nullpointerworks.http.Header;
import exp.nullpointerworks.http.HeaderType;

public class HttpContentType implements Header
{
	private final Header raw;
	private ContentType ct = null;
	
	public HttpContentType(Header r)
	{
		raw = r;
		parse(raw);
	}
	
	public HttpContentType(ContentType ct)
	{
		raw = new GenericHeader(getName(), ct.getString());
		this.ct=ct;
	}
	
	@Override
	public String getName()
	{
		return HeaderType.CONTENT_TYPE.getString();
	}
	
	@Override
	public String getData()
	{
		return raw.getData();
	}
	
	@Override
	public boolean isValid()
	{
		return ct != null;
	}
	
	/*
	 * TODO check for charset
	 */
	private void parse(Header raw)
	{
		String d = raw.getData();
		ct = ContentType.fromContentType(d);
	}
	
	public ContentType getContentType()
	{
		return ct;
	}
	
	public boolean equals(ContentType ct)
	{
		return ct == this.ct;
	}
}
