/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http.header;

import static exp.nullpointerworks.http.types.HeaderType.*;

import com.nullpointerworks.util.StringUtil;

/**
 * HTTP headers allow the client and the server to pass additional information with the request or the response. An HTTP header consists of its case-insensitive name followed by a colon ':', then by its value (without line breaks). Leading white space before the value is ignored.
 * @author Michiel Drost - Nullpointer Works
 * @since 1.0.0
 */
public class GenericHeader implements Header
{
	private final int htype;
	private final String full;
	private final String header;
	private final String arguments;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public GenericHeader(String line)
	{
		full = line;
		
		if (!line.contains(":"))
		{
			header = arguments = "";
			htype = -1;
			return;
		}
		
		header = StringUtil.scan(line, ":").toLowerCase();
		arguments = StringUtil.strip(line, ":");
		
		switch(header)
		{
			// =============================== General Headers
		case "connection": 
			htype = CONNECTION; break;
		case "date": 
			htype = DATE; break;
		case "pragma": 
			htype = PRAGMA; break;
		case "cache-control": 
			htype = CACHE_CONTROL; break;
		case "trailer": 
			htype = TRAILER; break;
		case "transfer-encoding": 
			htype = TRANSFER_ENCODING; break;
		case "upgrade": 
			htype = UPGRADE; break;
		case "via": 
			htype = VIA; break;
		case "warning": 
			htype = WARNING; break;
			
			// =============================== Client Request Headers
		case "accept": 
			htype = ACCEPT; break;
		case "accept-language":
			htype = ACCEPT_LANGUAGE; break;
		case "accept-encoding":
			htype = ACCEPT_ENCODING; break;
		case "accept-charset":
			htype = ACCEPT_CHARSET; break;
		case "authorization": 
			htype = AUTHORIZATION; break;
		case "cookie": 
			htype = COOKIE; break;
		case "expect": 
			htype = EXPECT; break;
		case "from": 
			htype = FROM; break;
		case "host":
			htype = HOST; break;
		case "if-match": 
			htype = IF_MATCH; break;
		case "if-modified-since": 
			htype = IF_MODIFIED_SINCE; break;
		case "if-none-match": 
			htype = IF_NONE_MATCH; break;
		case "if-range": 
			htype = IF_RANGE; break;
		case "if-unmodified-since": 
			htype = IF_UNMODIFIED_SINCE; break;
		case "max-forwards": 
			htype = MAX_FORWARDS; break;
		case "proxy-authorization": 
			htype = PROXY_AUTHORIZATION; break;
		case "range": 
			htype = RANGE; break;
		case "referer": 
			htype = REFERER; break;
		case "te": 
			htype = TE; break;
		case "user-agent":
			htype = USER_AGENT; break;
		case "upgrade-insecure-requests": 
			htype = UPGRADE_INSECURE_REQUESTS; break;
			
			// =============================== Server Response Headers
		case "accept-ranges": 
			htype = ACCEPT_RANGES; break;
		case "age": 
			htype = AGE; break;
		case "content-disposition":
			htype = CONTENT_DISPOSITION; break;
		case "etag": 
			htype = ETAG; break;
		case "location": 
			htype = LOCATION; break;
		case "proxy-authenticate": 
			htype = PROXY_AUTHENTICATE; break;
		case "retry-after": 
			htype = RETRY_AFTER; break;
		case "server": 
			htype = SERVER; break;
		case "set-cookie": 
			htype = SET_COOKIE; break;
		case "vary": 
			htype = VARY; break;
		case "www-authenticate": 
			htype = WWW_AUTHENTICATE; break;
			
			// =============================== Entity Headers
		case "allow": 
			htype = ALLOW; break;
		case "content-encoding": 
			htype = CONTENT_ENCODING; break;
		case "Content-language": 
			htype = CONTENT_LANGUAGE; break;
		case "content-length":
			htype = CONTENT_LENGTH; break;
		case "content-location": 
			htype = CONTENT_LOCATION; break;
		case "content-md5": 
			htype = CONTENT_MD5; break;
		case "content-range": 
			htype = CONTENT_RANGE; break;
		case "content-type":
			htype = CONTENT_TYPE; break;
		case "expires": 
			htype = EXPIRES; break;
		case "last-modified": 
			htype = LAST_MODIFIED; break;
			
			// ===============================
		default: 
			htype = UNKNOWN_HEADER; break;
		}
	}
	
	@Override
	public String getName() {return header;}
	
	@Override
	public String getData() {return arguments;}
	
	@Override
	public String getString() {return full;}
	
	@Override
	public int getHeaderType() {return htype;}

	@Override
	public boolean isNull() {return htype == NULL;}
}
