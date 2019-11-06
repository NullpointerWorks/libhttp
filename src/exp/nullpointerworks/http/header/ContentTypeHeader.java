/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http.header;

import static exp.nullpointerworks.http.types.FormContent.*;

import com.nullpointerworks.util.StringUtil;

import exp.nullpointerworks.http.types.FormContent;
import exp.nullpointerworks.http.types.HeaderType;

public class ContentTypeHeader implements Header
{
	private FormContent ctype = FormContent.NULL;
	
	public ContentTypeHeader(Header raw)
	{
		if (!raw.isNull()) parseHeader(raw.getString());
	}
	
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
	
	private void parseHeader(String line) 
	{
		String argument = StringUtil.strip(line, ":");
		if ( argument.equalsIgnoreCase(FORM_URLENCODED.getString()) )
			ctype = FORM_URLENCODED;
		else
		if ( argument.equalsIgnoreCase(FORM_MULTIPART.getString()) )
			ctype = FORM_MULTIPART;
	}

	@Override
	public boolean isNull() 
	{
		return ctype == NULL;
	}

	public FormContent getType()
	{
		return ctype;
	}
}
