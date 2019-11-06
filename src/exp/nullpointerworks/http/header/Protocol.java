package exp.nullpointerworks.http.header;

import exp.nullpointerworks.http.types.ApplicationProtocol;
import exp.nullpointerworks.http.types.StatusCode;

/**
 * 
 * @since 1.0.0
 * @author Michiel Drost - Nullpointer Works
 */
public class Protocol
{
	private final ApplicationProtocol tp;
	private final StatusCode pc;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public Protocol(ApplicationProtocol transferProtocol, StatusCode protocolCode)
	{
		tp = transferProtocol;
		pc = protocolCode;
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public final String getString()
	{
		return tp.getString()+" "+pc.getString();
	}
}
