/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http.header;

import java.util.HashMap;
import java.util.Map;

import exp.nullpointerworks.http.types.ProtocolCode;

/**
 * 
 * @author Michiel Drost - Nullpointer Works
 * @since 1.0.0
 */
public class Method
{
	public static final int NULL 	= 0;
	
	/**
	 * The GET method is used to retrieve information from the given server using a given URI. Requests using GET should only retrieve data and should have no other effect on the data.
	 * @since 1.0.0
	 */
	public static final int GET 	= 1;
	
	/**
	 * Same as GET, but transfers the status line and header section only.
	 * @since 1.0.0
	 */
	public static final int HEAD 	= 2;
	
	/**
	 * A POST request is used to send data to the server, for example, customer information, file upload, etc. using HTML forms.
	 * @since 1.0.0
	 */
	public static final int POST 	= 3;
	
	/**
	 * Performs a message loop-back test along the path to the target resource.
	 * @since 1.0.0
	 */
	public static final int TRACE 	= 4;
	
	/**
	 * Replaces all current representations of the target resource with the uploaded content.
	 * @since 1.0.0
	 */
	public static final int PUT 	= 5;
	
	/**
	 * Removes all current representations of the target resource given by a URI.
	 * @since 1.0.0
	 */
	public static final int DELETE 	= 6;
	
	/**
	 * Establishes a tunnel to the server identified by a given URI.
	 * @since 1.0.0
	 */
	public static final int CONNECT = 7;
	
	/**
	 * Describes the communication options for the target resource.
	 * @since 1.0.0
	 */
	public static final int OPTIONS = 8;
	
	// =============================================
	
	private int method 		= NULL;
	private String smethod 	= "NULL";
	private String protocol = ProtocolCode.HTTP10;
	private String target 	= "/";
	private Map<String,String> parameters;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public Method()
	{
		parameters = new HashMap<String,String>();
	}
	/**
	 * 
	 * @since 1.0.0
	 */
	public void set(String m)
	{
		String[] t = m.split(" ");
		String met = t[0];
		String pag = t[1];
		String ver = t[2];
		
		// get method
		switch(met)
		{
		case "GET": method = GET; break;
		case "HEAD": method = HEAD; break;
		case "POST": method = POST; break;
		case "TRACE": method = TRACE; break;
		case "PUT": method = PUT; break;
		case "DELETE": method = DELETE; break;
		case "CONNECT": method = CONNECT; break;
		case "OPTIONS": method = OPTIONS; break;
		default: method = NULL; break;
		}
		
		smethod = met;
		
		// get page with options, if any..
		if (pag.contains("?"))
		{
			t = pag.split("\\?");
			target = t[0];
			
			// if it has multiple..
			if (t[1].contains("&"))
			{
				t = t[1].split("\\&");
				for (String o : t)
				{
					t = o.split("=");
					parameters.put(t[0], t[1]);
				}
			}
			else
			{
				t = t[1].split("=");
				parameters.put(t[0], t[1]);
			}
		}
		else
		{
			target = pag;
		}
		
		// set transfer protocol
		protocol = ver;
	}
	
	/**
	 * Returns the integer method code
	 * @since 1.0.0
	 */
	public int getMethodType()
	{
		return method;
	}
	
	/**
	 * Returns the method type
	 * @since 1.0.0
	 */
	public String getMethodName()
	{
		return smethod;
	}
	
	/**
	 * Returns the target page
	 * @since 1.0.0
	 */
	public String getTargetPage()
	{
		return target;
	}
	
	/**
	 * Returns the value of the given parameter given through the page parameters, or {@code null} if the value is not available
	 * @since 1.0.0
	 */
	public String getParameter(String key)
	{
		return parameters.get(key);
	}
	
	/**
	 * Returns the transfer protocol used for this connection
	 * @since 1.0.0
	 */
	public String getTransferProtocol()
	{
		return protocol;
	}
}
