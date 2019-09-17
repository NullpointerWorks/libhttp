package exp.nullpointerworks.http.header;

import static exp.nullpointerworks.http.types.ContentType.*;

import com.nullpointerworks.util.StringUtil;

import exp.nullpointerworks.http.types.ContentType;
import exp.nullpointerworks.http.types.HeaderType;

public class ContentTypeHeader implements Header
{
	private int ctype = -1;
	
	public ContentTypeHeader(Header raw)
	{
		if (!raw.isNull()) parseHeader(raw.getString());
	}
	
	@Override
	public int getHeaderType() 
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
		return ContentType.getString(ctype);
	}
	
	@Override
	public void parseHeader(String line) 
	{
		String argument = StringUtil.strip(line, ":");
		if (argument.equalsIgnoreCase(ContentType.getString(FORM_URLENCODED)))
			ctype = FORM_URLENCODED;
		else
		if (argument.equalsIgnoreCase(ContentType.getString(FORM_MULTIPART)))
			ctype = FORM_MULTIPART;
	}

	@Override
	public boolean isNull() 
	{
		return ctype == -1;
	}

	public int getType()
	{
		return ctype;
	}
}
