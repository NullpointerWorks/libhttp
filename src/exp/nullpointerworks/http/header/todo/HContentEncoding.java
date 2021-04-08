package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HContentEncoding implements Header
{
	private Header rawHeader;
	
	public HContentEncoding(Header raw)
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
		return "Content-Encoding";
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
