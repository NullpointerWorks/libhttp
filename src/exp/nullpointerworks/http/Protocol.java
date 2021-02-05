/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2021)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http;

/**
 * An application layer is an abstraction layer that specifies the shared communications protocols and interface methods used by hosts in a communications network.
 * @since 1.0.0
 * @author Michiel Drost - Nullpointer Works
 */
public enum Protocol
{
	/**
	 * A {@code null} implementation
	 * @since 1.0.0
	 */
	NULL(""),
	
	/**
	 * Year 1991. 
	 * @since 1.0.0
	 */
	HTTP09("HTTP/0.9"),
	
	/**
	 * Year 1996.
	 * @since 1.0.0
	 */
	HTTP10("HTTP/1.0"),
	
	/**
	 * Year 1997.
	 * @since 1.0.0
	 */
	HTTP11("HTTP/1.1");
	
	private final String text;
	private Protocol(String text) {this.text=text;}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public final String getString() {return text;}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static Protocol fromString(String proto) 
	{
		proto = proto.toUpperCase();
		Protocol[] list = Protocol.values();
		for (Protocol mt : list)
		{
			if (mt.getString().equals(proto))
			{
				return mt;
			}
		}
		return NULL;
	}
}
