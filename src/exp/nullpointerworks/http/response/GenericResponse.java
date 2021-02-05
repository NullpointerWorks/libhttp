package exp.nullpointerworks.http.response;

import java.util.ArrayList;
import java.util.List;

import exp.nullpointerworks.http.Header;
import exp.nullpointerworks.http.Protocol;
import exp.nullpointerworks.http.Resource;
import exp.nullpointerworks.http.Response;
import exp.nullpointerworks.http.StatusCode;

public class GenericResponse implements Response
{
	private Protocol protocol;
	private StatusCode status;
	private List<Header> headers;
	private Resource resource;
	
	public GenericResponse(Protocol p, StatusCode sc)
	{
		headers = new ArrayList<Header>();
		protocol = p;
		status = sc;
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
	public Protocol getApplicationProtocol()
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
	
	private final String CRLF = "\r\n";
	
	@Override
	public final byte[] getBytes()
	{
		byte[] bContent = resource.getBytes();
		byte[] bData = (protocol.getString()+CRLF).getBytes();
		for (Header h : headers)
		{
			byte[] bHeader = (h.getString()+CRLF).getBytes();
			bData = concatenate(bData, bHeader);
		}
		bData = concatenate(bData, CRLF.getBytes());
		bData = concatenate(bData, bContent);
		return bData;
	}
	
	// TODO might need optimization
	private byte[] concatenate(byte[] arr0, byte[] arr1)
	{
		byte[] totaldata = new byte[arr0.length + arr1.length];
		int i=0;
		for (byte b : arr0)
		{
			totaldata[i] = b;
			i++;
		}
		for (byte b : arr1)
		{
			totaldata[i] = b;
			i++;
		}
		return totaldata;
	}
}
