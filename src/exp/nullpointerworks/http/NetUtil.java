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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nullpointerworks.util.Convert;

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
	        while(matcher.find())
	        {
	        	String g = matcher.group();
	        	int v = Convert.toInt(g);
	        	if (v > 255) return false;
	        }
			return true;
		}
		return false;
	}
}
