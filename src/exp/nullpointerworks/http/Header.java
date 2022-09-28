/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http;

import exp.nullpointerworks.http.Header;

public interface Header
{
	public boolean isValid();
	
	public String getName();
	
	public String getData();
	
	default String getString()
	{
		return getName() + ": " + getData();
	}
}
