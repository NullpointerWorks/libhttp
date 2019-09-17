/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http.types;

public class ProtocolCode
{
	private ProtocolCode() {}
	
	/*
	 * Internet protocol suite - Application layer
	 * 
	 * BGP DHCP DNS FTP HTTP 
	 * HTTPS IMAP LDAP MGCP MQTT 
	 * NNTP NTP POP ONC/RPC RTP 
	 * RTSP RIP SIP SMTP SNMP 
	 * SSH Telnet TLS/SSL XMPP 
	 */
	public final static String HTTP09			= "HTTP/0.9";
	public final static String HTTP10			= "HTTP/1.0";
	public final static String HTTP11 			= "HTTP/1.1";
	
	/*
	 * april fools protocols
	 */
	//public final static String HTCPCP10 			= "HTCPCP/1.0";
	//public final static String HTCPCPTEA 			= "HTCPCP-TEA";
	
	/*
	 * future implementations
	 */
	//public final static String HTTP20 			= "HTTP/2.0";
	//public final static String SPDY 			= "SPDY";
	//public final static String SHTTP13 			= "SHTTP/1.3";
	//public final static String IRC69 			= "IRC/6.9";
	//public final static String RTA11 			= "RTA/x11";
	
	/**
	 * Returns the text associated with the response code.
	 */
	public static String getString(final int code)
	{
		switch(code)
		{
		case 100: return "100 Continue";
		case 101: return "101 Switching Protocol";
		case 102: return "102 Processing";

		case 200: return "200 OK";
		case 201: return "201 Created";
		case 202: return "202 Accepted";
		case 203: return "203 Non-Authoritative Information";
		case 204: return "204 No Content";
		case 205: return "205 Reset Content";
		case 206: return "206 Partial Content";
		case 207: return "207 Multi-Status";
		case 208: return "208 Multi-Status";
		case 226: return "226 IM Used";

		case 300: return "300 Multiple Choice";
		case 301: return "301 Moved Permanently";
		case 302: return "302 Found";
		case 303: return "303 See Other";
		case 304: return "304 Not Modified";
		case 305: return "305 Use Proxy";
		case 306: return "306 Unused";
		case 307: return "307 Temporary Redirect";
		case 308: return "308 Permanent Redirect";
		
		case 400: return "400 Bad Request";
		case 401: return "401 Unauthorized";
		case 402: return "402 Payment Required";
		case 403: return "403 Forbidden";
		case 404: return "404 Not Found";
		case 405: return "405 Method Not Allowed";
		case 406: return "406 Not Acceptable";
		case 407: return "407 Proxy Authentication Required";
		case 408: return "408 Request Timeout";
		case 409: return "409 Conflict";
		case 410: return "410 Gone";
		case 411: return "411 Length Required";
		case 412: return "412 Precondition Failed";
		case 413: return "413 Payload Too Large";
		case 414: return "414 URI Too Long";
		case 415: return "415 Unsupported Media Type";
		case 416: return "416 Requested Range Not Satisfiable";
		case 417: return "417 Expectation Failed";
		case 418: return "418 I'm a teapot";
		case 421: return "421 Misdirected Request";
		case 422: return "422 Unprocessable Entity (WebDAV)";
		case 423: return "423 Locked (WebDAV)";
		case 424: return "424 Failed Dependency (WebDAV)";
		case 426: return "426 Upgrade Required";
		case 428: return "428 Precondition Required";
		case 429: return "429 Too Many Requests";
		case 431: return "431 Request Header Fields Too Large";
		case 451: return "451 Unavailable For Legal Reasons";
		
		case 500: return "500 Internal Server Error";
		case 501: return "501 Not Implemented";
		case 502: return "502 Bad Gateway";
		case 503: return "503 Service Unavailable";
		case 504: return "504 Gateway Timeout";
		case 505: return "505 HTTP Version Not Supported";
		case 506: return "506 Variant Also Negotiates";
		case 507: return "507 Insufficient Storage";
		case 508: return "508 Loop Detected (WebDAV)";
		case 510: return "510 Not Extended";
		case 511: return "511 Network Authentication Required";
		}
		
		return "";
	}
	
