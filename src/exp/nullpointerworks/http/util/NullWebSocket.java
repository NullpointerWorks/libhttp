/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http.util;

import exp.nullpointerworks.http.WebSocket;

/**
 * A "null" fallback socket.
 * 
 * @author Michiel
 */
public class NullWebSocket implements WebSocket
{
	@Override
	public void open() 
	{
		
	}
	
	@Override
	public boolean isOpen() 
	{
		return false;
	}
	
	@Override
	public byte[] readBytes()
	{
		return new byte[] {};
	}
	
	@Override
	public void sendBytes(byte[] msg)
	{
		
	}
	
	@Override
	public void close()
	{
		
	}
}
