/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.http.util;

import java.io.UnsupportedEncodingException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 
 * @author Michiel Drost - Nullpointer Works
 * @since 1.0.0
 */
public class NetworkUtil 
{
	private static final String ip4Regex = "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}";
	
	/*
	 * decodes the byte data into a string with the proper encoding.
	 */
	public static String decodeString(byte[] data)
	{
		return decodeString(data,data.length);
	}
	
	/**
	 * decodes the byte data into a string with the proper encoding.
	 * @since 1.0.0
	 */
	public static String decodeString(byte[] data, int length)
	{
		byte[] bytes = new byte[length];
		int i=0;
		int l=length;
		for (;i<l;i++) bytes[i] = data[i];
		
		// try http default byte decoding 
		try { return new String(bytes, "ISO-8859-1"); } // RFC 6266 - page 11 
		catch (UnsupportedEncodingException e) { }
		
		// default java encoding/decoding
		var text = new String(bytes);
		return text;
	}
	
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
	public static boolean isIPv4Address(String text) 
	{
		return text.matches(ip4Regex);
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
		Date currentTime = new Date();
		return getDateTimeStamp(currentTime);
	}
	
	public static final String getDateTimeStamp(Date fromDate)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy hh:mm:ss z");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf.format(fromDate);
	}
}
