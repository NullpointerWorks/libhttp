package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

/**
 * Note that "Referer" is actually misspelled. It should have been "Referrer".
 */
class HReferer implements Header
{
	private Header rawHeader;
	
	public HReferer(Header raw)
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
		return "Referer";
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
