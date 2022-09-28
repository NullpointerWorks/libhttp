package exp.nullpointerworks.http.util;

import static exp.nullpointerworks.http.util.NetworkUtil.decodeString;

import exp.nullpointerworks.http.Header;
import exp.nullpointerworks.http.Protocol;
import exp.nullpointerworks.http.Response;
import exp.nullpointerworks.http.StatusCode;
import exp.nullpointerworks.http.header.UnspecifiedHeader;
import exp.nullpointerworks.http.response.DefaultResponse;
import exp.nullpointerworks.http.response.ResponseBuilder;

public class ResponseParser
{
	private final int CR = 13;
	private final int LF = 10;
	
	public Response parse(byte[] data)
	{
		Response resp = new DefaultResponse();
		ResponseBuilder builder = new ResponseBuilder(resp);
		
		int i = 0;
		int l = data.length;
		byte[] buffer = new byte[l];
		byte p, c=0; // previous and currently read byte
		int length = 0;
		
		/*
		 * find response status code
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
					parseStatusCode(builder, line);
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
					parseHeader(builder, line);
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
			builder.setBodyData(bodyData);
		}
		
		return resp;
	}
	
	private void parseStatusCode(ResponseBuilder req, String line)
	{
		String[] tokens = line.split(" ");
		if (tokens.length < 2) return;
		
		String protoc = tokens[0];
		String status = tokens[1];
		int code = Integer.parseInt(status, 10);
		
		var ap = Protocol.fromString(protoc);
		var sc = StatusCode.fromInteger(code);
		
		req.setProtocol(ap);
		req.setStatusCode(sc);
	}
	
	private void parseHeader(ResponseBuilder bldr, String line)
	{
		String[] tok = line.split(":\\s");
		if (tok.length!=2) return;
		String hname = tok[0];
		String hdata = tok[1].trim();
		Header h = new UnspecifiedHeader(hname, hdata);
		bldr.addHeader(h);
	}
}
