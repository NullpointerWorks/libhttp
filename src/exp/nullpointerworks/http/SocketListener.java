/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2021)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http;

/**
 * 
 * @since 1.0.0
 * @author Michiel Drost - Nullpointer Works
 */
public interface SocketListener
{
	/**
	 * Notify all listeners when a client has connected
	 * @since 1.0.0
	 */
	public void onSocketConnect(SocketWorker sw);
	
	/**
	 * Notify all listeners when a client has disconnected
	 * @since 1.0.0
	 */
	public void onSocketDisconnect(SocketWorker sw);
}
