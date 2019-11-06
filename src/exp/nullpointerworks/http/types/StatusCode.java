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
public enum StatusCode 
{
	/**
	 * A {@code null} indicator object.
	 * @since 1.0.0
	 */
	NULL(-1,"null"),
	
	/*
	 * Information responses
	 */
	
	/**
	 * 100 Continue<br><br>
	 * This interim response indicates that everything so far is OK and that the client should continue with 
	 * the request or ignore it if it is already finished.
	 * @since 1.0.0
	 */
	_100(100, "Continue"),
	
	/**
	 * 101 Switching Protocol<br><br>
	 * This code is sent in response to an Upgrade request header by the client, and indicates the protocol 
	 * the server is switching too.
	 * @since 1.0.0
	 */
	_101(101, "Switching Protocol"),

	/**
	 * 102 Processing (WebDAV)<br><br>
	 * This code indicates that the server has received and is processing the request, but no response is 
	 * available yet.
	 * @since 1.0.0
	 */
	_102(102, "Processing (WebDAV)"),
	
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
	 * @since 1.0.0
	 */
	_200(200, "OK"),
	
	/**
	 * 201 Created<br><br>
	 * The request has succeeded and a new resource has been created as a result of it. This is typically the 
	 * response sent after a PUT request.
	 * @since 1.0.0
	 */
	_201(201, "Created"),
	
	/**
	 * 202 Accepted<br><br>
	 * The request has been received but not yet acted upon. It is non-committal, meaning that there is no way 
	 * in HTTP to later send an asynchronous response indicating the outcome of processing the request. It is 
	 * intended for cases where another process or server handles the request, or for batch processing.
	 * @since 1.0.0
	 */
	_202(202, "Accepted"),
	
	/**
	 * 203 Non-Authoritative Information<br><br>
	 * This response code means returned meta-information set is not exact set as available from the origin 
	 * server, but collected from a local or a third party copy. Except this condition, 200 OK response should 
	 * be preferred instead of this response.
	 * @since 1.0.0
	 */
	_203(203, "Non-Authoritative Information"),
	
	/**
	 * 204 No Content<br><br>
	 * There is no content to send for this request, but the headers may be useful. The user-agent may update 
	 * its cached headers for this resource with the new ones.
	 * @since 1.0.0
	 */
	_204(204, "No Content"),
	
	/**
	 * 205 Reset Content<br><br>
	 * This response code is sent after accomplishing request to tell user agent reset document view which sent 
	 * this request.
	 * @since 1.0.0
	 */
	_205(205, "Reset Content"),
	
	/**
	 * 206 Partial Content<br><br>
	 * This response code is used because of range header sent by the client to separate download into multiple 
	 * streams.
	 * @since 1.0.0
	 */
	_206(206, "Partial Content"),
	
	/**
	 * 207 Multi-Status (WebDAV)<br><br>
	 * A Multi-Status response conveys information about multiple resources in situations where multiple status 
	 * codes might be appropriate.
	 * @since 1.0.0
	 */
	_207(207, "Multi-Status (WebDAV)"),
	
	/**
	 * 208 Multi-Status (WebDAV)<br><br>
	 * Used inside a DAV: propstat response element to avoid enumerating the internal members of multiple bindings 
	 * to the same collection repeatedly.
	 * @since 1.0.0
	 */
	_208(208, "Multi-Status (WebDAV)"),
	
	/**
	 * 226 IM Used (HTTP Delta encoding)<br><br>
	 * The server has fulfilled a GET request for the resource, and the response is a representation of the 
	 * result of one or more instance-manipulations applied to the current instance.
	 * @since 1.0.0
	 */
	_226(226, "IM Used (HTTP Delta encoding)"),
	
	/*
	 * Redirection messages
	 */
	
	/**
	 * 300 Multiple Choice<br><br>
	 * The request has more than one possible responses. User-agent or user should choose one of them. There is no 
	 * standardized way to choose one of the responses.
	 * @since 1.0.0
	 */
	_300(300, "Multiple Choice"),
	
	/**
	 * 301 Moved Permanently<br><br>
	 * This response code means that URI of requested resource has been changed. Probably, new URI would be given 
	 * in the response.
	 * @since 1.0.0
	 */
	_301(301, "Moved Permanently"),
	
	/**
	 * 302 Found<br><br>
	 * This response code means that URI of requested resource has been changed temporarily. New changes in the 
	 * URI might be made in the future. Therefore, this same URI should be used by the client in future requests.
	 * @since 1.0.0
	 */
	_302(302, "Found"),
	
