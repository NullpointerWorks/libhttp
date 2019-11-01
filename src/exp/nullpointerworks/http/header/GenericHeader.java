/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http.header;

import com.nullpointerworks.util.StringUtil;
import exp.nullpointerworks.http.types.HeaderType;

/**
 * HTTP headers allow the client and the server to pass additional information with the request or the response. An HTTP header consists of its case-insensitive name followed by a colon ':', then by its value (without line breaks). Leading white space before the value is ignored.
 * @author Michiel Drost - Nullpointer Works
 * @since 1.0.0
 */
public class GenericHeader implements Header
{
	private final int htype;
	private final String full;
	private final String header;
	private final String arguments;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public GenericHeader(String line)
	{
		full = line;
		
		if (!line.contains(":"))
		{
			header = arguments = "";
			htype = HeaderType.NULL;
			return;
		}
		
		header = StringUtil.scan(line, ":").toLowerCase();
		arguments = StringUtil.strip(line, ":");
		htype = HeaderType.getCodeFromString(header);
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public GenericHeader(int htype, String arguments) 
	{
		this.htype = htype;
		this.arguments = arguments;
		header = HeaderType.getStringFromCode(htype);
		full = header+": "+arguments;
	}
	
	@Override
	public String getName() {return header;}
	
	@Override
	public String getData() {return arguments;}
	
	@Override
	public String getString() {return full;}
	
	@Override
	public int getHeaderType() {return htype;}

	@Override
	public boolean isNull() {return htype == HeaderType.NULL;}
}
