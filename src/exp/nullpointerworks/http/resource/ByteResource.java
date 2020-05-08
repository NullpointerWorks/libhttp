package exp.nullpointerworks.http.resource;

public class ByteResource extends GenericResource 
{
	public ByteResource(String fname, byte[] page) 
	{
		super(fname);
		setData(page);
	}
}
