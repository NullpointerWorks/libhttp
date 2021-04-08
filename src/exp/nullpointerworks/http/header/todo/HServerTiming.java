package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

/**
 * 
 */
class HServerTiming implements Header
{
	private Header rawHeader;
	
	public HServerTiming(Header raw)
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
		return "Server-Timing";
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
