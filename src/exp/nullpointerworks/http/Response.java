/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http;

import com.nullpointerworks.util.ArrayUtil;

/**
 * 
 * @since 1.0.0
 * @author Michiel Drost - Nullpointer Works
 */
public class Response
{
	private final String CRLF = "\r\n";
	private byte[] data;
	
	public Response()
	{
		data = new byte[0];
	}

	/**
	 * Add a line of text to the overall response data. This adds \r\n at the end of each string.
	 * @since 1.0.0
	 */
	public void addLine(String s)
	{
		s = s + CRLF;
		data = ArrayUtil.concatenate(data, s.getBytes());
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public void addData(String s)
	{
		data = ArrayUtil.concatenate(data, s.getBytes());
	}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public void addData(byte[] d)
	{
		data = ArrayUtil.concatenate(data, d);
	}
	
	/**
	 * Provide the return message as a String array
	 * @since 1.0.0
	 */
	public void setData(String[] lines)
	{
		for (String s : lines)
		{
			data = ArrayUtil.concatenate(data, s.getBytes());
		}
	}
	
	/**
	 * Provide the return message as a single string.
	 * @since 1.0.0
	 */
	public void setData(String s)
	{
		data = s.getBytes();
	}
	
	/**
	 * Provide the return data as a byte array
	 * @since 1.0.0
	 */
	public void setData(byte[] s)
	{
		data = ArrayUtil.copy(s);
	}
	
	/**
	 * Returns the length of the complete response package
	 * @since 1.0.0
	 */
	public int getLength()
	{
		return data.length;
	}
	
	/**
	 * Returns the complete response packages as a byte array
	 * @since 1.0.0
	 */
	public byte[] getBytes()
	{
		return data;
	}
}
