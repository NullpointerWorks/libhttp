/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.http;

/**
 * 
 */
public interface Resource
{
	/**
	 * 
	 */
	String getName();
	
	/**
	 * 
	 */
	int getLength();
	
	/**
	 * 
	 */
	byte[] getBytes();
}
