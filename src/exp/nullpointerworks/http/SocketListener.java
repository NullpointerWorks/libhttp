/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http;

/**
 * 
 * @since 1.0.0
 */
public interface SocketListener
{
	/**
	 * Notify all listeners when a client has connected
	 * @since 1.0.0
	 */
	public void onConnect(SocketWorker sw);
	
	/**
	 * Notify all listeners when a client has disconnected
	 * @since 1.0.0
	 */
	public void onDisconnect(SocketWorker sw);
}
