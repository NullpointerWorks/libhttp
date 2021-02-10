package exp.nullpointerworks.http.header;

public enum ContentLanguage 
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
	 * Swiss High German
	 * @since 1.0.0
	 */
	deCH("de-CH"),
	
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
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public final String getString() {return type;}
	private final String type;
	private ContentLanguage(String type) {this.type=type;}
	
	public static ContentLanguage fromName(String extension)
	{
		extension = extension.toLowerCase();
		ContentLanguage[] list = values();
		for (ContentLanguage mt : list)
		{
			if (mt.getString().equals(extension))
			{
				return mt;
			}
		}
		return null;
	}
}
