/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2021)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http;

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
	 * Set the maximum number of threads for this server.
	 * @param max
	 * @since 1.0.0
	 */
	void setMaxThreads(int max);
	
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
	 * 
	 * @param sl
	 * @since 1.0.0
	 */
	void addSocketListener(SocketListener sl);
	
	/**
	 * 
	 * @param sl
	 * @since 1.0.0
	 */
	void removeSocketListener(SocketListener sl);
	
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
	 * 
	 * @since 1.0.0
	 */
	boolean isRunning();
	
	/**
	 * Starts listening to connections.
	 * @since 1.0.0
	 */
	void start();
	
	/**
	 * Stops the server from listening.
	 * @since 1.0.0
	 */
	void stop();
}
