/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http.header;

/**
 * 
 * @author Michiel Drost - Nullpointer Works
 * @since 1.0.0
 */
public interface Header
{
	/**
	 * 
	 * @since 1.0.0
	 */
	int getHeaderType();
	
	/**
	 * 
	 * @since 1.0.0
	 */
	default String getString()
	{
		return getName()+": "+getData();
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	String getName();
	
	/**
	 * 
	 * @since 1.0.0
	 */
	String getData();
	
	/**
	 * 
	 * @since 1.0.0
	 */
	boolean isNull();
}
