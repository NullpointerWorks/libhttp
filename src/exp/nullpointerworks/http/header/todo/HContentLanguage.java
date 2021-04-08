package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HContentLanguage implements Header
{
	private Header rawHeader;
	
	public HContentLanguage(Header raw)
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
		return "Content-Language";
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
