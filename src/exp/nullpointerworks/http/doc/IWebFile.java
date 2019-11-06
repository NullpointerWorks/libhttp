/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http.doc;

import exp.nullpointerworks.http.types.MIMEType;

/**
 * 
 * @since 1.0.0
 */
public interface IWebFile
{
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public boolean isNull();
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public String getName();
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public String getLastModified();
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public String getPath();
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public String getExtension();
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public MIMEType getMIMEType();
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public int getLength();
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public byte[] getBytes();
}