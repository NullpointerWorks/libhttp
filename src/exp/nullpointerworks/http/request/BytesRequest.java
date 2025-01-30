package exp.nullpointerworks.http.request;

import exp.nullpointerworks.http.Method;
import exp.nullpointerworks.http.Protocol;

public class BytesRequest extends AbstractRequest
{
	public BytesRequest(byte[] data)
	{
		setBodyData(data);
		setMethod(Method.UNKNOWN);
		setProtocol(Protocol.NULL);
		setTarget("");
	}
	
	@Override
	public byte[] getBytes()
	{
		return getBodyData();
	}
}
