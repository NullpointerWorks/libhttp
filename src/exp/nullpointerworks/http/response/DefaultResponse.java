/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http.response;

import exp.nullpointerworks.http.Protocol;
import exp.nullpointerworks.http.StatusCode;
import exp.nullpointerworks.http.resource.StringResource;

public class DefaultResponse extends AbstractResponse
{
	public DefaultResponse()
	{
		setProtocol(Protocol.HTTP11);
		setStatusCode(StatusCode.STATUS_204);
		setResource(new StringResource("default.html",""));
	}
}
