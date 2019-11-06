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
public enum Encoding
{
	/**
	 * 
	 * @since 1.0.0
	 */
	GZIP("gzip"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	DEFLATE("deflate"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	COMPRESS("compress"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	IDENTITY("identity"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	WILDCARD("*");
	
	private final String type;
	private Encoding(String type) {this.type=type;}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public final String getString() {return type;}
}
