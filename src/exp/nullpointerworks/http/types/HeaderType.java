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
