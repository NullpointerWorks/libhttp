/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http.util;

/**
 * A byte-array interface to make raw data access a little more handy.
 */
public interface BytePackage
{
	/**
	 * Returns the bytes that constitute this object. 
	 * @since 1.0.0
	 * @return the bytes that constitute this object
	 */
	byte[] getBytes();
}
