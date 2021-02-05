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
	
	// adders
	
	/**
	 * 
	 * @since 1.0.0
	 */
	void addParameter(Parameter p);
	
	/**
	 * 
	 * @since 1.0.0
	 */
	void addHeader(Header h);
	
	// setters
	
	/**
	 * 
	 * @since 1.0.0
	 */
	void setMethod(Method m);
	
	/**
	 * 
	 * @since 1.0.0
	 */
	void setProtocol(Protocol p);
	
	/**
	 * 
	 * @since 1.0.0
	 */
	void setTarget(String t);
	
	/**
	 * 
	 * @since 1.0.0
	 */
	void setBodyData(byte[] data);
	
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
}
