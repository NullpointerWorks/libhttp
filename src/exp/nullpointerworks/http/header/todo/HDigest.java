package exp.nullpointerworks.http.header.todo;

import exp.nullpointerworks.http.Header;

class HDigest implements Header
{
	private Header rawHeader;
	
	public HDigest(Header raw)
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
		return "Digest";
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
