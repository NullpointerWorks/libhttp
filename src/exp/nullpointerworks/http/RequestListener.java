/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2021)
 * Use is subject to license terms.
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