	/**
	 * 303 See Other<br><br>
	 * Server sent this response to directing client to get requested resource to another URI with an GET request.
	 * @since 1.0.0
	 */
	_303(303, "See Other"),
	
	/**
	 * 304 Not Modified<br><br>
	 * This is used for caching purposes. It is telling to client that response has not been modified. So, client 
	 * can continue to use same cached version of response.
	 * @since 1.0.0
	 */
	_304(304, "Not Modified"),
	
	/**
	 * 305 Use Proxy<br><br>
	 * Was defined in a previous version of the HTTP specification to indicate that a requested response must be 
	 * accessed by a proxy. It has been deprecated due to security concerns regarding in-band configuration of a 
	 * proxy.
	 * @since 1.0.0
	 */
	@Deprecated
	_305(305, "Use Proxy"),
	
	/**
	 * 306 Unused<br><br>
	 * This response code is no longer used, it is just reserved currently. It was used in a previous version of 
	 * the HTTP 1.1 specification.
	 * @since 1.0.0
	 */
	_306(306, "Unused"),
	
	/**
	 * 307 Temporary Redirect<br><br>
	 * Server sent this response to directing client to get requested resource to another URI with same method 
	 * that used prior request. This has the same semantic than the 302 Found HTTP response code, with the 
	 * exception that the user agent must not change the HTTP method used: if a POST was used in the first request, 
	 * a POST must be used in the second request.
	 * @since 1.0.0
	 */
	_307(307, "Temporary Redirect"),
	
	/**
	 * 308 Permanent Redirect<br><br>
	 * This means that the resource is now permanently located at another URI, specified by the Location: HTTP 
	 * Response header. This has the same semantics as the 301 Moved Permanently HTTP response code, with the 
	 * exception that the user agent must not change the HTTP method used: if a POST was used in the first request, 
	 * a POST must be used in the second request.
	 * @since 1.0.0
	 */
	_308(308, "Permanent Redirect"),
	
	/*
	 * Client error responses
	 */
	
	/**
	 * 400 Bad Request<br><br>
	 * This response means that server could not understand the request due to invalid syntax.
	 * @since 1.0.0
	 */
	_400(400, "Bad Request"),
	
	/**
	 * 401 Unauthorized<br><br>
	 * Although the HTTP standard specifies "unauthorized", semantically this response means "unauthenticated". 
	 * That is, the client must authenticate itself to get the requested response.
	 * @since 1.0.0
	 */
	_401(401, "Unauthorized"),
	
	/**
	 * 402 Payment Required<br><br>
	 * This response code is reserved for future use. Initial aim for creating this code was using it for digital 
	 * payment systems however this is not used currently.
	 * @since 1.0.0
	 */
	_402(402, "Payment Required"),
	
	/**
	 * 403 Forbidden<br><br>
	 * The client does not have access rights to the content, i.e. they are unauthorized, so server is rejecting 
	 * to give proper response. Unlike 401, the client's identity is known to the server.
	 * @since 1.0.0
	 */
	_403(403, "Forbidden"),
	
	/**
	 * 404 Not Found<br><br>
	 * The server can not find requested resource. In the browser, this means the URL is not recognized. In an 
	 * API, this can also mean that the endpoint is valid but the resource itself does not exist. Servers may also 
	 * send this response instead of 403 to hide the existence of a resource from an unauthorized client. This 
	 * response code is probably the most famous one due to its frequent occurrence on the web.
	 * @since 1.0.0
	 */
	_404(404, "Not Found"),
	
	/**
	 * 405 Method Not Allowed<br><br>
	 * The request method is known by the server but has been disabled and cannot be used. For example, an API may 
	 * forbid DELETE-ing a resource. The two mandatory methods, GET and HEAD, must never be disabled and should 
	 * not return this error code.
	 * @since 1.0.0
	 */
	_405(405, "Method Not Allowed"),
	
	/**
	 * 406 Not Acceptable<br><br>
	 * This response is sent when the web server, after performing server-driven content negotiation, doesn't 
	 * find any content following the criteria given by the user agent.
	 * @since 1.0.0
	 */
	_406(406, "Not Acceptable"),
	
	/**
	 * 407 Proxy Authentication Required<br><br>
	 * This is similar to 401 but authentication is needed to be done by a proxy.
	 * @since 1.0.0
	 */
	_407(407, "Proxy Authentication Required"),
	
