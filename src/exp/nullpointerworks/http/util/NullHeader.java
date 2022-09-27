/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http.util;

import exp.nullpointerworks.http.Header;

public final class NullHeader implements Header
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
