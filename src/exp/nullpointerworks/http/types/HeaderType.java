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
 * @see https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers
 */
public enum HeaderType
{
	// ============================== ? ==============================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	NULL(""),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	UNKNOWN_HEADER("Unknown"),
	
	// ============================== A ==============================
	
	/**
	 * The Accept request HTTP header advertises which content types, expressed as MIME types, the client is able to understand. Using content negotiation, the server then selects one of the proposals, uses it and informs the client of its choice with the Content-Type response header. 
	 * @since 1.0.0
	 */
	ACCEPT("Accept"),
	
	/**
	 * The Accept-Charset request HTTP header advertises which character encodings the client understands. Using content negotiation, the server selects one of the encodings, uses it, and informs the client of its choice within the Content-Type response header, usually in a charset= parameter. Browsers usually don't send this header, as the default value for each resource is usually correct and transmitting it would allow fingerprinting.
	 * @since 1.0.0
	 */
	ACCEPT_CHARSET("Accept-Charset"),
	
	/**
	 * The Accept-Encoding request HTTP header advertises which content encoding, usually a compression algorithm, the client is able to understand. Using content negotiation, the server selects one of the proposals, uses it and informs the client of its choice with the Content-Encoding response header.
	 * @since 1.0.0
	 */
	ACCEPT_ENCODING("Accept-Encoding"),
	
	/**
	 * The Accept-Language request HTTP header advertises which languages the client is able to understand, and which locale variant is preferred. (By languages, we mean natural languages, such as English, and not programming languages.) Using content negotiation, the server then selects one of the proposals, uses it and informs the client of its choice with the Content-Language response header. Browsers set adequate values for this header according to their user interface language and even if a user can change it, this happens rarely (and is frowned upon as it leads to fingerprinting).
	 * @since 1.0.0
	 */
	ACCEPT_LANGUAGE("Accept-Language"),
	
	/**
	 * The Accept-Patch response HTTP header advertises which media-type the server is able to understand. Accept-Patch in response to any method means that PATCH is allowed on the resource identified by the Request-URI. Two common cases lead to this: A server receiving a PATCH request with an unsupported media type could reply with  415 Unsupported Media Type and an Accept-Patch header referencing one or more supported media types.
	 * @since 1.0.0
	 */
	ACCEPT_PATCH("Accept-Patch"),
	
	/**
	 * The Accept-Ranges response HTTP header is a marker used by the server to advertise its support of partial requests. The value of this field indicates the unit that can be used to define a range. In presence of an Accept-Ranges header, the browser may try to resume an interrupted download, rather than to start it from the start again.
	 * @since 1.0.0
	 */
	ACCEPT_RANGES("Accept-Ranges"),
	
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

	// ============================== C ==============================
	
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
	CONTENT_LENGTH("Content-Length"),
	
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
	@Deprecated
	CONTENT_MD5("Content-MD5"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CONTENT_SECURITY_POLICY("Content-Security-Policy"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CONTENT_SECURITY_POLICY_REPORT_ONLY("Content-Security-Policy-Report-Only"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CONTENT_TYPE("Content-Type"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	COOKIE("Cookie"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	@Deprecated
	COOKIE2("Cookie2"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	CROSS_ORIGIN_RESOURCE_POLICY("Cross-Origin-Resource-Policy"),
	
	// ============================== D ==============================

	/**
	 * 
	 * @since 1.0.0
	 */
	DNT("DNT"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	DATE("Date"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	DIGEST("Digest"),

	// ============================== E ==============================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ETAG("ETag"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	EARLY_DATA("Early-Data"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	EXPECT("Expect"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	EXPECT_CT("Expect-CT"),

	/**
	 * 
	 * @since 1.0.0
	 */
	EXPIRES("Expires"),
	
	// ============================== F ==============================

	/**
	 * 
	 * @since 1.0.0
	 */
	FORWARDED("Forwarded"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	FROM("From"),
	
	// ============================== H ==============================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	HOST("Host"),

	// ============================== I ==============================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	IF_MATCH("If-Match"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	IF_MODIFIED_SINCE("If-Modified-Since"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	IF_NONE_MATCH("If-None-Match"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	IF_RANGE("If-Range"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	IF_UNMODIFIED_SINCE("If-Modified-Since"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	INDEX("Index"),
	
	// ============================== K ==============================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	KEEP_ALIVE("Keep-Alive"),
	
	// ============================== M ==============================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	MAX_FORWARDS("Max-Forwards"),
	
	// ============================== L ==============================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	LAST_MODIFIED("last-modified"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	LINK("Link"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	LOCATION("location"),
	
	// ============================== O ==============================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	ORIGIN("Origin"),
	
	// ============================== P ==============================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	@Deprecated
	PRAGMA("Pragma"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	PROXY_AUTHENTICATE("Proxy-Authenticate"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	PROXY_AUTHORIZATION("Proxy-Authorization"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	PUBLIC_KEY_PINS("Public-Key-Pins"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	PUBLIC_KEY_PINS_REPORT_ONLY("Public-Key-Pins-Report-Only"),

	// ============================== R ==============================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	RANGE("Range"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	REFERER("Referer"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	REFERRER_POLICY("Referrer-Policy"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	RETRY_AFTER("Retry-After"),
	
	// ============================== S ==============================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	SAVE_DATA("Save-Data"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	SEC_WEBSOCKET_ACCEPT("Sec-WebSocket-Accept"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	SERVER("Server"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	SERVER_TIMING("Server-Timing"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	SET_COOKIE("Set-Cookie"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	@Deprecated
	SET_COOKIE2("Set-Cookie2"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	SOURCEMAP("SourceMap"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	STRICT_TRANSPORT_SECURITY("Strict-Transport-Security"),
	
	// ============================== T ==============================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	TE("TE"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	TIMING_ALLOW_ORIGIN("Timing-Allow-Origin"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	TK("Tk"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	TRAILER("Trailer"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	TRANSFER_ENCODING("Transfer-Encoding"),
	
	// ============================== U ==============================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	UPGRADE("Upgrade"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	UPGRADE_INSECURE_REQUESTS("Upgrade-Insecure-Requests"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	USER_AGENT("User-Agent"),

	// ============================== V ==============================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	VARY("Vary"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	VIA("Via"),
	
	// ============================== W ==============================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	WANT_DIGEST("Want-Digest"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	WARNING("Warning"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	WWW_AUTHENTICATE("WWW-Authenticate"),

	// ============================== X ==============================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	X_CONTENT_TYPE_OPTIONS("X-Content-Type-Options"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	X_DNS_PREFETCH_CONTROL("X-DNS-Prefetch-Control"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	X_FRAME_OPTIONS("X-Frame-Options"),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	X_XSS_PROTECTION("X-XSS-Protection");
	
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
		HeaderType[] list = HeaderType.values();
		for (HeaderType ht : list)
		{
			if (ht.getString().equalsIgnoreCase(header))
			{
				return ht;
			}
		}
		return UNKNOWN_HEADER;
	}
}
