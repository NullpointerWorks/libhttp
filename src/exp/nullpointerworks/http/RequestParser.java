/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2021)
 * Using this library make you subject to its license terms.
 */
package exp.nullpointerworks.http;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nullpointerworks.util.Convert;
import com.nullpointerworks.util.ASCII;

/**
 * 
 * @since 1.0.0
 * @author Michiel Drost - Nullpointer Works
 */
public class RequestParser
{
	/**
	 * Some characters are invalid URL characters. For example, 
	 * the space character is translated to a %20. An % implies 
	 * that the following two characters are to be interpreted 
	 * as hexadecimal. Encoding a % character would become %25.
	 * @since 1.0.0
	 */
	public static final String parseEscaped(String text) 
	{
		if (text==null) return null;
		if (text.contains("%"))
		{
			Pattern patt = Pattern.compile("\\%[0-9a-fA-F]{2}");
			Matcher m = patt.matcher(text);
			while (m.find()) 
			{
				String match = m.group();
				int v = Convert.parseHexToInt(match.substring(1));
				text = text.replaceAll(match, ""+(char)v);
			}
		}
		return text;
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static Request generate(byte[] request)
	{
		Request req 		= new Request();
		req.setRawRequestData(request);
		
		int buffer_size 	= request.length;
		byte[] buffer 		= new byte[buffer_size];
        int length 			= 0;
        
        byte p, c=0; // previous and currently read byte
		int i=0; // incrementor through the request data
		
		// first we read bytes as text to understand the http request
		while (i<buffer_size)
		{
			// get next byte
			p = c;
			c = request[i];
			i++;
			
			/*
			 * records a line from the request data until \r\n has been detected.
			 */
			buffer[length] = c;
			length++;
			
			// detect \r\n
			if (p == ASCII.CR) // carriage return
			if (c == ASCII.LF) // line feed
			{
				// empty line mark, break loop, prepare for data
				if (length == 2) break;
				
				// if larger than two, we have a line to parse
				if (length > 2)
				{
					String line = toString(buffer,length-2); // don't include previous two characters \r\n
					req.add(line);
				}
				
				// reset buffer back to zero
				length = 0;
			}
		}
		
		/*
		 * parse the remainder of the request data as bytes
		 */
		length = 0;
		byte[] data = new byte[buffer_size-i];
		while (i<buffer_size)
		{
			c = request[i];
			i++;
			data[length] = c;
			length++;
		}
		req.add(data);
		
		return req;
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	private static String toString(byte[] buffer, int length)
	{
		byte[] bytes = new byte[length];
		int i=0;
		int l=length;
		for (;i<l;i++) bytes[i] = buffer[i];
		
		// try http default byte decoding 
		try { return new String(bytes, "ISO-8859-1"); } // RFC 6266 - page 11 
		catch (UnsupportedEncodingException e) { }
		
		// default java encoding/decoding (probably UTF-16)
		var text = new String(bytes);
		return text;
	}
}
