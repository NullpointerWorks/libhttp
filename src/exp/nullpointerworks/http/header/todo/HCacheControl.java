package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HCacheControl implements Header
{
	private Header rawHeader;
	
	public HCacheControl(Header raw)
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
		return "Cache-Control";
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
