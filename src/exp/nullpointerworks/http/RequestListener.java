/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.http;

/**
 * 
 * @since 1.0.0
 * @author Michiel Drost - Nullpointer Works
 */
public interface RequestListener
{
	/**
	 * 
	 * @since 1.0.0
	 */
	public Response onRequest(Request o);
}
