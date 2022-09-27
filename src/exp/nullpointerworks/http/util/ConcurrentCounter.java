/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.http.util;

/**
 * 
 * 
 * 
 * @author Michiel Drost - Nullpointer Works
 */
public class ConcurrentCounter
{
	private int count = 0;
	
	public ConcurrentCounter() {}
	
	public ConcurrentCounter(int v) 
	{
		set(v);
	}
	
	public synchronized void increment()
	{
		count += 1;
	}
	
	public synchronized void decrement()
	{
		count -= 1;
	}
	
	public synchronized void add(int v) 
	{
		count += v;
	}
	
	public synchronized void set(int v) 
	{
		count = v;
	}
	
	public synchronized int value()
	{
		return count;
	}
	
	public synchronized boolean equals(int x)
	{
		return count == x;
	}
	
	public synchronized boolean notEquals(int x)
	{
		return count != x;
	}
	
	public synchronized boolean lessThen(int x)
	{
		return count < x;
	}
	
	public synchronized boolean greaterThen(int x)
	{
		return count > x;
	}
	
	public synchronized boolean lessEqualsThen(int x)
	{
		return count <= x;
	}
	
	public synchronized boolean greaterEqualsThen(int x)
	{
		return count >= x;
	}
}
