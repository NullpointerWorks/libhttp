package exp.nullpointerworks.http.header;

import exp.nullpointerworks.http.Header;

public class ServerHeader implements Header
{
	private String description;
	
	public ServerHeader(Header raw)
	{
		description = raw.getData();
	}
	
	public ServerHeader(String desc)
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
