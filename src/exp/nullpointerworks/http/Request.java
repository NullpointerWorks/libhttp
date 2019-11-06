/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.util.ArrayUtil;
import com.nullpointerworks.util.Log;
import com.nullpointerworks.util.StringUtil;

import exp.nullpointerworks.http.encoding.FormData;
import exp.nullpointerworks.http.header.*;
import exp.nullpointerworks.http.types.FormContent;
import exp.nullpointerworks.http.types.HeaderType;

/**
 * 
 * @since 1.0.0
 * @author Michiel Drost - Nullpointer Works
 */
public class Request
{
	private FormData formd;
	private Method method;
	private List<Header> headers;
	private byte[] data;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public Request()
	{
		method = new Method();
		formd = new FormData();
		data = new byte[0];
		headers = new ArrayList<Header>();
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public byte[] getData() {return data;}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public Method getMethod() {return method;}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public FormData getFormData() {return formd;}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public ConnectionHeader getConnectionHeader()
	{
		Header h = findHeader( HeaderType.CONNECTION );
		return new ConnectionHeader(h);
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public ContentTypeHeader getContentTypeHeader()
	{
		Header h = findHeader( HeaderType.CONTENT_TYPE );
		return new ContentTypeHeader(h);
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public Header findHeader(final HeaderType htype)
	{
		for (Header h : headers) if (h.getHeaderType() == htype) return h;
		return new GenericHeader("");
	}
	
	// ==============================================================
	
	/**
	 * 
	 * @since 1.0.0
	 */
	protected void add(byte[] bytes)
	{
		// concatenate data
		data = ArrayUtil.concatenate(data, bytes);
		if (data.length < 1) return;
		
		// check how to interpret the data
		FormContent ctype = getContentTypeHeader().getType();
		switch(ctype)
		{
		case FORM_URLENCODED:
			formd.clear();
			
			String text = "";
			try
			{
				text = new String(data, "UTF-8");
			} 
			catch (UnsupportedEncodingException e) 
			{
				break;
			}
			
			// for each variable/data-point
			String[] parts = text.split("&");
			for (String part : parts)
			{
				String[] tokens = part.split("=");
				if (tokens.length == 2)
					formd.setData( tokens[0] , tokens[1]);
				if (tokens.length == 1) // if variable has no data
					formd.setData( tokens[0] , "");
			}
			
			break;
		case FORM_MULTIPART:
			/*
			 * TODO future implementation
			 */
			break;
		default: 
			break;
		}
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	protected void add(String line)
	{
		// if method, check
		String mtype = StringUtil.scan(line, " ");
		switch(mtype)
		{
		case "GET":
		case "HEAD":
		case "POST":
		case "TRACE":
		case "PUT":
		case "DELETE":
		case "CONNECT":
		case "OPTIONS":
			method.set(line);
			return;
		default: break;
		}
		
		GenericHeader genhead = new GenericHeader(line);
		headers.add( genhead );
		
		switch(genhead.getHeaderType())
		{
		case UNKNOWN_HEADER:
		case NULL:
		default:
			Log.err("Unknown header: \""+line+"\"");
			break;
		}
	}
}
