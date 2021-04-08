package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HClearSiteData implements Header
{
	private Header rawHeader;
	
	public HClearSiteData(Header raw)
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
		return "Clear-Site-Data";
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
