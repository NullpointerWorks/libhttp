package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HAuthorization implements Header
{
	private Header rawHeader;
	
	public HAuthorization(Header raw)
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
		return "Authorization";
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
