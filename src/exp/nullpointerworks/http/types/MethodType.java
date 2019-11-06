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
public enum MethodType
{
	/**
	 * 
	 * @since 1.0.0
	 */
	UNKNOWN,
	
	/**
	 * The GET method is used to retrieve information from the given server using a given URI. Requests using GET should only retrieve data and should have no other effect on the data.
	 * @since 1.0.0
	 */
	GET,
	
	/**
	 * Same as GET, but transfers the status line and header section only.
	 * @since 1.0.0
	 */
	HEAD,
	
	/**
	 * A POST request is used to send data to the server, for example, customer information, file upload, etc. using HTML forms.
	 * @since 1.0.0
	 */
	POST,
	
	/**
	 * Performs a message loop-back test along the path to the target resource.
	 * @since 1.0.0
	 */
	TRACE,
	
	/**
	 * Replaces all current representations of the target resource with the uploaded content.
	 * @since 1.0.0
	 */
	PUT,
	
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
	 * Describes the communication options for the target resource.
	 * @since 1.0.0
	 */
	OPTIONS;
	
	public static MethodType fromString(String method)
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
		case "OPTIONS": return OPTIONS;
		default: return UNKNOWN;
		}
	}
}
