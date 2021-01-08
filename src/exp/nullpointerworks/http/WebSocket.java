/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2021)
 * Using this library make you subject to its license terms.
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
 	 * Set the connection timeout in milliseconds
	 * @since 1.0.0
 	 */
	void setTimeoutLimit(int timeout);
	
	/**
	 * Set the read data buffer
	 * @since 1.0.0
	 */
	void setReadBufferSize(int rbs);
	
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
