package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HCrossOriginOpenerPolicy implements Header
{
	private Header rawHeader;
	
	public HCrossOriginOpenerPolicy(Header raw)
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
		return "Cross-Origin-Opener-Policy";
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
