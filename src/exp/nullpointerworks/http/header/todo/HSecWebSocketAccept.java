package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

/**
 * 
 */
class HSecWebSocketAccept implements Header
{
	private Header rawHeader;
	
	public HSecWebSocketAccept(Header raw)
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
		return "Sec-WebSocket-Accept";
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
