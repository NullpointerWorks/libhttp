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
	public Protocol(String tp, int protocolCode)
	{
		full = tp + " " + ProtocolCode.getString(protocolCode);
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
