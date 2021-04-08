package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HAccessControlAllowOrigin implements Header
{
	private Header rawHeader;
	
	public HAccessControlAllowOrigin(Header raw)
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
		return "Access-Control-Allow-Origin";
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
