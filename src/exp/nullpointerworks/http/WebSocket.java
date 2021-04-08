/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.http;

import java.io.IOException;

/**
 * 
 * @author Michiel Drost - Nullpointer Works
 */
public interface WebSocket
{
	/**
	 * Returns the byte array of the read bytes. Set the buffer size to adjust the byte stream data limit.
	 * @throws IOException 
	 * @since 1.0.0
	 */
	byte[] readBytes() throws IOException;
	
	/**
	 * @throws IOException 
	 * @since 1.0.0
	 */
	void sendBytes(byte[] msg) throws IOException;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	void open();
	
 	/**
 	 * Closes all I/O streams.
 	 * @throws IOException 
	 * @since 1.0.0
 	 */
	void close() throws IOException;
}
