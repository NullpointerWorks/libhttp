package exp.nullpointerworks.http;

public enum Method
{
	/**
	 * The GET method is used to retrieve information from the given server using a given URI. Requests using GET should only retrieve data and should have no other effect on the data.
	 * @since 1.0.0
	 */
	GET,
	
	/**
	 * A POST request is used to send data to the server, for example, customer information, file upload, etc. using HTML forms.
	 * @since 1.0.0
	 */
	POST,
	
	/**
	 * Replaces all current representations of the target resource with the uploaded content.
	 * @since 1.0.0
	 */
	PUT,
	
	/**
	 * Same as GET, but transfers the status line and header section only.
	 * @since 1.0.0
	 */
	HEAD,
	
	/**
	 * Performs a message loop-back test along the path to the target resource.
	 * @since 1.0.0
	 */
	TRACE,
	
	/**
	 * Removes all current representations of the target resource given by a URI.
	 * @since 1.0.0
	 */
	DELETE,
	
	/**
	 * Establishes a tunnel to the server identified by a given URI.
	 * @since 1.0.0
	 */
	CONNECT,
	
	/**
	 * The HTTP PATCH request method applies partial modifications to a resource.
	 * @since 1.0.0
	 */
	PATCH,
	
	/**
	 * Describes the communication options for the target resource.
	 * @since 1.0.0
	 */
	OPTIONS,
	
	/**
	 * 
	 * @since 1.0.0
	 */
	UNKNOWN;
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public static Method fromString(String method)
	{
		method = method.toUpperCase();
		switch(method)
		{
		case "GET": return GET;
		case "HEAD": return HEAD;
		case "POST": return POST;
		case "TRACE": return TRACE;
		case "PUT": return PUT;
		case "DELETE": return DELETE;
		case "CONNECT": return CONNECT;
		case "PATCH": return PATCH;
		case "OPTIONS": return OPTIONS;
		default: return UNKNOWN;
		}
	}
}
