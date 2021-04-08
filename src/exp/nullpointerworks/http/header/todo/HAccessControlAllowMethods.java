package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HAccessControlAllowMethods implements Header
{
	private Header rawHeader;
	
	public HAccessControlAllowMethods(Header raw)
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
		return "Access-Control-Allow-Methods";
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
