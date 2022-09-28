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
public class HttpAcceptEncoding implements Header
{
	private final Header rawHeader;
	private final OptionChooser<ContentEncoding> oc;
	
	public HttpAcceptEncoding(String data)
	{
		oc = new OptionChooser<ContentEncoding>();
		oc.setAvailableOptions( ContentEncoding.values() );
		oc.setDefaultOption( ContentEncoding.IDENTIY ); // identity is always allowed as last resort
		rawHeader = new UnspecifiedHeader(getName(),data);
		parseData(oc,data);
	}
	
	public HttpAcceptEncoding(Header raw)
	{
		oc = new OptionChooser<ContentEncoding>();
		oc.setAvailableOptions( ContentEncoding.values() );
		oc.setDefaultOption( ContentEncoding.IDENTIY );
		rawHeader = raw;
		parse(rawHeader);
	}
	
	private void parse(Header raw)
	{
		String data = raw.getData();
		parseData(oc, data);
	}
	
	private void parseData(OptionChooser<ContentEncoding> oc, String data)
	{
		data = (data+",").replace(" ", "");
		List<ContentEncoding> found = new ArrayList<ContentEncoding>();
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
					ContentEncoding ce = ContentEncoding.fromName(line);
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
	
	private void processFound(OptionChooser<ContentEncoding> oc, 
							  List<ContentEncoding> f,
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
		if (name.equals("*"))
		{
			oc.setOption(ContentEncoding.values(), q);
		}
		else
		{
			ContentEncoding ce = ContentEncoding.fromName(name);
			if (ce!=null)
			{
				f.add(ce);
			}
			
			for (ContentEncoding enc : f)
			{
				oc.setOption(enc, q);
			}
		}
		f.clear();
	}
	
	public ContentEncoding getBestMatch(ContentEncoding[] available)
	{
		return oc.getBestMatch(available);
	}
	
	@Override
	public String getName()
	{
		return HeaderType.ACCEPT_ENCODING.getString();
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
