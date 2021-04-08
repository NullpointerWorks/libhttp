package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

/**
 * Do Not Track
 */
class HIfMatch implements Header
{
	private Header rawHeader;
	
	public HIfMatch(Header raw)
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
		return "If-Match";
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
