/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http;

import java.io.IOException;

/**
 * 
 * @author Michiel Drost - Nullpointer Works
 * @since 1.0.0
 */
public interface WebServer 
{
	/**
	 * Set the requested maximum length of the queue of incoming connections.
	 * @since 1.0.0
	 */
	void setBackLog(int bl);
	
	/**
	 * Allow/disallow console printing.
	 * @since 1.0.0
	 */
	void setVerbose(boolean b);
	
	/**
	 * Set the port for this webserver.
	 * @since 1.0.0
	 */
	void setPort(int port);
	
	/**
	 * Set the IP v4 address for this webserver to connect to.
	 * @since 1.0.0
	 */
	void setAddress(String ip);
	
	/**
	 * Returns the port allocated to this server.
	 * @return the port allocated to this server
	 * @since 1.0.0
	 */
	int getPort();
	
	/**
	 * Returns the IP address bound to this server.
	 * @return the IP address bound to this server
	 * @since 1.0.0
	 */
	String getAddress();
	
	/**
	 * Returns true if the new connection is allowed. This method returns true by default. Override to implement. 
	 * @return true if the new connection is allowed
	 */
	boolean allowConnection();
	/**
	 * 
	 * @since 1.0.0
	 */
	boolean isRunning();
	
	/**
	 * Starts listening to connections.
	 * @since 1.0.0
	 */
	void listen(RequestListener rl, SocketListener sl) throws IOException;
	
	/**
	 * Stops the server from listening.
	 * @since 1.0.0
	 */
	void stop();
}
