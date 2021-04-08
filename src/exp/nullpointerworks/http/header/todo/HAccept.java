package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HAccept implements Header
{
	private Header rawHeader;
	
	public HAccept(Header raw)
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
		return "Accept";
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
