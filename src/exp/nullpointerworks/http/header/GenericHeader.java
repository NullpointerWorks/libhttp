package exp.nullpointerworks.http.header;

import exp.nullpointerworks.http.Header;

public final class GenericHeader implements Header
{
	private final boolean isValid;
	private final String hname;
	private final String hdata;
	
	public GenericHeader(String n, String d)
	{
		hname = n;
		hdata = d;
		isValid = true;
	}
	
	@Override
	public boolean isValid()
	{
		return isValid;
	}
	
	@Override
	public String getName()
	{
		return hname;
	}
	
	@Override
	public String getData()
	{
		return hdata;
	}
}
