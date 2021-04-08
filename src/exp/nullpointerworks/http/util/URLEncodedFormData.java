/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.http.util;

import java.util.ArrayList;
import java.util.List;

import exp.nullpointerworks.http.Request;

public class URLEncodedFormData
{
	private final String formdata;
	private List<Parameter> params;
	
	public URLEncodedFormData(Request request)
	{
		this(request.getBodyData());
	}
	
	public URLEncodedFormData(byte[] data)
	{
		params = new ArrayList<Parameter>();
		formdata = NetworkUtil.decodeString(data);
		parse(formdata);
	}
	
	public String getValue(String name)
	{
		for (Parameter p : params)
		{
			if (p.getName().equalsIgnoreCase(name))
			{
				return p.getValue();
			}
		}
		return "";
	}
	
	private void parse(String fd)
	{
		String[] tokens = fd.split("\\&");
		for (String token : tokens)
		{
			makeParam(token);
		}
	}
	
	private void makeParam(String token)
	{
		String[] t = token.split("=");
		if (t.length==2)
		{
			var p = new Parameter(t[0],t[1]);
			params.add(p);
		}
	}
}
