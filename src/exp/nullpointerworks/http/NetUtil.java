package exp.nullpointerworks.http;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nullpointerworks.util.Convert;

public class NetUtil 
{
	private static final String ip4Regex = "^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$";
	
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
