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
public class HeaderType
{
	private HeaderType() {}

	/**
	 * 
	 * @since 1.0.0
	 */
	public static final String getStringFromCode(int code)
	{
		switch(code)
		{
			// =============================== General Headers
		case CONNECTION: return "connection";
		case DATE: return "date"; 
		case PRAGMA: return "pragma"; 
		case CACHE_CONTROL: return "cache-control"; 
		case TRAILER: return "trailer"; 
		case TRANSFER_ENCODING: return "transfer-encoding"; 
		case UPGRADE: return "upgrade"; 
		case VIA: return "via"; 
		case WARNING: return "warning"; 
			
			// =============================== Client Request Headers
		case ACCEPT: return "accept"; 
		case ACCEPT_LANGUAGE: return "accept-language"; 
		case ACCEPT_ENCODING: return "accept-encoding"; 
		case ACCEPT_CHARSET: return "accept-charset"; 
		case AUTHORIZATION: return "authorization"; 
		case COOKIE: return "cookie"; 
		case EXPECT: return "expect"; 
		case FROM: return "from"; 
		case HOST: return "host"; 
		case IF_MATCH: return "if-match"; 
		case IF_MODIFIED_SINCE: return "if-modified-since"; 
		case IF_NONE_MATCH: return "if-none-match"; 
		case IF_RANGE: return "if-range"; 
		case IF_UNMODIFIED_SINCE: return "if-unmodified-since"; 
		case MAX_FORWARDS: return "max-forwards"; 
		case PROXY_AUTHORIZATION: return "proxy-authorization"; 
		case RANGE: return "range"; 
		case REFERER: return "referer"; 
		case TE: return "te"; 
		case USER_AGENT:return "user-agent"; 
		case UPGRADE_INSECURE_REQUESTS: return "upgrade-insecure-requests"; 
			
			// =============================== Server Response Headers
		case ACCEPT_RANGES: return "accept-ranges"; 
		case AGE: return "age"; 
		case CONTENT_DISPOSITION:return "content-disposition"; 
		case ETAG: return "etag"; 
		case LOCATION: return "location"; 
		case PROXY_AUTHENTICATE: return "proxy-authenticate"; 
		case RETRY_AFTER: return "retry-after"; 
		case SERVER: return "server"; 
		case SET_COOKIE: return "set-cookie"; 
		case VARY: return "vary"; 
		case WWW_AUTHENTICATE: return "www-authenticate"; 
			
			// =============================== Entity Headers
		case ALLOW: return "allow"; 
		case CONTENT_ENCODING: return "content-encoding"; 
		case CONTENT_LANGUAGE: return "Content-language"; 
		case CONTENT_LENGTH: return "content-length"; 
		case CONTENT_LOCATION: return "content-location"; 
		case CONTENT_MD5: return "content-md5"; 
		case CONTENT_RANGE: return "content-range"; 
		case CONTENT_TYPE: return "content-type"; 
		case EXPIRES: return "expires"; 
		case LAST_MODIFIED: return "last-modified"; 
			
			// ===============================
		default: return "unknown"; 
		}
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int getCodeFromString(String header)
	{
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
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int NULL 				= -1;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int UNKNOWN_HEADER 		= 0;
	
	// ========================================================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int CONNECTION 			= 1;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int DATE 				= 2;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int PRAGMA 				= 3;// http/1.0
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int CACHE_CONTROL 		= 4;// http/1.1 (expires and pragma)
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int TRAILER 			= 5;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int TRANSFER_ENCODING 	= 6;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int UPGRADE 			= 7;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int VIA 				= 8;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int WARNING 			= 9;
	
	// ========================================================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int ACCEPT 				= 10;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int ACCEPT_LANGUAGE 	= 11;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int ACCEPT_ENCODING 	= 12;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int ACCEPT_CHARSET 		= 13;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int AUTHORIZATION 		= 14;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int COOKIE 				= 15;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int EXPECT 				= 16;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int FROM 				= 17;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int HOST 				= 18;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int IF_MATCH 			= 19;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int IF_MODIFIED_SINCE 	= 20;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int IF_NONE_MATCH 		= 21;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int IF_RANGE 			= 22;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int IF_UNMODIFIED_SINCE = 23;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int MAX_FORWARDS 		= 24;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int PROXY_AUTHORIZATION = 25;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int RANGE 				= 26;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int REFERER 			= 27;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int TE 					= 28;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int USER_AGENT 			= 29;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int UPGRADE_INSECURE_REQUESTS = 30;
	
	// ========================================================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int ACCEPT_RANGES 		= 31;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int AGE 				= 32;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int CONTENT_DISPOSITION = 33;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int ETAG 				= 34;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int LOCATION 			= 35;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int PROXY_AUTHENTICATE 	= 36;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int RETRY_AFTER 		= 37;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int SERVER 				= 38;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int SET_COOKIE 			= 39;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int VARY 				= 40;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int WWW_AUTHENTICATE 	= 41;
	
	// ========================================================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int ALLOW 				= 42;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int CONTENT_ENCODING 	= 43;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int CONTENT_LANGUAGE 	= 44;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int CONTENT_LENGTH 		= 45;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int CONTENT_LOCATION 	= 46;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int CONTENT_MD5 		= 47;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int CONTENT_RANGE 		= 48;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int CONTENT_TYPE 		= 49;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int EXPIRES 			= 50;// http/1.0
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static final int LAST_MODIFIED 		= 51;
}
