package exp.nullpointerworks.http.header;

import exp.nullpointerworks.http.Header;

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
		return "Content-Type";
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
