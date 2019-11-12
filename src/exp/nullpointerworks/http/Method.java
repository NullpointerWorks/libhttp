/*
 * Creative Commons - Attribution, Share Alike 4.0 
 * Nullpointer Works (2019)
 * Use is subject to license terms.
 */
package exp.nullpointerworks.http;

import java.util.HashMap;
import java.util.Map;

import exp.nullpointerworks.http.types.ApplicationProtocol;
import exp.nullpointerworks.http.types.RequestMethod;

import static exp.nullpointerworks.http.types.RequestMethod.*;

/**
 * 
 * @author Michiel Drost - Nullpointer Works
 * @since 1.0.0
 */
public class Method
{
	private RequestMethod method = UNKNOWN;
	private ApplicationProtocol protocol = ApplicationProtocol.HTTP10;
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
		
		protocol = ApplicationProtocol.fromString(t[2]);
		method = RequestMethod.fromString(met);
		
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
					putParam(t[0], t[1]);
				}
			}
			else
			{
				t = t[1].split("=");
				putParam(t[0], t[1]);
			}
		}
		else
		{
			target = pag;
		}
		
		//target = RequestParser.parseEscaped(target);
	}
	
	/*
	 * 
	 */
	private final void putParam(String header, String data)
	{
		parameters.put(header, RequestParser.parseEscaped(data) );
	}
	
	/**
	 * Returns the integer method code
	 * @since 1.0.0
	 */
	public RequestMethod getMethodType()
	{
		return method;
	}
	
	/**
	 * Returns the transfer protocol used for this connection
	 * @since 1.0.0
	 */
	public ApplicationProtocol getTransferProtocol()
	{
		return protocol;
	}
	
	/**
	 * Returns the target page
	 * @since 1.0.0
	 */
	public String getTargetResource()
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
}
