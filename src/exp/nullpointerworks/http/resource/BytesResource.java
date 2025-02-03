/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http.resource;

import java.util.List;

import exp.nullpointerworks.http.Resource;

/**
 * 
 * @author Michiel
 */
public class BytesResource implements Resource
{
	private byte[] rawdata;
	private int length = 0;
	
	public BytesResource(List<Byte> bytes)
	{
		copy( toArray(bytes) );
	}
	
	public BytesResource(byte[] bytes)
	{
		copy(bytes);
	}
	
	@Override
	public int getLength()
	{
		return length;
	}
	
	@Override
	public byte[] getBytes()
	{
		//printBytes(rawdata);
		return rawdata;
	}
	
	@Override
	public String getName()
	{
		return "";
	}
	
	private void copy(byte[] bytes)
	{
		int i = 0;
		length = bytes.length;
		rawdata = new byte[length];
		for (;i<length;i++) 
			rawdata[i] = bytes[i];
	}
	
	private byte[] toArray(List<Byte> b)
	{
		byte[] bs = new byte[b.size()];
		for(int i=0, l=bs.length; i<l; i++) bs[i] = b.get(i);
		return bs;
	}
	
	private void printBytes(byte[] payload)
	{
		for(byte b : payload)
		{
			System.out.print( "0b" );
			System.out.print( (b >> (7)) & 0x1 );
			System.out.print( (b >> (6)) & 0x1 );
			System.out.print( (b >> (5)) & 0x1 );
			System.out.print( ((b >> (4)) & 0x1)+"_" );
			System.out.print( (b >> (3)) & 0x1 );
			System.out.print( (b >> (2)) & 0x1 );
			System.out.print( (b >> (1)) & 0x1 );
			System.out.print( ((b) & 0x1)+" "+(int)b+"\r\n" );
		}
		System.out.println();
	}
}
