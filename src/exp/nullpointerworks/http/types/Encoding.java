/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http.types;

/**
 * 
 * @since 1.0.0
 * @author Michiel Drost - Nullpointer Works
 */
public class Encoding
{
	private Encoding() {}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public final static String GZIP 		= "gzip";
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public final static String DEFLATE 		= "deflate";
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public final static String COMPRESS 	= "compress";
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public final static String IDENTITY 	= "identity";
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public final static String WILDCARD 	= "*";
}
