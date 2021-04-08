/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.http;

/**
 * 
 * @since 1.0.0
 */
public interface Header
{
	/**
	 * 
	 * @since 1.0.0
	 */
	String getName();
	
	/**
	 * 
	 * @since 1.0.0
	 */
	String getData();
	
	/**
	 * 
	 * @since 1.0.0
	 */
	boolean isValid();
	
	/**
	 * 
	 * @since 1.0.0
	 */
	default String getString()
	{
		return getName()+": "+getData();
	}
}
