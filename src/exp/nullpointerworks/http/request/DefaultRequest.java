/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http.request;

import exp.nullpointerworks.http.Method;
import exp.nullpointerworks.http.Protocol;

/**
 * 
 * @since 1.0.0
 */
public class DefaultRequest extends AbstractRequest
{
	public DefaultRequest()
	{
		super();
		setMethod(Method.GET);
		setProtocol(Protocol.HTTP11);
		setTarget("/");
		setBodyData(new byte[] {});
	}
}
