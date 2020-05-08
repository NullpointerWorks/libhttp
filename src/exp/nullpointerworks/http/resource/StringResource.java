package exp.nullpointerworks.http.resource;

public class StringResource extends GenericResource 
{
	public StringResource(String fname, String page) 
	{
		super(fname);
		setData(page.getBytes());
	}
}
