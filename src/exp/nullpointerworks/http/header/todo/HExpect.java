package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

/**
 * Do Not Track
 */
class HExpect implements Header
{
	private Header rawHeader;
	
	public HExpect(Header raw)
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
		return "Expect";
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
