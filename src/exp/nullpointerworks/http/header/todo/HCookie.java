package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HCookie implements Header
{
	private Header rawHeader;
	
	public HCookie(Header raw)
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
		return "Cookie";
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
