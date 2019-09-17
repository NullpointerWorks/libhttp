/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http.types;

/**
 * 
 * @since 1.0.0
 */
public class ContentType
{
	private ContentType() {}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public final static int FORM_URLENCODED = 0;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public final static int FORM_MULTIPART 	= 1;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public final static String getString(int type)
	{
		switch(type)
		{
		case 0: return "application/x-www-form-urlencoded";
		case 1: return "multipart/form-data";
		default: return "";
		}
	}
}
