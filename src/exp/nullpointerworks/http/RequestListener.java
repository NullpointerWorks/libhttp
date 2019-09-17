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
public interface RequestListener
{
	/**
	 * 
	 * @since 1.0.0
	 */
	public Response onGET(Request o);
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public Response onPOST(Request o);
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public Response onHEAD(Request o);
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public Response onPUT(Request o);
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public Response onDELETE(Request o);
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public Response onOPTIONS(Request o);
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public Response onTRACE(Request o);
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public Response onCONNECT(Request o);
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public Response onUNKNOWN(Request o);
}
