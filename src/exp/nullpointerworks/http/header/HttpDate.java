/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.http.header;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import exp.nullpointerworks.http.Header;
import exp.nullpointerworks.http.HeaderType;

/*
 * Mon, 27 Jul 2009 12:28:53 GMT
 */
public class HttpDate implements Header
{
	private final SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy hh:mm:ss z");
	private final String date;
	
	public HttpDate(java.util.Date fromDate)
	{
		date = getDateTimeStamp(fromDate);
	}
	
	public HttpDate()
	{
		this( new java.util.Date() );
	}
	
	@Override
	public String getName()
	{
		return HeaderType.DATE.getString();
	}

	@Override
	public String getData()
	{
		return date;
	}

	@Override
	public boolean isValid()
	{
		return false;
	}
	
	private String getDateTimeStamp(java.util.Date fromDate)
	{
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf.format(fromDate);
	}
}
