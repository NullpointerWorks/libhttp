/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http.service;

import java.io.IOException;
import java.net.Socket;

import exp.nullpointerworks.http.RequestListener;
import exp.nullpointerworks.http.WebSocket;

/**
 * 
 * @since 1.0.0
 */
public abstract class DefaultWebServer extends AbstractWebServer implements RequestListener
{
	@Override
	public WebSocket onNewConnection(Socket s)
	{
		try
		{
			return new DefaultWebSocket(s, this);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return new NullWebSocket();
	}
}

/**
 * A "null" fallback socket.
 * 
 * @author Michiel
 */
class NullWebSocket implements WebSocket
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
