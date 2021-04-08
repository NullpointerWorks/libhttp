package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

/**
 * 
 */
class HXDNSPrefetchControl implements Header
{
	private Header rawHeader;
	
	public HXDNSPrefetchControl(Header raw)
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
		return "X-DNS-Prefetch-Control";
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
