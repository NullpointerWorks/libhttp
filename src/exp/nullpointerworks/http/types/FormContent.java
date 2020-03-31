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
public enum FormContent
{
	/**
	 * 
	 * @since 1.0.0
	 */
	NULL(""),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	URLENCODED("application/x-www-form-urlencoded"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	TEXTPLAIN("text/plain"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	MULTIPART("multipart/form-data");
	
	private final String type;
	private FormContent(String type) 
	{
		this.type=type;
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public final String getString() {return type;}
}
