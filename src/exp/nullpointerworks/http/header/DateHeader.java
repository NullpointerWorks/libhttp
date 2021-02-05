package exp.nullpointerworks.http.header;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import exp.nullpointerworks.http.Header;

/*
 * Mon, 27 Jul 2009 12:28:53 GMT
 */
public class DateHeader implements Header
{
	private final SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy hh:mm:ss z");
	private final String date;
	
	public DateHeader(Date fromDate)
	{
		date = getDateTimeStamp(fromDate);
	}
	
	public DateHeader()
	{
		this( new Date() );
	}
	
	@Override
	public String getName()
	{
		return "Date";
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
	
	private String getDateTimeStamp(Date fromDate)
	{
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf.format(fromDate);
	}
}
