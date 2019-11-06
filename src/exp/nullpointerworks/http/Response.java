/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http;

import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.util.ArrayUtil;

import exp.nullpointerworks.http.header.GenericHeader;
import exp.nullpointerworks.http.header.Header;
import exp.nullpointerworks.http.header.Protocol;
import exp.nullpointerworks.http.types.ApplicationProtocol;
import exp.nullpointerworks.http.types.HeaderType;
import exp.nullpointerworks.http.types.StatusCode;

/**
 * 
 * @since 1.0.0
 * @author Michiel Drost - Nullpointer Works
 */
public class Response
{
	private Protocol protocol;
	private List<Header> headers;
	private byte[] content;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public Response()
	{
		clear();
		headers = new ArrayList<Header>();
	}
	
	/**
	 * Provide the return protocol.
	 * @since 1.0.0
	 */
	public void setProtocol(Protocol tp)
	{
		protocol = tp;
	}
	
	/**
	 * Provide the return protocol parameters.
	 * @since 1.0.0
	 */
	public void setProtocol(ApplicationProtocol tp, StatusCode code)
	{
		protocol = new Protocol(tp, code);
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public void addHeader(HeaderType htype, String data)
	{
		addHeader( new GenericHeader(htype, data) );
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public void addHeader(String header)
	{
		addHeader( new GenericHeader(header) );
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public void addHeader(Header header)
	{
		if (header == null) return;
		for (int i=0,l=headers.size(); i<l; i++)
		{
			Header h = headers.get(i);
			if (h.getHeaderType() == header.getHeaderType())
			{
				headers.remove(i);
				headers.add(i, header);
				return;
			}
		}
		headers.add(header);
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public void addContent(String s)
	{
		addContent(s.getBytes());
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public void addContent(byte[] d)
	{
		content = ArrayUtil.concatenate(content, d);
	}
	
	/**
	 * Provide the return message as a String array
	 * @since 1.0.0
	 */
	public void setContent(String[] lines)
	{
		for (String s : lines)
		{
			addContent(s.getBytes());
		}
	}
	
	/**
	 * Provide the return message as a single string.
	 * @since 1.0.0
	 */
	public void setContent(String s)
	{
		content = s.getBytes();
	}
	
	/**
	 * Provide the return data as a byte array.
	 * @since 1.0.0
	 */
	public void setContent(byte[] s)
	{
		content = ArrayUtil.copy(s);
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public void clear() 
	{
		if (headers!=null) headers.clear();
		protocol = null;
		content = new byte[0];
	}
	
	/**
	 * Returns the complete response packages as a byte array.
	 * @since 1.0.0
	 */
	public byte[] getBytes()
	{
		byte[] data = (protocol.getString()+"\r\n").getBytes();
		for (Header h : headers)
		{
			byte[] d = (h.getString()+"\r\n").getBytes();
			data = ArrayUtil.concatenate(data, d);
		}
		data = ArrayUtil.concatenate(data, content);
		return data;
	}
	
	/**
	 * Returns the length of the complete response package.
	 * @since 1.0.0
	 */
	public int getLength()
	{
		return getBytes().length;
	}
}
