package exp.nullpointerworks.http.request;

import exp.nullpointerworks.http.Header;

class NullHeader implements Header
{
	public NullHeader()
	{
		
	}
	
	@Override
	public boolean isValid()
	{
		return false;
	}
	
	@Override
	public String getName()
	{
		return "";
	}
	
	@Override
	public String getData()
	{
		return "";
	}
}
