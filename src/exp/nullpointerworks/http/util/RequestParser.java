/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http.util;

import static exp.nullpointerworks.http.util.NetworkUtil.decodeString;

import java.util.ArrayList;
import java.util.List;

import exp.nullpointerworks.http.Header;
import exp.nullpointerworks.http.Method;
import exp.nullpointerworks.http.Parameter;
import exp.nullpointerworks.http.Protocol;
import exp.nullpointerworks.http.Request;
import exp.nullpointerworks.http.header.UnspecifiedHeader;
import exp.nullpointerworks.http.request.DefaultRequest;
import exp.nullpointerworks.http.request.RequestBuilder;

/**
 * A raw data parser to decode a byte array into a request object.
 */
public class RequestParser
{
	private final int CR = 13;
	private final int LF = 10;
	
	public Request parse(byte[] data)
	{
		Request req = new DefaultRequest();
		RequestBuilder creareq = new RequestBuilder(req);
		
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
					parseMethod(creareq, line);
					break;
				}
				length = 0;
			}
		}
		
		/*
		 * find header data
		 */
		i++; // jumps over the previous \n character
		c = 0;
		length = 0;
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
					parseHeader(creareq, line);
				}
				length = 0;
			}
		}
		
		/*
		 * catch remaining body data
		 */
		i++;
		int j = 0;
		byte[] bodyData = new byte[l-i];
		while (i<l)
		{
			c = data[i];
			bodyData[j] = c;
			i++;
			j++;
		}
		if (bodyData.length > 0)
		{
			creareq.setBodyData(bodyData);
		}
		
		return req;
	}
	
	/*
	 * parse request method
	 */
	private void parseMethod(RequestBuilder req, String line)
	{
		String[] tokens = line.split(" ");
		if (tokens.length != 3) return;
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
		
		var rm = Method.fromString(method);
		var ap = Protocol.fromString(protoc);
		var ps = findParameters(params);
		req.setMethod(rm);
		req.setProtocol(ap);
		req.setTarget(target);
		
		for (Parameter p: ps)
			req.addParameter(p);
	}
	
	private void parseHeader(RequestBuilder req, String line)
	{
		String[] tok = line.split(":\\s");
		if (tok.length!=2) return;
		String hname = tok[0];
		String hdata = tok[1].trim();
		Header h = new UnspecifiedHeader(hname, hdata);
		req.addHeader(h);
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
				pars.add( new Parameter(p[0], decodeURLCharacters(p[1]) ) );
			}
		}
		return pars;
	}
	
	private String decodeURLCharacters(String s)
    {
        if (!s.contains("%")) return s;
        	
        String d = s;
        if (d.contains("%")) d = d.replace("%20", " ");
        if (d.contains("%")) d = d.replace("%23", "#");
        if (d.contains("%")) d = d.replace("%26", "&");
        if (d.contains("%")) d = d.replace("%27", "'");
        if (d.contains("%")) d = d.replace("%28", "(");
        if (d.contains("%")) d = d.replace("%29", ")");
        if (d.contains("%")) d = d.replace("%2A", "*");
        if (d.contains("%")) d = d.replace("%2C", ",");
        if (d.contains("%")) d = d.replace("%2D", "-");
        if (d.contains("%")) d = d.replace("%2E", ".");
        if (d.contains("%")) d = d.replace("%2F", "/");
        if (d.contains("%")) d = d.replace("%3A", ":");
        if (d.contains("%")) d = d.replace("%40", "@");
        
        if (d.contains("%")) d = d.replace("%25", "%"); // replace % last
        return d;
    }
}
