/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http.encoding;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map.Entry;

import com.nullpointerworks.util.Convert;

/**
 * 
 * @since 1.0.0
 * @author Michiel Drost - Nullpointer Works
 */
public class FormData
{
	private Map<String,String> data;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public FormData()
	{
		data = new HashMap<String,String>();
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public void setData(String n, String d)
	{
		Pattern pattern = Pattern.compile("(\\%[0-9a-fA-F]{2})");
		Matcher m = pattern.matcher(d);
		// replace all hexadecimal ASCII marker to character
		while (m.find()) 
		{
		    String c = m.group();
		    String s = c.substring(1, 3);
		    int dec = Convert.parseHexToInt(s);
		    d = d.replace(c, ""+((char)dec));
		}
		// turn '+' to spaces
	    d = d.replace("+", " ");
		data.put(n, d);
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public void printData(PrintStream ps)
	{
		Iterator<Entry<String, String>> it = data.entrySet().iterator();
	    while (it.hasNext()) 
	    {
	    	Entry<String, String> pair = it.next();
	        ps.println(pair.getKey() + " = " + pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public String getData(String n)
	{
		if (data.containsKey(n))
		{
			return data.get(n);
		}
		return "";
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public void clear()
	{
		data.clear();
	}
}
