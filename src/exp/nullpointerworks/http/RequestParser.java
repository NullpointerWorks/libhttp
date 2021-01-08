/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2021)
 * Using this library make you subject to its license terms.
 */
package exp.nullpointerworks.http;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nullpointerworks.util.ArrayUtil;
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
	public static Request generate(byte[] request, int buffer_size)
	{
		Request req = new Request();
		byte[] buffer = new byte[buffer_size];
		byte[] data = new byte[0];
        int length = 0;
        byte p, c=0;
		int i=0, l=request.length;
		
		// first we read bytes as text to understand the http request
		while (i<l)
		{
			// get next byte
			p = c;
			c = request[i];
			i++;
			
			// buffer overflow
			// probably indicated by fetch() limit of 65536 bytes (64 KiB)
			if (length >= buffer_size)
			{
				data = ArrayUtil.concatenate(data, buffer);
				break;
			}
			
			buffer[length] = c;
			length++;
			
			// detect '\r\n'
			if (c == ASCII.LF) // line feed
			if (p == ASCII.CR) // carriage return
			{
				// empty line mark, break loop, prepare for data
				if (length == 2) break;
				
				// if larger than two, we have a line to parse
				if (length > 2)
				{
					String line = toString(buffer,length-2); // dont include previous two characters, \r\n
					req.add(line);
				}
				
				// reset buffer back to zero
				length = 0;
			}
		}
		
		// get http body byte data
		length = 0;
		data = new byte[l-i];
		while (i<l)
		{
			p = c;
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
