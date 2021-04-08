/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.http.service;

class ConcurrentCounter
{
	private Integer count = 0;
	
	public ConcurrentCounter() {}
	
	public ConcurrentCounter(int v) 
	{
		set(v);
	}
	
	public void increment()
	{
		synchronized(count)
		{
			count += 1;
		}
	}
	
	public void decrement()
	{
		synchronized(count)
		{
			count -= 1;
		}
	}
	
	public void set(int v) 
	{
		synchronized(count)
		{
			count = v;
		}
	}
	
	public int value()
	{
		synchronized(count)
		{
			return count;
		}
	}
	
	public boolean equals(int x)
	{
		synchronized(count)
		{
			return count == x;
		}
	}
	
	public boolean lessThen(int x)
	{
		synchronized(count)
		{
			return count < x;
		}
	}
	
	public boolean greaterThen(int x)
	{
		synchronized(count)
		{
			return count > x;
		}
	}
	
	public boolean lessEqualsThen(int x)
	{
		synchronized(count)
		{
			return count < x;
		}
	}
	
	public boolean greaterEqualsThen(int x)
	{
		synchronized(count)
		{
			return count > x;
		}
	}
}
