package exp.nullpointerworks.http.header;

public enum Connection
{
	KEEPALIVE(true),
	CLOSED(false);

	boolean ka = false;
	private Connection(boolean b){ka=b;}
	public boolean getBoolean() {return ka;}
}
