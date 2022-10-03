package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HAccessControlRequestHeaders implements Header
{
	private Header rawHeader;
	
	public HAccessControlRequestHeaders(Header raw)
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
		return "Access-Control-Request-Headers";
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