	/*
	 * Information responses
	 */
	
	/**
	 * 100 Continue<br><br>
	 * This interim response indicates that everything so far is OK and that the client should continue with 
	 * the request or ignore it if it is already finished.
	 */
	public static final int C_CONTINUE			= 100;

	/**
	 * 101 Switching Protocol<br><br>
	 * This code is sent in response to an Upgrade request header by the client, and indicates the protocol 
	 * the server is switching too.
	 */
	public static final int C_SWITCHING		= 101;

	/**
	 * 102 Processing (WebDAV)<br><br>
	 * This code indicates that the server has received and is processing the request, but no response is 
	 * available yet.
	 */
	public static final int C_PROCESSING		= 102;
	
	/*
	 * Successful responses
	 */
	
	/**
	 * 200 OK<br><br>
	 * The request has succeeded. The meaning of a success varies depending on the HTTP method:<br>
	 * GET: The resource has been fetched and is transmitted in the message body.<br>
	 * HEAD: The entity headers are in the message body.<br>
	 * POST: The resource describing the result of the action is transmitted in the message body.<br>
	 * TRACE: The message body contains the request message as received by the server<br>
	 */
	public static final int C_200		= 200;
	
	/**
	 * 201 Created<br><br>
	 * The request has succeeded and a new resource has been created as a result of it. This is typically the 
	 * response sent after a PUT request.
	 */
	public static final int C_201		= 201;
	
	/**
	 * 202 Accepted<br><br>
	 * The request has been received but not yet acted upon. It is non-committal, meaning that there is no way 
	 * in HTTP to later send an asynchronous response indicating the outcome of processing the request. It is 
	 * intended for cases where another process or server handles the request, or for batch processing.
	 */
	public static final int C_202		= 202;
	
	/**
	 * 203 Non-Authoritative Information<br><br>
	 * This response code means returned meta-information set is not exact set as available from the origin 
	 * server, but collected from a local or a third party copy. Except this condition, 200 OK response should 
	 * be preferred instead of this response.
	 */
	public static final int C_203		= 203;
	
	/**
	 * 204 No Content<br><br>
	 * There is no content to send for this request, but the headers may be useful. The user-agent may update 
	 * its cached headers for this resource with the new ones.
	 */
	public static final int C_204		= 204;
	
	/**
	 * 205 Reset Content<br><br>
	 * This response code is sent after accomplishing request to tell user agent reset document view which sent 
	 * this request.
	 */
	public static final int C_205		= 205;
	
	/**
	 * 206 Partial Content<br><br>
	 * This response code is used because of range header sent by the client to separate download into multiple 
	 * streams.
	 */
	public static final int C_206		= 206;
	
	/**
	 * 207 Multi-Status (WebDAV)<br><br>
	 * A Multi-Status response conveys information about multiple resources in situations where multiple status 
	 * codes might be appropriate.
	 */
	public static final int C_207		= 207;
	
	/**
	 * 208 Multi-Status (WebDAV)<br><br>
	 * Used inside a DAV: propstat response element to avoid enumerating the internal members of multiple bindings 
	 * to the same collection repeatedly.
	 */
	public static final int C_208		= 208;
	
	/**
	 * 226 IM Used (HTTP Delta encoding)<br><br>
	 * The server has fulfilled a GET request for the resource, and the response is a representation of the 
	 * result of one or more instance-manipulations applied to the current instance.
	 */
	public static final int C_226		= 226;
	
	/*
	 * Redirection messages
	 */
	
	/**
	 * 300 Multiple Choice<br><br>
	 * The request has more than one possible responses. User-agent or user should choose one of them. There is no 
	 * standardized way to choose one of the responses.
	 */
	public static final int C_300		= 300;
	
