package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HAllow implements Header
{
	private Header rawHeader;
	
	public HAllow(Header raw)
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
		return "Allow";
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
