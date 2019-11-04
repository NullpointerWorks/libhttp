package exp.nullpointerworks.http.header;

import exp.nullpointerworks.http.types.ProtocolCode;

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
	public Protocol(String transferProtocol, int protocolCode)
	{
		full = transferProtocol + " " + ProtocolCode.getString(protocolCode);
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