	/**
	 * 408 Request Timeout<br><br>
	 * This response is sent on an idle connection by some servers, even without any previous request by the client. 
	 * It means that the server would like to shut down this unused connection. This response is used much more 
	 * since some browsers, like Chrome, Firefox 27+, or IE9, use HTTP pre-connection mechanisms to speed up 
	 * surfing. Also note that some servers merely shut down the connection without sending this message.
	 * @since 1.0.0
	 */
	_408(408, "Request Timeout"),

	/**
	 * 409 Conflict<br><br>
	 * This response is sent when a request conflicts with the current state of the server.
	 * @since 1.0.0
	 */
	_409(409, "Conflict"),
	
	/**
	 * 410 Gone<br><br>
	 * This response would be sent when the requested content has been permenantly deleted from server, with no 
	 * forwarding address. Clients are expected to remove their caches and links to the resource. The HTTP 
	 * specification intends this status code to be used for "limited-time, promotional services". APIs should 
	 * not feel compelled to indicate resources that have been deleted with this status code.
	 * @since 1.0.0
	 */
	_410(410, "Gone"),

	/**
	 * 411 Length Required<br><br>
	 * Server rejected the request because the Content-Length header field is not defined and the server requires 
	 * it.
	 * @since 1.0.0
	 */
	_411(411, "Length Required"),

	/**
	 * 412 Precondition Failed<br><br>
	 * The client has indicated preconditions in its headers which the server does not meet.
	 * @since 1.0.0
	 */
	_412(412, "Precondition Failed"),

	/**
	 * 413 Payload Too Large<br><br>
	 * Request entity is larger than limits defined by server; the server might close the connection or return 
	 * an Retry-After header field.
	 * @since 1.0.0
	 */
	_413(413, "Payload Too Large"),

	/**
	 * 414 URI Too Long<br><br>
	 * The URI requested by the client is longer than the server is willing to interpret.
	 * @since 1.0.0
	 */
	_414(414, "URI Too Long"),

	/**
	 * 415 Unsupported Media Type<br><br>
	 * The media format of the requested data is not supported by the server, so the server is rejecting the 
	 * request.
	 * @since 1.0.0
	 */
	_415(415, "Unsupported Media Type"),

	/**
	 * 416 Requested Range Not Satisfiable<br><br>
	 * The range specified by the Range header field in the request can't be fulfilled; it's possible that 
	 * the range is outside the size of the target URI's data.
	 * @since 1.0.0
	 */
	_416(416, "Requested Range Not Satisfiable"),

	/**
	 * 417 Expectation Failed<br><br>
	 * This response code means the expectation indicated by the Expect request header field can't be met by the 
	 * server.
	 * @since 1.0.0
	 */
	_417(417, "Expectation Failed"),

	/**
	 * 418 I'm a teapot<br><br>
	 * The server refuses the attempt to brew coffee with a teapot. April fools (1998) Hyper Text Coffee Pot 
	 * Control Protocol (HTCPCP).
	 * @since 1.0.0
	 */
	_418(418, "I'm a teapot"),
	
	/**
	 * 421 Misdirected Request<br><br>
	 * The request was directed at a server that is not able to produce a response. This can be sent by a server 
	 * that is not configured to produce responses for the combination of scheme and authority that are included 
	 * in the request URI.
	 * @since 1.0.0
	 */
	_421(421, "Misdirected Request"),
	
	/**
	 * 422 Unprocessable Entity (WebDAV)<br><br>
	 * The request was well-formed but was unable to be followed due to semantic errors.
	 * @since 1.0.0
	 */
	_422(422, "Unprocessable Entity (WebDAV)"),
	
	/**
	 * 423 Locked (WebDAV)<br><br>
	 * The resource that is being accessed is locked.
	 * @since 1.0.0
	 */
	_423(423, "Locked (WebDAV)"),
	
	/**
	 * 424 Failed Dependency (WebDAV)<br><br>
	 * The request failed due to failure of a previous request.
	 * @since 1.0.0
	 */
	_424(424, "Failed Dependency (WebDAV)"),
	
	/**
	 * 426 Upgrade Required<br><br>
	 * The server refuses to perform the request using the current protocol but might be willing to do so after 
	 * the client upgrades to a different protocol. The server sends an Upgrade header in a 426 response to 
	 * indicate the required protocol(s).
	 * @since 1.0.0
	 */
	_426(426, "Upgrade Required"),
	
	/**
	 * 428 Precondition Required<br><br>
	 * The origin server requires the request to be conditional. Intended to prevent the 'lost update' problem, 
	 * where a client GETs a resource's state, modifies it, and PUTs it back to the server, when meanwhile a 
	 * third party has modified the state on the server, leading to a conflict.
	 * @since 1.0.0
	 */
	_428(428, "Precondition Required"),
	
