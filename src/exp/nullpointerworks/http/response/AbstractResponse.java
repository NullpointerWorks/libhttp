/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http.response;

import java.util.ArrayList;
import java.util.List;

import exp.nullpointerworks.http.Header;
import exp.nullpointerworks.http.Protocol;
import exp.nullpointerworks.http.Resource;
import exp.nullpointerworks.http.Response;
import exp.nullpointerworks.http.StatusCode;

import static exp.nullpointerworks.http.util.NetworkUtil.CRLF;
import static exp.nullpointerworks.http.util.NetworkUtil.concatenate;

public abstract class AbstractResponse implements Response
{
	private List<Header> headers;
	private Protocol protocol;
	private StatusCode status;
	private Resource resource;
	
	public AbstractResponse()
	{
		headers = new ArrayList<Header>();
		protocol = Protocol.NULL;
		status = StatusCode.NULL;
		resource = null;
	}
	
	@Override
	public boolean isValid()
	{
		if (protocol == Protocol.NULL) return false;
		if (status == StatusCode.NULL) return false;
		if (resource == null) return false;
		return true;
	}
	
	@Override
	public void addHeader(Header h)
	{
		headers.add(h);
	}
	
	@Override
	public void setResource(Resource r)
	{
		resource = r;
	}
	
	@Override
	public Protocol getProtocol()
	{
		return protocol;
	}
	
	@Override
	public StatusCode getStatusCode()
	{
		return status;
	}
	
	@Override
	public List<Header> getHeaders()
	{
		return headers;
	}
	
	@Override
	public final int getLength()
	{
		return resource.getLength();
	}
	
	@Override
	public final byte[] getBytes()
	{
		byte[] bData = (protocol.getString()+CRLF).getBytes();
		for (Header h : headers)
		{
			byte[] bHeader = (h.getString()+CRLF).getBytes();
			bData = concatenate(bData, bHeader);
		}
		bData = concatenate(bData, CRLF.getBytes());
		
		byte[] bContent = resource.getBytes();
		bData = concatenate(bData, bContent);
		return bData;
	}
	
	void setStatusCode(StatusCode sc)
	{
		status = sc;
	}

	void setProtocol(Protocol p)
	{
		protocol = p;
	}
}
