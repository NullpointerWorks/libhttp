/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http;

import exp.nullpointerworks.http.types.MediaType;

/**
 * 
 * @since 1.0.0
 * @author Michiel Drost - Nullpointer Works
 */
public interface Resource 
{
	/**
	 * 
	 * @since 1.0.0
	 */
	boolean isNull();
	
	/**
	 * 
	 * @since 1.0.0
	 */
	String getName();
	
	/**
	 * 
	 * @since 1.0.0
	 */
	String getLastModified();
	
	/**
	 * 
	 * @since 1.0.0
	 */
	String getPath();
	
	/**
	 * 
	 * @since 1.0.0
	 */
	MediaType getMediaType();
	
	/**
	 * 
	 * @since 1.0.0
	 */
	String getExtension();
	
	/**
	 * 
	 * @since 1.0.0
	 */
	byte[] getBytes();
	
	/**
	 * 
	 * @since 1.0.0
	 */
	int getLength();
}
