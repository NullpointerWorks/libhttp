/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.http.util;

import exp.nullpointerworks.http.WebSocket;
import exp.nullpointerworks.http.WebSocketListener;

public class ThreadedWebSocketListener implements WebSocketListener
{
	private final WebSocketListener wsl;
	
	public ThreadedWebSocketListener(WebSocketListener wsl)
	{
		this.wsl = wsl;
	}
	
	@Override
	public void onSocketStart(WebSocket s)
	{
		Runnable r = () -> {wsl.onSocketStart(s);};
		new Thread(r).start();
	}

	@Override
	public void onSocketStop(WebSocket s)
	{
		Runnable r = () -> {wsl.onSocketStop(s);};
		new Thread(r).start();
	}

	@Override
	public void onSocketOpen(WebSocket s)
	{
		Runnable r = () -> {wsl.onSocketOpen(s);};
		new Thread(r).start();
	}

	@Override
	public void onSocketClose(WebSocket s)
	{
		Runnable r = () -> {wsl.onSocketClose(s);};
		new Thread(r).start();
	}

	@Override
	public void onSocketRecieving(WebSocket s)
	{
		Runnable r = () -> {wsl.onSocketRecieving(s);};
		new Thread(r).start();
	}

	@Override
	public void onSocketTransmitting(WebSocket s)
	{
		Runnable r = () -> {wsl.onSocketTransmitting(s);};
		new Thread(r).start();
	}
}