	/**
	 * 301 Moved Permanently<br><br>
	 * This response code means that URI of requested resource has been changed. Probably, new URI would be given 
	 * in the response.
	 */
	public static final int C_301		= 301;
	
	/**
	 * 302 Found<br><br>
	 * This response code means that URI of requested resource has been changed temporarily. New changes in the 
	 * URI might be made in the future. Therefore, this same URI should be used by the client in future requests.
	 */
	public static final int C_302		= 302;
	
	/**
	 * 303 See Other<br><br>
	 * Server sent this response to directing client to get requested resource to another URI with an GET request.
	 */
	public static final int C_303		= 303;
	
	/**
	 * 304 Not Modified<br><br>
	 * This is used for caching purposes. It is telling to client that response has not been modified. So, client 
	 * can continue to use same cached version of response.
	 */
	public static final int C_304		= 304;
	
	/**
	 * 305 Use Proxy<br><br>
	 * Was defined in a previous version of the HTTP specification to indicate that a requested response must be 
	 * accessed by a proxy. It has been deprecated due to security concerns regarding in-band configuration of a 
	 * proxy.
	 */
	public static final int C_305		= 305;
	
	/**
	 * 306 Unused<br><br>
	 * This response code is no longer used, it is just reserved currently. It was used in a previous version of 
	 * the HTTP 1.1 specification.
	 */
	public static final int C_306		= 306;
	
	/**
	 * 307 Temporary Redirect<br><br>
	 * Server sent this response to directing client to get requested resource to another URI with same method 
	 * that used prior request. This has the same semantic than the 302 Found HTTP response code, with the 
	 * exception that the user agent must not change the HTTP method used: if a POST was used in the first request, 
	 * a POST must be used in the second request.
	 */
	public static final int C_307		= 307;
	
	/**
	 * 308 Permanent Redirect<br><br>
	 * This means that the resource is now permanently located at another URI, specified by the Location: HTTP 
	 * Response header. This has the same semantics as the 301 Moved Permanently HTTP response code, with the 
	 * exception that the user agent must not change the HTTP method used: if a POST was used in the first request, 
	 * a POST must be used in the second request.
	 */
	public static final int C_308		= 308;
	
	/*
	 * Client error responses
	 */
	
	/**
	 * 400 Bad Request<br><br>
	 * This response means that server could not understand the request due to invalid syntax.
	 */
	public static final int C_400		= 400;
	
	/**
	 * 401 Unauthorized<br><br>
	 * Although the HTTP standard specifies "unauthorized", semantically this response means "unauthenticated". 
	 * That is, the client must authenticate itself to get the requested response.
	 */
	public static final int C_401		= 401;
	
	/**
	 * 402 Payment Required<br><br>
	 * This response code is reserved for future use. Initial aim for creating this code was using it for digital 
	 * payment systems however this is not used currently.
	 */
	public static final int C_402		= 402;
	
	/**
	 * 403 Forbidden<br><br>
	 * The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting 
	 * to give proper response. Unlike 401, the client's identity is known to the server.
	 */
	public static final int C_403		= 403;
	
	/**
	 * 404 Not Found<br><br>
	 * The server can not find requested resource. In the browser, this means the URL is not recognized. In an 
	 * API, this can also mean that the endpoint is valid but the resource itself does not exist. Servers may also 
	 * send this response instead of 403 to hide the existence of a resource from an unauthorized client. This 
	 * response code is probably the most famous one due to its frequent occurence on the web.
	 */
	public static final int C_404		= 404;
	
	/**
	 * 405 Method Not Allowed<br><br>
	 * The request method is known by the server but has been disabled and cannot be used. For example, an API may 
	 * forbid DELETE-ing a resource. The two mandatory methods, GET and HEAD, must never be disabled and should 
	 * not return this error code.
	 */
	public static final int C_405		= 405;
	
