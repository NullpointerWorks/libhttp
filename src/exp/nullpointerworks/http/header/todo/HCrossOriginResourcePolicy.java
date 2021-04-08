package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HCrossOriginResourcePolicy implements Header
{
	private Header rawHeader;
	
	public HCrossOriginResourcePolicy(Header raw)
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
		return "Cross-Origin-Resource-Policy";
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
