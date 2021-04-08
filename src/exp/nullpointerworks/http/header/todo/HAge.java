package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HAge implements Header
{
	private Header rawHeader;
	
	public HAge(Header raw)
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
		return "Age";
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
