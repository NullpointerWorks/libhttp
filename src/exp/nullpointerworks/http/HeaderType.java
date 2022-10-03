/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
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
	ACCEPT_PATCH("Accept-Patch"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ACCEPT_RANGES("Accept-Ranges"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ACCEPT_TRANSFER_ENCODING("TE"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ACCESS_CONTROL_ALLOW_CREDENTIALS("Access-Control-Allow-Credentials"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ACCESS_CONTROL_ALLOW_HEADERS("Access-Control-Allow-Headers"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ACCESS_CONTROL_ALLOW_METHODS("Access-Control-Allow-Methods"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ACCESS_CONTROL_ALLOW_ORIGIN("Access-Control-Allow-Origin"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ACCESS_CONTROL_EXPOSE_HEADERS("Access-Control-Expose-Headers"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ACCESS_CONTROL_MAX_AGE("Access-Control-Max-Age"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ACCESS_CONTROL_REQUEST_HEADERS("Access-Control-Request-Headers"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ACCESS_CONTROL_REQUEST_METHOD("Access-Control-Request-Method"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	AGE("Age"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ALLOW("Allow"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ALT_SVC("Alt-Svc"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	AUTHORIZATION("Authorization"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CACHE_CONTROL("Cache-Control"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CLEAR_SITE_DATA("Clear-Site-Data"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CONNECTION("Connection"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CONTENT_DISPOSITION("Content-Disposition"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CONTENT_ENCODING("Content-Encoding"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CONTENT_LANGUAGE("Content-Language"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CONTENT_LOCATION("Content-Location"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CONTENT_RANGE("Content-Range"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CONTENT_SECURITY_POLICY("Content-Security-Policy"),
	
	
	
	
	
	
	
	
	
	
	
	
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
