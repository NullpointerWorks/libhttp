package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HAcceptRanges implements Header
{
	private Header rawHeader;
	
	public HAcceptRanges(Header raw)
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
		return "Accept-Ranges";
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
