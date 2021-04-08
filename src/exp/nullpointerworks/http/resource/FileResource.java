/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.http.resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import exp.nullpointerworks.http.Resource;

/**
 * 
 * @author Michiel
 */
public class FileResource implements Resource
{
	private final String fileName;
	private byte[] rawdata;
	private int length = 0;
	
	public FileResource(String fpath)
	{
		File f = new File(fpath);
		if (!f.exists())
		{
			fileName = "";
			rawdata = new byte[] {};
			return;
		}
		
		Path path = Paths.get(fpath);
		fileName = path.getFileName().toString();
	    try
		{
	    	byte[] data = Files.readAllBytes(path);
			copy(data);
		} 
	    catch (IOException e)
		{
	    	length = 0;
			rawdata = new byte[] {};
			e.printStackTrace();
		}
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
