package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HContentDisposition implements Header
{
	private Header rawHeader;
	
	public HContentDisposition(Header raw)
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
		return "Content-Disposition";
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
