/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http;

import exp.nullpointerworks.http.types.ProtocolCode;

/**
 * 
 * @author Michiel Drost - Nullpointer Works
 * @since 1.0.0
 */
public class HttpException extends Exception
{
	private static final long serialVersionUID = -8183236013065744280L;
	private int code = ProtocolCode.C_500;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public HttpException() { }
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public HttpException(int code)
	{
		this.code=code;
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public int getResponseCode()
	{
		return code;
	}
}
