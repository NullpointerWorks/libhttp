package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HAcceptLanguage implements Header
{
	private Header rawHeader;
	
	public HAcceptLanguage(Header raw)
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
		return "Accept-Language";
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
