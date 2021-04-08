package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HAltSvc implements Header
{
	private Header rawHeader;
	
	public HAltSvc(Header raw)
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
		return "Alt-Svc";
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
