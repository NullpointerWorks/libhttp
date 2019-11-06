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
public enum HeaderType
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
	UNKNOWN_HEADER("unknown"),
	
	// ========================================================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CONNECTION("connection"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	DATE("date"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	PRAGMA("pragma"),// http/1.0
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CACHE_CONTROL("cache-control"),// http/1.1 (expires and pragma)
	
	/**
	 * 
	 * @since 1.0.0
	 */
	TRAILER("trailer"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	TRANSFER_ENCODING("transfer-encoding"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	UPGRADE("upgrade"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	VIA("via"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	WARNING("warning"),
	
	// ========================================================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ACCEPT("accept"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ACCEPT_LANGUAGE("accept-language"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ACCEPT_ENCODING("accept-encoding"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ACCEPT_CHARSET("accept-charset"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	AUTHORIZATION("authorization"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	COOKIE("cookie"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	EXPECT("expect"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	FROM("from"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	HOST("host"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	IF_MATCH("if-match"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	IF_MODIFIED_SINCE("if-modified-since"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	IF_NONE_MATCH("if-none-match"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	IF_RANGE("if-range"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	IF_UNMODIFIED_SINCE("if-modified-since"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	MAX_FORWARDS("max-forwards"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	PROXY_AUTHORIZATION("proxy-authorization"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	RANGE("range"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	REFERER("referer"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	TE("te"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	USER_AGENT("user-agent"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	UPGRADE_INSECURE_REQUESTS("upgrade-insecure-requests"),
	
	// ========================================================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ACCEPT_RANGES("accept-ranges"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	AGE("age"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CONTENT_DISPOSITION("content-disposition"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ETAG("etag"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	LOCATION("location"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	PROXY_AUTHENTICATE("proxy-authenticate"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	RETRY_AFTER("retry-after"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	SERVER("server"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	SET_COOKIE("set-cookie"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	VARY("vary"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	WWW_AUTHENTICATE("www-authenticate"),
	
	// ========================================================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ALLOW("allow"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CONTENT_ENCODING("content-encoding"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CONTENT_LANGUAGE("content-language"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CONTENT_LENGTH("content-length"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CONTENT_LOCATION("content-location"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CONTENT_MD5("content-md5"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CONTENT_RANGE("content-range"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CONTENT_TYPE("content-type"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	EXPIRES("expires"),// http/1.0
	
	/**
	 * 
	 * @since 1.0.0
	 */
	LAST_MODIFIED("last-modified");
	
	private final String type;
	private HeaderType(String type) {this.type=type;}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public final String getString() {return type;}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final HeaderType fromString(String header)
	{
		header = header.toLowerCase();
		switch(header)
		{
			// =============================== General Headers
		case "connection": return CONNECTION;
		case "date": return DATE; 
		case "pragma": return PRAGMA; 
		case "cache-control": return CACHE_CONTROL; 
		case "trailer": return TRAILER; 
		case "transfer-encoding": return TRANSFER_ENCODING; 
		case "upgrade": return UPGRADE; 
		case "via": return VIA; 
		case "warning": return WARNING; 
			
			// =============================== Client Request Headers
		case "accept": return ACCEPT; 
		case "accept-language":return ACCEPT_LANGUAGE; 
		case "accept-encoding":return ACCEPT_ENCODING; 
		case "accept-charset":return ACCEPT_CHARSET; 
		case "authorization": return AUTHORIZATION; 
		case "cookie": return COOKIE; 
		case "expect": return EXPECT; 
		case "from": return FROM; 
		case "host":return HOST; 
		case "if-match": return IF_MATCH; 
		case "if-modified-since": return IF_MODIFIED_SINCE; 
		case "if-none-match": return IF_NONE_MATCH; 
		case "if-range": return IF_RANGE; 
		case "if-unmodified-since": return IF_UNMODIFIED_SINCE; 
		case "max-forwards": return MAX_FORWARDS; 
		case "proxy-authorization": return PROXY_AUTHORIZATION; 
		case "range": return RANGE; 
		case "referer": return REFERER; 
		case "te": return TE; 
		case "user-agent":return USER_AGENT; 
		case "upgrade-insecure-requests": return UPGRADE_INSECURE_REQUESTS; 
			
			// =============================== Server Response Headers
		case "accept-ranges": return ACCEPT_RANGES; 
		case "age": return AGE; 
		case "content-disposition":return CONTENT_DISPOSITION; 
		case "etag": return ETAG; 
		case "location": return LOCATION; 
		case "proxy-authenticate": return PROXY_AUTHENTICATE; 
		case "retry-after": return RETRY_AFTER; 
		case "server": return SERVER; 
		case "set-cookie": return SET_COOKIE; 
		case "vary": return VARY; 
		case "www-authenticate": return WWW_AUTHENTICATE; 
			
			// =============================== Entity Headers
		case "allow": return ALLOW; 
		case "content-encoding": return CONTENT_ENCODING; 
		case "Content-language": return CONTENT_LANGUAGE; 
		case "content-length": return CONTENT_LENGTH; 
		case "content-location": return CONTENT_LOCATION; 
		case "content-md5": return CONTENT_MD5; 
		case "content-range": return CONTENT_RANGE; 
		case "content-type": return CONTENT_TYPE; 
		case "expires": return EXPIRES; 
		case "last-modified": return LAST_MODIFIED; 
			
			// ===============================
		default: return UNKNOWN_HEADER; 
		}
	}
}
