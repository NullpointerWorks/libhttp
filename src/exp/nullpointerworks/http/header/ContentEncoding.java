package exp.nullpointerworks.http.header;

/**
 * 
 */
public enum ContentEncoding
{
	/**
	 * 
	 */
	IDENTIY("identity"),
	
	/**
	 * 
	 */
	GZIP("gzip"),
	
	/**
	 * 
	 */
	BR("br"),
	
	/**
	 * 
	 */
	COMPRESS("compress"),
	
	/**
	 * 
	 */
	DEFLATE("deflate"),
	
	/**
	 * 
	 */
	WILDCARD("*");
	
	private final String s;
	private ContentEncoding(String b){s=b;}
	
	/**
	 * 
	 */
	public String getString() {return s;}
}
