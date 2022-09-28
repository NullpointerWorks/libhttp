/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http.header;

import exp.nullpointerworks.http.Header;

public class UnspecifiedHeader implements Header
{
	private final String hname;
	private final String hdata;
	
	public UnspecifiedHeader()
	{
		hname = "";
		hdata = "";
	}
	
	public UnspecifiedHeader(String n, String d)
	{
		hname = n;
		hdata = d;
	}
	
	public boolean isValid()
	{
		if (hname.length()<1) return false;
		if (hdata.length()<1) return false;
		return true;
	}
	
	public String getName()
	{
		return hname;
	}
	
	public String getData()
	{
		return hdata;
	}
}
