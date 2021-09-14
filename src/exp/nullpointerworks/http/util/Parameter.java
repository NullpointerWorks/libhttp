/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.http.util;

public class Parameter
{
	private final String name;
	private final String value;
	
	public Parameter(String n, String v)
	{
		name = n;
		value = v;
	}
	
	public boolean isValid()
	{
		return name.length() > 0;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getValue()
	{
		return value;
	}
}
