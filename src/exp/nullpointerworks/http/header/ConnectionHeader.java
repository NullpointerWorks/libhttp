package exp.nullpointerworks.http.header;

import exp.nullpointerworks.http.Header;

public class ConnectionHeader implements Header
{
	private final Header raw;
	private int kaState = -1;
	
	public ConnectionHeader(Header r)
	{
		raw = r;
		parse(raw);
	}
	
	public ConnectionHeader(boolean keepAlive)
	{
		String data = (keepAlive)?"keep-alive":"closed";
		kaState = (keepAlive)?1:0;
		raw = new GenericHeader(getName(), data);
	}
	
	public ConnectionHeader(Connection ka)
	{
		boolean keepAlive = ka.getBoolean();
		String data = (keepAlive)?"keep-alive":"closed";
		kaState = (keepAlive)?1:0;
		raw = new GenericHeader(getName(), data);
	}
	
	@Override
	public String getName()
	{
		return "Connection";
	}
	
	@Override
	public String getData()
	{
		return raw.getData();
	}
	
	@Override
	public boolean isValid()
	{
		return kaState != -1;
	}
	
	/*
	 * =================================================================
	 */
	
	private void parse(Header raw)
	{
		String ka = raw.getData();
		if (ka.equalsIgnoreCase("keep-alive"))
		{
			kaState = 1;
		}
		else
		if (ka.equalsIgnoreCase("close"))
		{
			kaState = 0;
		}
		else
		{
			kaState = -1;
		}
	}
	
	public boolean isKeepAlive()
	{
		return (kaState==1)?true:false;
	}
}
