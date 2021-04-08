/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.http.header;

/**
 * 
 * @since 1.0.0
 */
public enum Connection 
{
	/**
	 * 
	 * @since 1.0.0
	 */
	CLOSED(false),
	
	/**
	 * 
	 * @since 1.0.0
	 */
	KEEPALIVE(true);
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public final boolean getBoolean() {return b;}
	private final boolean b;
	private Connection(boolean b) {this.b=b;}
}
