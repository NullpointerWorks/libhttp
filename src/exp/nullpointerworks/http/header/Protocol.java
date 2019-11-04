package exp.nullpointerworks.http.header;

import exp.nullpointerworks.http.ApplicationProtocol;
import exp.nullpointerworks.http.StatusCode;

/**
 * 
 * @since 1.0.0
 */
public class Protocol
{
	private final String full;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public Protocol(ApplicationProtocol transferProtocol, StatusCode protocolCode)
	{
		full = transferProtocol + " " + protocolCode.asInteger();
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public final String getString()
	{
		return full;
	}
}
