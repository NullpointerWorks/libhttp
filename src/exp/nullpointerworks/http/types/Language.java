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
public enum Language
{
	/**
	 * Dutch
	 * @since 1.0.0
	 */
	NL("nl"),
	
	/**
	 * German
	 * @since 1.0.0
	 */
	DE("de"),
	
	/**
	 * English
	 * @since 1.0.0
	 */
	EN("en"),
	
	/**
	 * English-USA
	 * @since 1.0.0
	 */
	US("en-US"),
	
	/**
	 * English-Britain
	 * @since 1.0.0
	 */
	GB("en-GB"),
	
	/**
	 * French
	 * @since 1.0.0
	 */
	FR("fr"),
	
	/**
	 * French Canadian
	 * @since 1.0.0
	 */
	frCA("fr-CA"),
	
	/**
	 * French Swiss
	 * @since 1.0.0
	 */
	frCH("fr-CH");
	
	private final String type;
	private Language(String type) {this.type=type;}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public final String getString() {return type;}
}
