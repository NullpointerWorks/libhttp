package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HAccessControlMaxAge implements Header
{
	private Header rawHeader;
	
	public HAccessControlMaxAge(Header raw)
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
		return "Access-Control-Max-Age";
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
