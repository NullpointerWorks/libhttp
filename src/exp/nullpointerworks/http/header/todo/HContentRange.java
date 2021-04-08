package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HContentRange implements Header
{
	private Header rawHeader;
	
	public HContentRange(Header raw)
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
		return "Content-Range";
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
