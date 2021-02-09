package exp.nullpointerworks.http.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import exp.nullpointerworks.http.Resource;

/**
 * 
 * @author Michiel
 */
public class StreamResource implements Resource
{
	private String fileName;
	private byte[] rawdata;
	private int length = 0;
	
	public StreamResource(String name, InputStream is) throws IOException
	{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = br.readLine()) != null) 
        {
            sb.append(line + System.lineSeparator());
        }
        String result = sb.toString();
        rawdata = result.getBytes();
        length = rawdata.length;
        fileName = name;
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
}
