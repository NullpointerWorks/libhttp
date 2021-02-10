package exp.nullpointerworks.http.header;

import exp.nullpointerworks.http.Header;
import exp.nullpointerworks.http.HeaderType;

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
		return HeaderType.SERVER.getString();
	}
	
	@Override
	public String getData()
	{
		return description;
	}
}
