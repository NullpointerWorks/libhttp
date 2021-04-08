package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

/**
 * 
 */
class HSourceMap implements Header
{
	private Header rawHeader;
	
	public HSourceMap(Header raw)
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
		return "SourceMap";
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
