package exp.nullpointerworks.http;

public enum HeaderType 
{
	/**
	 * 
	 * @since 1.0.0
	 */
	NULL("null"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ACCEPT("Accept"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ACCEPT_ENCODING("Accept-Encoding"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ACCEPT_LANGUAGE("Accept-Language"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CONNECTION("Connection"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CONTENT_LENGTH("Content-Length"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CONTENT_TYPE("Content-Type"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	DATE("Date"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	HOST("Host"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	SERVER("Server");
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static HeaderType fromString(String header) 
	{
		header = header.toLowerCase();
		HeaderType[] list = HeaderType.values();
		for (HeaderType hd : list)
		{
			if (hd.getString().equals(header))
			{
				return hd;
			}
		}
		return NULL;
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public final String getString() {return text;}
	private final String text;
	private HeaderType(String text) {this.text=text;}
}
