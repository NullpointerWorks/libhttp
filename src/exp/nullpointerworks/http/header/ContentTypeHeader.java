/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http.header;

import static exp.nullpointerworks.http.types.ContentType.*;

import com.nullpointerworks.util.StringUtil;

import exp.nullpointerworks.http.types.ContentType;
import exp.nullpointerworks.http.types.HeaderType;

/**
 * 
 * @since 1.0.0
 * @author Michiel Drost - Nullpointer Works
 */
public class ContentTypeHeader implements Header
{
	private ContentType ctype = ContentType.NULL;
	private String boundary;
	
	public ContentTypeHeader(Header raw)
	{
		boundary = "";
		if (!raw.isNull()) parseHeader(raw.getString());
	}
	
	private void parseHeader(String line) 
	{
		String[] tokens = line.split(";");
		setType(tokens[0].trim());
		
		int l = tokens.length;
		for (int i=1; i<l; i++)
		{
			String token = tokens[i].trim();
			if (token.startsWith("boundary="))
			{
				boundary = token.substring(9);
			}
		}
	}
	
	private void setType(String line)
	{
		String argument = StringUtil.strip(line, ":");
		if ( argument.equalsIgnoreCase(URLENCODED.getString()) )
			ctype = URLENCODED;
		else
		if ( argument.equalsIgnoreCase(TEXTPLAIN.getString()) )
			ctype = TEXTPLAIN;
		else
		if ( argument.equalsIgnoreCase(MULTIPART.getString()) )
			ctype = MULTIPART;
	}
	
	/*
	 * ======================================================
	 */
	
	@Override
	public HeaderType getHeaderType() 
	{
		return HeaderType.CONTENT_TYPE;
	}
	
	@Override
	public String getName() 
	{
		return "Content-Type";
	}
	
	@Override
	public String getData() 
	{
		return ctype.getString();
	}
	
	@Override
	public boolean isNull() 
	{
		return ctype == NULL;
	}
	
	public ContentType getType()
	{
		return ctype;
	}
	
	public String getBoundary()
	{
		return boundary;
	}
}
