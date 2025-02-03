/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http;

/**
 * 
 * @since 1.0.0
 * @author Michiel Drost - Nullpointer Works
 */
public interface ResponseListener
{
	/**
	 * 
	 * @since 1.0.0
	 */
	public Request onResponse(Response r);
}