	/**
	 * 406 Not Acceptable<br><br>
	 * This response is sent when the web server, after performing server-driven content negotiation, doesn't 
	 * find any content following the criteria given by the user agent.
	 */
	public static final int C_406		= 406;
	
	/**
	 * 407 Proxy Authentication Required<br><br>
	 * This is similar to 401 but authentication is needed to be done by a proxy.
	 */
	public static final int C_407		= 407;

	/**
	 * 408 Request Timeout<br><br>
	 * This response is sent on an idle connection by some servers, even without any previous request by the client. 
	 * It means that the server would like to shut down this unused connection. This response is used much more 
	 * since some browsers, like Chrome, Firefox 27+, or IE9, use HTTP pre-connection mechanisms to speed up 
	 * surfing. Also note that some servers merely shut down the connection without sending this message.
	 */
	public static final int C_408		= 408;

	/**
	 * 409 Conflict<br><br>
	 * This response is sent when a request conflicts with the current state of the server.
	 */
	public static final int C_409		= 409;
	
	/**
	 * 410 Gone<br><br>
	 * This response would be sent when the requested content has been permenantly deleted from server, with no 
	 * forwarding address. Clients are expected to remove their caches and links to the resource. The HTTP 
	 * specification intends this status code to be used for "limited-time, promotional services". APIs should 
	 * not feel compelled to indicate resources that have been deleted with this status code.
	 */
	public static final int C_410		= 410;

	/**
	 * 411 Length Required<br><br>
	 * Server rejected the request because the Content-Length header field is not defined and the server requires 
	 * it.
	 */
	public static final int C_411		= 411;

	/**
	 * 412 Precondition Failed<br><br>
	 * The client has indicated preconditions in its headers which the server does not meet.
	 */
	public static final int C_412		= 412;

	/**
	 * 413 Payload Too Large<br><br>
	 * Request entity is larger than limits defined by server; the server might close the connection or return 
	 * an Retry-After header field.
	 */
	public static final int C_413		= 413;

	/**
	 * 414 URI Too Long<br><br>
	 * The URI requested by the client is longer than the server is willing to interpret.
	 */
	public static final int C_414		= 414;

	/**
	 * 415 Unsupported Media Type<br><br>
	 * The media format of the requested data is not supported by the server, so the server is rejecting the 
	 * request.
	 */
	public static final int C_415		= 415;

	/**
	 * 416 Requested Range Not Satisfiable<br><br>
	 * The range specified by the Range header field in the request can't be fulfilled; it's possible that 
	 * the range is outside the size of the target URI's data.
	 */
	public static final int C_416		= 416;

	/**
	 * 417 Expectation Failed<br><br>
	 * This response code means the expectation indicated by the Expect request header field can't be met by the 
	 * server.
	 */
	public static final int C_417		= 417;

	/**
	 * 418 I'm a teapot<br><br>
	 * The server refuses the attempt to brew coffee with a teapot. April fools (1998) Hyper Text Coffee Pot 
	 * Control Protocol (HTCPCP).
	 */
	public static final int C_418		= 418;
	
	/**
	 * 421 Misdirected Request<br><br>
	 * The request was directed at a server that is not able to produce a response. This can be sent by a server 
	 * that is not configured to produce responses for the combination of scheme and authority that are included 
	 * in the request URI.
	 */
	public static final int C_421		= 421;
	
	/**
	 * 422 Unprocessable Entity (WebDAV)<br><br>
	 * The request was well-formed but was unable to be followed due to semantic errors.
	 */
	public static final int C_422		= 422;
	
	/**
	 * 423 Locked (WebDAV)<br><br>
	 * The resource that is being accessed is locked.
	 */
	public static final int C_423		= 423;
	
	/**
	 * 424 Failed Dependency (WebDAV)<br><br>
	 * The request failed due to failure of a previous request.
	 */
	public static final int C_424		= 424;
	
