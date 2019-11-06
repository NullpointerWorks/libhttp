/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http.header;

import com.nullpointerworks.util.StringUtil;

import exp.nullpointerworks.http.types.HeaderType;

/**
 * 
 * @since 1.0.0
 */
public class ConnectionHeader implements Header
{
	private boolean keepAlive = false; // defaults to false, even if null
	private boolean isNull = true;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public ConnectionHeader(Header raw)
	{
		if (!raw.isNull()) parseHeader(raw.getString());
	}
	
	@Override
	public HeaderType getHeaderType() 
	{
		return HeaderType.CONNECTION;
	}

	@Override
	public String getName() 
	{
		return "Connection";
	}

	@Override
	public String getData() 
	{
		return (keepAlive)?"keep-alive":"close";
	}
	
	private void parseHeader(String line) 
	{
		String argument = StringUtil.strip(line, ":");
		
		keepAlive = false;
		if (argument.equalsIgnoreCase("keep-alive"))
		{
			keepAlive = true;
		}
		
		isNull = false;
	}
	
	@Override
	public boolean isNull() 
	{
		return isNull;
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public boolean isKeepAlive() 
	{
		return keepAlive;
	}
}
