package exp.nullpointerworks.http.types;

public class HeaderType
{
	private HeaderType() {}
	
	public static final int NULL 				= -1;
	public static final int UNKNOWN_HEADER 		= 0;
	
	public static final int CONNECTION 			= 1;
	public static final int DATE 				= 2;
	public static final int PRAGMA 				= 3;// http/1.0
	public static final int CACHE_CONTROL 		= 4;// http/1.1 (expires and pragma)
	public static final int TRAILER 			= 5;
	public static final int TRANSFER_ENCODING 	= 6;
	public static final int UPGRADE 			= 7;
	public static final int VIA 				= 8;
	public static final int WARNING 			= 9;
	
	public static final int ACCEPT 				= 10;
	public static final int ACCEPT_LANGUAGE 	= 11;
	public static final int ACCEPT_ENCODING 	= 12;
	public static final int ACCEPT_CHARSET 		= 13;
	public static final int AUTHORIZATION 		= 14;
	public static final int COOKIE 				= 15;
	public static final int EXPECT 				= 16;
	public static final int FROM 				= 17;
	public static final int HOST 				= 18;
	public static final int IF_MATCH 			= 19;
	public static final int IF_MODIFIED_SINCE 	= 20;
	public static final int IF_NONE_MATCH 		= 21;
	public static final int IF_RANGE 			= 22;
	public static final int IF_UNMODIFIED_SINCE = 23;
	public static final int MAX_FORWARDS 		= 24;
	public static final int PROXY_AUTHORIZATION = 25;
	public static final int RANGE 				= 26;
	public static final int REFERER 			= 27;
	public static final int TE 					= 28;
	public static final int USER_AGENT 			= 29;
	public static final int UPGRADE_INSECURE_REQUESTS = 30;

	public static final int ACCEPT_RANGES 		= 31;
	public static final int AGE 				= 32;
	public static final int CONTENT_DISPOSITION = 33;
	public static final int ETAG 				= 34;
	public static final int LOCATION 			= 35;
	public static final int PROXY_AUTHENTICATE 	= 36;
	public static final int RETRY_AFTER 		= 37;
	public static final int SERVER 				= 38;
	public static final int SET_COOKIE 			= 39;
	public static final int VARY 				= 40;
	public static final int WWW_AUTHENTICATE 	= 41;

	public static final int ALLOW 				= 42;
	public static final int CONTENT_ENCODING 	= 43;
	public static final int CONTENT_LANGUAGE 	= 44;
	public static final int CONTENT_LENGTH 		= 45;
	public static final int CONTENT_LOCATION 	= 46;
	public static final int CONTENT_MD5 		= 47;
	public static final int CONTENT_RANGE 		= 48;
	public static final int CONTENT_TYPE 		= 49;
	public static final int EXPIRES 			= 50;// http/1.0
	public static final int LAST_MODIFIED 		= 51;
}
