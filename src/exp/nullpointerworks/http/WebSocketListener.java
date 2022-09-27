/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http;

/**
 * 
 * @author Michiel Drost - Nullpointer Works
 */
public interface WebSocketListener
{
	void onSocketStart(WebSocket s);
	void onSocketOpen(WebSocket s);
	void onSocketClose(WebSocket s);
	void onSocketStop(WebSocket s);
	
	void onSocketRecieving(WebSocket s);
	void onSocketTransmitting(WebSocket s);
}
