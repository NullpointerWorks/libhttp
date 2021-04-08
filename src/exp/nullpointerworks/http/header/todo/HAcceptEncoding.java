package exp.nullpointerworks.http.header.todo;

import java.util.List;

import exp.nullpointerworks.http.Header;

class HAcceptEncoding implements Header
{
	private Header rawHeader;
	
	private List<String> options;
	
	
	public HAcceptEncoding(Header raw)
	{
		rawHeader = raw;
		parse(rawHeader);
	}
	
	/*
	 * Accept-Encoding: deflate, gzip;q=1.0, *;q=0.5
	 * Accept-Encoding: br;q=1.0, gzip;q=0.8, *;q=0.1
	 * 
	 */
	private void parse(Header raw)
	{
		String data = raw.getData();
		String[] tokens = data.split("\\,");
		for(String token : tokens)
		{
			parseOption(token);
		}
	}
	
	private void parseOption(String option)
	{
		String[] tokens = option.split("\\;");
		if (tokens.length == 1)
		{
			
			
			
		}
		else
		{
			
		}
		
	}

	@Override
	public String getName()
	{
		return "Accept-Encoding";
	}
	
	@Override
	public String getData()
	{
		return "";
	}
	
	@Override
	public boolean isValid()
	{
		return false;
	}
}
