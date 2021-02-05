package exp.nullpointerworks.http.header;

import exp.nullpointerworks.http.Header;

public class HostHeader implements Header
{
	private final Header rawheader;
	private String IP;
	private int port;
	
	public HostHeader(Header raw)
	{
		rawheader = raw;
		parse(rawheader);
	}
	
	public HostHeader(String data)
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
		return "Host";
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
