/**
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2021)
 * Using this library make you subject to its license terms.
 * 
 * @version 0.14.0
 * @author Michiel Drost - Nullpointer Works
 */
module libnpw.http
{
	requires transitive libnpw.util;
	requires java.desktop;
	
	exports exp.nullpointerworks.http;
	exports exp.nullpointerworks.http.encoding;
	exports exp.nullpointerworks.http.header;
	exports exp.nullpointerworks.http.resource;
	exports exp.nullpointerworks.http.types;
}
