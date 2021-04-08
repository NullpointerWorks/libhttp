package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HAcceptPatch implements Header
{
	private Header rawHeader;
	
	public HAcceptPatch(Header raw)
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
		return "Accept-Patch";
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
