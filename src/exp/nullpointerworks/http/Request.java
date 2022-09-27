/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http;

import java.util.List;

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
	 * 
	 * @since 1.0.0
	 */
	List<Parameter> getParameters();
	
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
	 * 
	 * @since 1.0.0
	 */
	List<Header> getHeaders();
	
	/**
	 * Returns the attached body data which may be present in this request package.
	 * @since 1.0.0
	 * @return the attached body data which may be present in this request package
	 */
	byte[] getBodyData();
	
	/**
	 * Returns the bytes that constitute this request. This includes the method, protocol, headers and optionally body data.
	 * @since 1.0.0
	 * @return
	 */
	byte[] getBytes();
}
