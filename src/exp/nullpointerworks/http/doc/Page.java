package exp.nullpointerworks.http.doc;

/**
 * 
 * @since 1.0.0
 */
public interface Page
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
	public String getMIMEType();
	
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