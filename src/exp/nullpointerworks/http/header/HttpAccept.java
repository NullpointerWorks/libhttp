/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.http.header;

import java.util.ArrayList;
import java.util.List;

import exp.nullpointerworks.http.Header;
import exp.nullpointerworks.http.HeaderType;
import exp.nullpointerworks.http.util.OptionChooser;

/**
 * Accept-Encoding request header
 */
public class HttpAccept implements Header
{
	private final Header rawHeader;
	private final OptionChooser<ContentType> oc;
	
	public HttpAccept(String data)
	{
		oc = new OptionChooser<ContentType>();
		oc.setAvailableOptions( ContentType.values() );
		rawHeader = new GenericHeader(getName(),data);
		parseData(oc,data);
	}
	
	public HttpAccept(Header raw)
	{
		oc = new OptionChooser<ContentType>();
		oc.setAvailableOptions( ContentType.values() );
		rawHeader = raw;
		parse(rawHeader);
	}
	
	private void parse(Header raw)
	{
		String data = raw.getData();
		parseData(oc, data);
	}
	
	private void parseData(OptionChooser<ContentType> oc, String data)
	{
		data = (data+",").replace(" ", "");
		List<ContentType> found = new ArrayList<ContentType>();
		String line = "";
		int i = 0;
		int l = data.length();
		for (; i<l; i++)
		{
			String chr = data.substring(i,i+1);
			if (chr.equals(","))
			{
				if (line.contains("q="))
				{
					processFound(oc, found, line);
				}
				else
				{
					ContentType ce = ContentType.fromContentType(line);
					if (ce!=null)
					{
						found.add(ce);
					}
				}
				
				line="";
				continue;
			}
			
			line += chr;
		}
	}
	
	private void processFound(OptionChooser<ContentType> oc, 
							  List<ContentType> f,
							  String line) 
	{
		String[] tokens = line.split(";");
		float q = 1.0f;
		for (String sq : tokens)
		{
			if (sq.contains("q="))
			{
				sq = sq.substring(2);
				if (sq.matches("^(|-)(\\d+\\.\\d+)"))
				{
					q = Float.parseFloat(sq);
				}
			}
		}
		
		String name = tokens[0];
		if (name.endsWith("*"))
		{
			if (name.equals("*/*"))
			{
				oc.setOption(ContentType.values(), q);
			}
			else
			{
				name = name.substring(0,name.length()-2);
				oc.setOption(ContentType.startsWith(name), q);
			}
		}
		else
		{
			ContentType ce = ContentType.fromContentType(name);
			if (ce!=null)
			{
				f.add(ce);
			}
			
			for (ContentType enc : f)
			{
				oc.setOption(enc, q);
			}
		}
		f.clear();
	}
	
	public ContentType getBestMatch(ContentType[] available)
	{
		return oc.getBestMatch(available);
	}
	
	@Override
	public String getName()
	{
		return HeaderType.ACCEPT.getString();
	}
	
	@Override
	public String getData()
	{
		return rawHeader.getData();
	}
	
	@Override
	public boolean isValid()
	{
		return rawHeader.isValid();
	}
}