	/**
	 * 426 Upgrade Required<br><br>
	 * The server refuses to perform the request using the current protocol but might be willing to do so after 
	 * the client upgrades to a different protocol. The server sends an Upgrade header in a 426 response to 
	 * indicate the required protocol(s).
	 */
	public static final int C_426		= 426;
	
	/**
	 * 428 Precondition Required<br><br>
	 * The origin server requires the request to be conditional. Intended to prevent the 'lost update' problem, 
	 * where a client GETs a resource's state, modifies it, and PUTs it back to the server, when meanwhile a 
	 * third party has modified the state on the server, leading to a conflict.
	 */
	public static final int C_428		= 428;
	
	/**
	 * 429 Too Many Requests<br><br>
	 * The user has sent too many requests in a given amount of time ("rate limiting").
	 */
	public static final int C_429		= 429;
	
	/**
	 * 431 Request Header Fields Too Large<br><br>
	 * The server is unwilling to process the request because its header fields are too large. The request MAY 
	 * be resubmitted after reducing the size of the request header fields.
	 */
	public static final int C_431		= 431;
	
	/**
	 * 451 Unavailable For Legal Reasons<br><br>
	 * The user requests an illegal resource, such as a web page censored by a government.
	 */
	public static final int C_451		= 451;
	
	/*
	 * Server error responses
	 */
	
	/**
	 * 500 Internal Server Error<br><br>
	 * The server has encountered a situation it doesn't know how to handle.
	 */
	public static final int C_500		= 500;
	
	/**
	 * 501 Not Implemented<br><br>
	 * The request method is not supported by the server and cannot be handled. The only methods that servers are 
	 * required to support (and therefore that must not return this code) are GET and HEAD.
	 */
	public static final int C_501		= 501;
	
	/**
	 * 502 Bad Gateway<br><br>
	 * This error response means that the server, while working as a gateway to get a response needed to handle 
	 * the request, got an invalid response.
	 */
	public static final int C_502		= 502;
	
	/**
	 * 503 Service Unavailable<br><br>
	 * The server is not ready to handle the request. Common causes are a server that is down for maintenance or 
	 * that is overloaded. Note that together with this response, a user-friendly page explaining the problem 
	 * should be sent. This responses should be used for temporary conditions and the Retry-After: HTTP header 
	 * should, if possible, contain the estimated time before the recovery of the service. The webmaster must 
	 * also take care about the caching-related headers that are sent along with this response, as these temporary 
	 * condition responses should usually not be cached.
	 */
	public static final int C_503		= 503;
	
	/**
	 * 504 Gateway Timeout<br><br>
	 * This error response is given when the server is acting as a gateway and cannot get a response in time.
	 */
	public static final int C_504		= 504;
	
	/**
	 * 505 HTTP Version Not Supported<br><br>
	 * The HTTP version used in the request is not supported by the server.
	 */
	public static final int C_505		= 505;
	
	/**
	 * 506 Variant Also Negotiates<br><br>
	 * The server has an internal configuration error: transparent content negotiation for the request results in 
	 * a circular reference.
	 */
	public static final int C_506		= 506;
	
	/**
	 * 507 Insufficient Storage<br><br>
	 * The server has an internal configuration error: the chosen variant resource is configured to engage in 
	 * transparent content negotiation itself, and is therefore not a proper end point in the negotiation process.
	 */
	public static final int C_507		= 507;
	
	/**
	 * 508 Loop Detected (WebDAV)<br><br>
	 * The server detected an infinite loop while processing the request.
	 */
	public static final int C_508		= 508;
	
	/**
	 * 510 Not Extended<br><br>
	 * Further extensions to the request are required for the server to fulfill it.
	 */
	public static final int C_510		= 510;
	
	/**
	 * 511 Network Authentication Required<br><br>
	 * The 511 status code indicates that the client needs to authenticate to gain network access. 
	 */
	public static final int C_511		= 511;
	
}
