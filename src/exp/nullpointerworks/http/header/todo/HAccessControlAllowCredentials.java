package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HAccessControlAllowCredentials implements Header
{
	private Header rawHeader;
	
	public HAccessControlAllowCredentials(Header raw)
	{
		rawHeader = raw;
		parse(rawHeader);
	}
	
	private void parse(Header raw)
	{
		
	}
	
	@Override
	public String getName()
	{
		return "Access-Control-Allow-Credentials";
	}
	
	@Override
	public String getData()
	{
		return "";
	}
	
	@Override
	public boolean isValid()
	{
		return false;
	}
}
