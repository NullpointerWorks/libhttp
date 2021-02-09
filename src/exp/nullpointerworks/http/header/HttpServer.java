package exp.nullpointerworks.http.header;

import exp.nullpointerworks.http.Header;

public class HttpServer implements Header
{
	private String description;
	
	public HttpServer(Header raw)
	{
		description = raw.getData();
	}
	
	public HttpServer(String desc)
	{
		description = desc;
	}
	
	@Override
	public boolean isValid()
	{
		if (description==null) return false;
		return description.length() > 0;
	}
	
	@Override
	public String getName()
	{
		return "Server";
	}
	
	@Override
	public String getData()
	{
		return description;
	}
}
