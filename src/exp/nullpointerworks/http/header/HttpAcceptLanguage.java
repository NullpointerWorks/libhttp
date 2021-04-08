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
public class HttpAcceptLanguage implements Header
{
	private final Header rawHeader;
	private final OptionChooser<ContentLanguage> oc;
	
	public HttpAcceptLanguage(String data)
	{
		oc = new OptionChooser<ContentLanguage>();
		oc.setAvailableOptions( ContentLanguage.values() );
		rawHeader = new GenericHeader(getName(),data);
		parseData(oc,data);
	}
	
	public HttpAcceptLanguage(Header raw)
	{
		oc = new OptionChooser<ContentLanguage>();
		oc.setAvailableOptions( ContentLanguage.values() );
		rawHeader = raw;
		parse(rawHeader);
	}
	
	private void parse(Header raw)
	{
		String data = raw.getData();
		parseData(oc, data);
	}
	
	private void parseData(OptionChooser<ContentLanguage> oc, String data)
	{
		data = (data+",").replace(" ", "");
		List<ContentLanguage> found = new ArrayList<ContentLanguage>();
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
					ContentLanguage ce = ContentLanguage.fromName(line);
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
	
	private void processFound(OptionChooser<ContentLanguage> oc, 
							  List<ContentLanguage> f,
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
			oc.setOption(ContentLanguage.values(), q);
		}
		else
		{
			ContentLanguage ce = ContentLanguage.fromName(name);
			if (ce!=null)
			{
				f.add(ce);
			}
			
			for (ContentLanguage enc : f)
			{
				oc.setOption(enc, q);
			}
		}
		f.clear();
	}
	
	public ContentLanguage getBestMatch(ContentLanguage[] available)
	{
		return oc.getBestMatch(available);
	}
	
	@Override
	public String getName()
	{
		return HeaderType.ACCEPT_LANGUAGE.getString();
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
