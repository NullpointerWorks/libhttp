/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.http.header;

import exp.nullpointerworks.http.Header;
import exp.nullpointerworks.http.HeaderType;

public class HttpHost implements Header
{
	private final Header rawheader;
	private String IP;
	private int port;
	
	public HttpHost(Header raw)
	{
		rawheader = raw;
		parse(rawheader);
	}
	
	public HttpHost(String data)
	{
		rawheader = new GenericHeader(getName(), data);
		parse(rawheader);
	}
	
	@Override
	public boolean isValid()
	{
		if (IP==null) return false;
		if (port<0 || port>65535) return false;
		return true;
	}
	
	@Override
	public String getName()
	{
		return HeaderType.HOST.getString();
	}
	
	@Override
	public String getData()
	{
		return rawheader.getData();
	}
	
	/*
	 * =================================================================
	 */
	
	private void parse(Header raw)
	{
		if (!raw.isValid()) return;
		String data = raw.getData();
		String[] tokens = data.split(":");
		if (tokens.length!=2) return;
		
		IP = tokens[0];
		port = Integer.parseInt( tokens[1] );
	}
	
	public String getAddress()
	{
		return IP;
	}
	
	public short getPort()
	{
		return (short)(port & 0x0000ffff );
	}
}
