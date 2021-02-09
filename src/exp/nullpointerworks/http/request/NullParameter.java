package exp.nullpointerworks.http.request;

import exp.nullpointerworks.http.util.Parameter;

final class NullParameter extends Parameter
{
	public NullParameter() 
	{
		super("","");
	}
	
	@Override
	public boolean isValid()
	{
		return false;
	}
}
