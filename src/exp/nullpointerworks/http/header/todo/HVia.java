package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

/**
 * 
 */
class HVia implements Header
{
	private Header rawHeader;
	
	public HVia(Header raw)
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
		return "Via";
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
