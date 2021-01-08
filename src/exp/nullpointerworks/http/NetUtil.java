/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nullpointerworks.util.Convert;

import exp.nullpointerworks.http.header.ConnectionHeader;
import exp.nullpointerworks.http.header.Header;
import exp.nullpointerworks.http.types.ApplicationProtocol;
import exp.nullpointerworks.http.types.HeaderType;

/**
 * 
 * @author Michiel Drost - Nullpointer Works
 * @since 1.0.0
 */
public class NetUtil 
{
	private static final String ip4Regex = "^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$";
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static String getLocalIPAddress()
	{
		String ip = "127.0.0.1";
		DatagramSocket socket = null;
		try
        {
			socket = new DatagramSocket();
    	}
		catch (SocketException e) 
		{
			e.printStackTrace();
			return ip;
		}
		
    	try 
    	{
			socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
		} 
    	catch (UnknownHostException e) 
    	{
			e.printStackTrace();
		}
    	
    	if (socket!=null) 
    	{
        	ip = socket.getLocalAddress().getHostAddress();
        	socket.close();
    	}
    	
		return ip;
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static boolean isIPv4Address(String ip)
	{
		if (ip.matches(ip4Regex))
		{
			String patternString = "([0-9]{1,3})";
	        Pattern pattern = Pattern.compile(patternString);
	        Matcher matcher = pattern.matcher(ip);
	        int count = 0;
	        while(matcher.find())
	        {
	        	String g = matcher.group();
	        	int v = Convert.toInt(g);
	        	if (v > 255) return false;
	        	count++;
	        }
        	if (count != 4) return false;
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the time and date of this machine in GMT<br><br>
	 * For example: <br>
	 * EEE, d MMM yyyy hh:mm:ss z<br>
	 * Tue, 11 Jun 2019 11:56:53 GMT<br>
	 * @since 1.0.0
	 */
	public static final String getDateTimeStamp()
	{
		final Date currentTime = new Date();
		final SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy hh:mm:ss z");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf.format(currentTime);
	}
	
	/**
	 * Returns a keep-alive/close string based on the request's transfer protocol.
	 * @param o - request object
	 * @return "keep-alive" or "close"
	 * @since 1.0.0
	 */
	public static String isKeepAlive(Request o)
	{
		ApplicationProtocol protocol = o.getMethod().getTransferProtocol();
		if (ApplicationProtocol.HTTP10 == protocol)
		{
			Header h = o.findHeader( HeaderType.CONNECTION );
			ConnectionHeader ka = new ConnectionHeader(h);
			if (ka.isKeepAlive()) 
				return "close";
		}
		return "keep-alive";
	}
}
