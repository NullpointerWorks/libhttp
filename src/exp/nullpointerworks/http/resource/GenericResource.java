package exp.nullpointerworks.http.resource;

import exp.nullpointerworks.http.Resource;

/**
 * 
 * @author Michiel
 */
public class GenericResource implements Resource
{
	private final String fileName;
	private byte[] rawdata;
	private int length = 0;
	
	public GenericResource(String fname, String content)
	{
		fileName = fname;
		copy( content.getBytes() );
	}
	
	@Override
	public int getLength()
	{
		return length;
	}
	
	@Override
	public byte[] getBytes()
	{
		return rawdata;
	}
	
	@Override
	public String getName()
	{
		return fileName;
	}
	
	private void copy(byte[] bytes)
	{
		int i = 0;
		length = bytes.length;
		rawdata = new byte[length];
		for (;i<length;i++) 
			rawdata[i] = bytes[i];
	}
}
