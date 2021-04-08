package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

/**
 * Do Not Track
 */
class HNetworkErrorLogging implements Header
{
	private Header rawHeader;
	
	public HNetworkErrorLogging(Header raw)
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
		return "NEL";
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
