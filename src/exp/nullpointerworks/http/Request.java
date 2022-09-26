/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http;

import exp.nullpointerworks.http.util.Parameter;

/**
 * 
 * @since 1.0.0
 */
public interface Request
{
	/**
	 * 
	 * @since 1.0.0
	 */
	boolean isValid();
	
	// getters
	
	/**
	 * 
	 * @since 1.0.0
	 */
	Method getMethod();
	
	/**
	 * 
	 * @since 1.0.0
	 */
	Protocol getProtocol();
	
	/**
	 * 
	 * @since 1.0.0
	 */
	String getTarget();
	
	/**
	 * 
	 * @since 1.0.0
	 */
	Parameter getParameter(String name);
	
	/**
	 * Searches for a header with the name specified. The valid header is returned if successful, otherwise the returned header is marked invalid.
	 * @param name
	 * @return
	 */
	Header getHeader(String name);
	
	/**
	 * 
	 * @since 1.0.0
	 */
	Header getHeader(HeaderType hdr);
	
	/**
	 * Returns the bytes containing the request data.
	 * @return the bytes containing the request data
	 * @since 1.0.0
	 */
	byte[] getRequestBytes();
	
	/**
	 * Returns the raw bytes of the attached body data.
	 * @return the raw bytes of the attached body data
	 * @since 1.0.0
	 */
	byte[] getBodyData();
	
	/**
	 * Returns the bytes that constitute this entire request.
	 * @return the bytes that constitute this entire request
	 * @since 1.0.0
	 */
	byte[] getBytes();
	
	/**
	 * Returns the requesting web socket.
	 * @return the requesting web socket
	 * @since 1.0.0
	 */
	WebSocket getWebSocket();
}
