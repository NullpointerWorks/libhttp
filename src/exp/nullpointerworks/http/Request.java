/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
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
	
	// finders
	
	/**
	 * 
	 * @since 1.0.0
	 */
	Parameter findParameter(String name);
	
	/**
	 * Searches for a header with the name specified. The valid header is returned if successful, otherwise the returned header is marked invalid.
	 * @param name
	 * @return
	 */
	Header findHeader(String name);
	
	/**
	 * 
	 * @since 1.0.0
	 */
	Header findHeader(HeaderType hdr);
	
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
	byte[] getBodyData();
	
	/**
	 * Returns the requesting web socket.
	 * @return the requesting web socket
	 * @since 1.0.0
	 */
	WebSocket getWebSocket();
}
