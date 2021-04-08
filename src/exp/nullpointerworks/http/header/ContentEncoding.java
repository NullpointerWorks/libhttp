/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.http.header;

/**
 * 
 */
public enum ContentEncoding
{
	/**
	 * Indicates the identity function (i.e. no compression, 
	 * nor modification). This value is always considered as 
	 * acceptable, even if not present. (developer.mozilla.org)
	 */
	IDENTIY("identity"),
	
	/**
	 * A compression format using the Lempel-Ziv coding (LZ77), 
	 * with a 32-bit CRC. (developer.mozilla.org)
	 */
	GZIP("gzip"),
	
	/**
	 * A compression format using the Brotli algorithm. (developer.mozilla.org)
	 */
	BR("br"),
	
	/**
	 * A compression format using the Lempel-Ziv-Welch (LZW) 
	 * algorithm. (developer.mozilla.org)
	 */
	COMPRESS("compress"),
	
	/**
	 * A compression format using the zlib structure, with the 
	 * deflate compression algorithm. (developer.mozilla.org)
	 */
	DEFLATE("deflate");
	
	private final String s;
	private ContentEncoding(String b){s=b;}
	
	/**
	 * 
	 */
	public String getString() {return s;}
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public static ContentEncoding fromName(String extension)
	{
		extension = extension.toLowerCase();
		ContentEncoding[] list = values();
		for (ContentEncoding mt : list)
		{
			if (mt.getString().equals(extension))
			{
				return mt;
			}
		}
		return null;
	}
}
