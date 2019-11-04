/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http;

/*
 * Internet protocol suite - Application layer
 * 
 * BGP DHCP DNS FTP HTTP 
 * HTTPS IMAP LDAP MGCP MQTT 
 * NNTP NTP POP ONC/RPC RTP 
 * RTSP RIP SIP SMTP SNMP 
 * SSH Telnet TLS/SSL XMPP 
 */

/*
 * april fools protocols
 */
//public final static String HTCPCP10 			= "HTCPCP/1.0";
//public final static String HTCPCPTEA 			= "HTCPCP-TEA";

/*
 * future implementations
 */
//public final static String HTTP2 			= "HTTP/2";
//public final static String HTTP20 			= "HTTP/2.0";
//public final static String SPDY 			= "SPDY";
//public final static String SHTTP13 			= "SHTTP/1.3";
//public final static String IRC69 			= "IRC/6.9";
//public final static String RTA11 			= "RTA/x11";

/**
 * An application layer is an abstraction layer that specifies the shared communications protocols and interface methods used by hosts in a communications network.
 * @since 1.0.0
 * @author Michiel Drost - Nullpointer Works
 */
public enum ApplicationProtocol
{
	/**
	 * A {@code null} implementation
	 * @since 1.0.0
	 */
	UNKNOWN(""),
	
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
	HTTP11("HTTP/1.1"),
	
	/**
	 * Year 2015.
	 * @since 1.0.0
	 */
	HTTP2("HTTP/2");
	
	private final String text;
	private ApplicationProtocol(String text) {this.text=text;}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public final String asText() {return text;}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static ApplicationProtocol fromString(String proto) 
	{
		switch(proto)
		{
		case "HTTP/0.9": return ApplicationProtocol.HTTP09;
		case "HTTP/1.0": return ApplicationProtocol.HTTP10;
		case "HTTP/1.1": return ApplicationProtocol.HTTP11;
		case "HTTP/2": return ApplicationProtocol.HTTP2;
		}
		return ApplicationProtocol.HTTP10;
	}
}
