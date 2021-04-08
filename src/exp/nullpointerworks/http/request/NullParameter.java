/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.http.request;

import exp.nullpointerworks.http.util.Parameter;

final class NullParameter extends Parameter
{
	public NullParameter() 
	{
		super("","");
	}
	
	@Override
	public boolean isValid()
	{
		return false;
	}
}
