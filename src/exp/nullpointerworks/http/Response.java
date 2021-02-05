package exp.nullpointerworks.http;

import java.util.List;

/**
 * 
 */
public interface Response
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
	 * 
	 */
	Protocol getApplicationProtocol();
	
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
	 */
	byte[] getBytes();
}
