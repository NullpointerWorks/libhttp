package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HContentLocation implements Header
{
	private Header rawHeader;
	
	public HContentLocation(Header raw)
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
		return "Content-Location";
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
