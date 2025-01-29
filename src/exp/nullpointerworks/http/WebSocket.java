/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http;

import java.io.IOException;

import exp.nullpointerworks.http.util.ConcurrentCounter;

/**
 * 
 * @author Michiel Drost - Nullpointer Works
 */
public interface WebSocket
{
	/**
	 * 
	 * @since 1.0.0
	 */
	boolean isOpen();

	/**
	 * Set the keep-alive flag for the thread. Web socket threads are kept alive by default.
	 * @since 1.0.0
	 */
	void keepAlive(boolean ka);
	
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
	
	/**
	 * To keep track of the amount of server threads, add a counter which increments and decrements when the thread starts and stops.
	 * @param cc
	 * @since 1.0.0
	 */
	void setCounter(ConcurrentCounter cc);
}
