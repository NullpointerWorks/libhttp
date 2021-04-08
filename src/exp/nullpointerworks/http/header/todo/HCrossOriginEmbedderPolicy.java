package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HCrossOriginEmbedderPolicy implements Header
{
	private Header rawHeader;
	
	public HCrossOriginEmbedderPolicy(Header raw)
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
		return "Cross-Origin-Embedder-Policy";
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
