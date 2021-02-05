package exp.nullpointerworks.http.service;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import exp.nullpointerworks.http.Protocol;
import exp.nullpointerworks.http.Request;
import exp.nullpointerworks.http.RequestListener;
import exp.nullpointerworks.http.Header;
import exp.nullpointerworks.http.Method;
import exp.nullpointerworks.http.Response;
import exp.nullpointerworks.http.header.GenericHeader;
import exp.nullpointerworks.http.request.GenericRequest;
import exp.nullpointerworks.http.util.Parameter;
import static exp.nullpointerworks.http.util.NetworkUtil.decodeString;

/**
 * 
 * @since 1.0.0
 */
public class DefaultWebSocket extends AbstractWebSocket
{
	private final int CR = 13;
	private final int LF = 10;
	private final RequestListener rl;
	
	/**
	 * 
	 * @since 1.0.0
	 */
	public DefaultWebSocket(Socket s, RequestListener rl) throws IOException
	{
		this.rl = rl;
		setSocket(s);
	}
	
	@Override
	public void onIncomingBytes(byte[] data)
	{
		Request req = new GenericRequest();
		req.setBodyData(data);
		
		int i = 0;
		int l = data.length;
		byte[] buffer = new byte[l];
		byte p, c=0; // previous and currently read byte
		int length = 0;
		
		/*
		 * find request method
		 */
		for (; i<l; i++)
		{
			p = c;
			c = data[i];
			
			buffer[length] = c; // also records \r\n
			length++; // record string length
			
			if (p == CR)
			if (c == LF)
			{
				if (length == 2) break; // empty line
				if (length > 2) // parse data
				{
					String line = decodeString(buffer,length-2);
					parseRequest(req, line);
					break;
				}
				length = 0;
			}
		}
		
		i++; // jumps over the previous \n character
		c = 0;
		length = 0;
		/*
		 * find header data
		 */
		for (; i<l; i++)
		{
			p = c;
			c = data[i];
			buffer[length] = c;
			length++;
			if (p == CR)
			if (c == LF)
			{
				if (length == 2) break;
				if (length > 2)
				{
					String line = decodeString(buffer,length-2);
					parseHeader(req, line);
				}
				length = 0;
			}
		}
		
		i++;
		int j = 0;
		byte[] bodyData = new byte[l-i];
		/*
		 * catch remaining body data
		 */
		while (i<l)
		{
			c = data[i];
			bodyData[j] = c;
			i++;
			j++;
		}
		if (bodyData.length > 0)
		{
			req.setBodyData(bodyData);
		}
		
		/*
		 * notify request observer
		 */
		if (req.isValid())
		{
			Response resp = rl.onRequest(req);
			try
			{
				keepAlive();
				sendBytes( resp.getBytes() );
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private void parseHeader(Request req, String line)
	{
		String[] tok = line.split(":\\s");
		if (tok.length!=2) return;
		String hname = tok[0];
		String hdata = tok[1].trim();
		Header h = new GenericHeader(hname, hdata);
		req.addHeader(h);
	}
	
	/*
	 * parse request method
	 */
	private void parseRequest(Request req, String line)
	{
		String[] tokens = line.split(" ");
		if (tokens.length!= 3) return;
		String method = tokens[0];
		String target = tokens[1];
		String protoc = tokens[2];
		String params = "";
		
		// parse parameters
		if (target.contains("?"))
		{
			String[] par = target.split("\\?");
			target = par[0];
			params = par[1];
		}
		
		// correct index
		if (target.equals("/")) 
		{
			target = "/index.html";
		}
		
		var rm = Method.fromString(method);
		var ap = Protocol.fromString(protoc);
		var ps = findParameters(params);
		req.setMethod(rm);
		req.setProtocol(ap);
		req.setTarget(target);
		
		for (Parameter p: ps)
			req.addParameter(p);
	}
	
	private List<Parameter> findParameters(String params)
	{
		List<Parameter> pars = new ArrayList<Parameter>();
		String[] tokens = params.split("&");
		for (String token : tokens)
		{
			String[] p = token.split("=");
			if (p.length==2)
			{
				pars.add( new Parameter(p[0], p[1]) );
			}
		}
		return pars;
	}
}