	/**
	 * 429 Too Many Requests<br><br>
	 * The user has sent too many requests in a given amount of time ("rate limiting").
	 * @since 1.0.0
	 */
	_429(429, "Too Many Requests"),
	
	/**
	 * 431 Request Header Fields Too Large<br><br>
	 * The server is unwilling to process the request because its header fields are too large. The request MAY 
	 * be resubmitted after reducing the size of the request header fields.
	 * @since 1.0.0
	 */
	_431(431, "Request Header Fields Too Large"),
	
	/**
	 * 451 Unavailable For Legal Reasons<br><br>
	 * The user requests an illegal resource, such as a web page censored by a government.
	 * @since 1.0.0
	 */
	_451(451, "Unavailable For Legal Reasons"),
	
	/*
	 * Server error responses
	 */
	
	/**
	 * 500 Internal Server Error<br><br>
	 * The server has encountered a situation it doesn't know how to handle.
	 * @since 1.0.0
	 */
	_500(500, "Internal Server Error"),
	
	/**
	 * 501 Not Implemented<br><br>
	 * The request method is not supported by the server and cannot be handled. The only methods that servers 
	 * are required to support (and therefore that must not return this code) are GET and HEAD.
	 * @since 1.0.0
	 */
	_501(501, "Not Implemented"),
	
	/**
	 * 502 Bad Gateway<br><br>
	 * This error response means that the server, while working as a gateway to get a response needed to handle 
	 * the request, got an invalid response.
	 * @since 1.0.0
	 */
	_502(502, "Bad Gateway"),
	
	/**
	 * 503 Service Unavailable<br><br>
	 * The server is not ready to handle the request. Common causes are a server that is down for maintenance or 
	 * that is overloaded. Note that together with this response, a user-friendly page explaining the problem 
	 * should be sent. This responses should be used for temporary conditions and the Retry-After: HTTP header 
	 * should, if possible, contain the estimated time before the recovery of the service. The webmaster must 
	 * also take care about the caching-related headers that are sent along with this response, as these temporary 
	 * condition responses should usually not be cached.
	 * @since 1.0.0
	 */
	_503(503, "Service Unavailable"),
	
	/**
	 * 504 Gateway Timeout<br><br>
	 * This error response is given when the server is acting as a gateway and cannot get a response in time.
	 * @since 1.0.0
	 */
	_504(504, "Gateway Timeout"),
	
	/**
	 * 505 HTTP Version Not Supported<br><br>
	 * The HTTP version used in the request is not supported by the server.
	 * @since 1.0.0
	 */
	_505(505, "HTTP Version Not Supported"),
	
	/**
	 * 506 Variant Also Negotiates<br><br>
	 * The server has an internal configuration error: transparent content negotiation for the request results 
	 * in a circular reference.
	 * @since 1.0.0
	 */
	_506(506, "Variant Also Negotiates"),
	
	/**
	 * 507 Insufficient Storage<br><br>
	 * The server has an internal configuration error: the chosen variant resource is configured to engage in 
	 * transparent content negotiation itself, and is therefore not a proper end point in the negotiation process.
	 * @since 1.0.0
	 */
	_507(507, "Insufficient Storage"),
	
	/**
	 * 508 Loop Detected (WebDAV)<br><br>
	 * The server detected an infinite loop while processing the request.
	 * @since 1.0.0
	 */
	_508(508, "Loop Detected (WebDAV)"),
	
	/**
	 * 510 Not Extended<br><br>
	 * Further extensions to the request are required for the server to fulfill it.
	 * @since 1.0.0
	 */
	_510(510, "Not Extended"),
	
	/**
	 * 511 Network Authentication Required<br><br>
	 * The 511 status code indicates that the client needs to authenticate to gain network access. 
	 * @since 1.0.0
	 */
	_511(511, "Network Authentication Required");
	
	private final int code;
	private final String text;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	private StatusCode(int code, String text)
	{
		this.code=code;
		this.text=text;
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public final String getString()
	{
		return getInteger()+" "+getName();
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public final String getName()
	{
		return text;
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public int getInteger() 
	{
		return code;
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static StatusCode fromInteger(int code)
	{
		StatusCode[] list = StatusCode.values();
		for (StatusCode sc : list)
		{
			if (sc.getInteger() == code)
			{
				return sc;
			}
		}
		return NULL;
	}
}
