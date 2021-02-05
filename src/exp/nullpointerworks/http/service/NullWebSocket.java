package exp.nullpointerworks.http.service;

import exp.nullpointerworks.http.WebSocket;

public class NullWebSocket implements WebSocket
{
	@Override
	public void open() 
	{
		
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
