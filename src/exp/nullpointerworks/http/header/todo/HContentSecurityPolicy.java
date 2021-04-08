package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HContentSecurityPolicy implements Header
{
	private Header rawHeader;
	
	public HContentSecurityPolicy(Header raw)
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
		return "Content-Security-Policy";
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
