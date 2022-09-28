/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http;

import java.util.List;

import exp.nullpointerworks.http.util.BytePackage;

/**
 * 
 */
public interface Response extends BytePackage
{
	/**
	 * 
	 */
	boolean isValid();
	
	/**
	 * 
	 */
	void addHeader(Header h);
	
	/**
	 * 
	 */
	void setResource(Resource r);
	
	/**
	 * Returns the application protocol used in the response.
	 */
	Protocol getProtocol();
	
	/**
	 * 
	 */
	StatusCode getStatusCode();
	
	/**
	 * 
	 */
	List<Header> getHeaders();
	
	/**
	 * 
	 */
	int getLength();
	
	/**
	 * 
	 * @return
	 */
	byte[] getBodyData();
}
