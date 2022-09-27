/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2022)
 */
package exp.nullpointerworks.http.response;

import exp.nullpointerworks.http.Protocol;
import exp.nullpointerworks.http.Resource;
import exp.nullpointerworks.http.StatusCode;

public class DefaultResponse extends AbstractResponse
{
	public DefaultResponse(Protocol p, StatusCode sc, Resource r)
	{
		setProtocol(p);
		setStatusCode(sc);
		setResource(r);
	}
}
