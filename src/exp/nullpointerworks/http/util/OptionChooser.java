/*
 * This is free and unencumbered software released into the public domain.
 * (http://unlicense.org/)
 * Nullpointer Works (2021)
 */
package exp.nullpointerworks.http.util;

import java.util.ArrayList;
import java.util.List;

public final class OptionChooser<T>
{
	private T defaultOption = null;
	private final List< Duet<T,Float> > options;
	
	public OptionChooser()
	{
		options = new ArrayList<Duet<T,Float>>();
	}
	
	/**
	 * Find the best match of the specified list of options compared to the chooser's options. Returns null if none are available.
	 * 
	 * @param available - options to compare to
	 * @return the best match for the given options and weights. Returns null if none are available.
	 */
	public T getBestMatch(T[] available)
	{
		T bestOption = defaultOption;
		float bestQ = 0.0f;
		for (T pick : available)
		{
			for (Duet<T,Float> d : options)
			{
				if (d.o.equals(pick))
				if (d.q > bestQ)
				{
					bestOption = d.o;
					bestQ = d.q;
				}
			}
		}
		return bestOption;
	}
	
	public void setAvailableOptions(T[] options)
	{
		this.options.clear();
		for (T option : options)
		{
			setOption(option, 0.0f);
		}
	}
	
	public void setDefaultOption(T option)
	{
		defaultOption = option;
	}
	
	public void setPrefferedOption(T option)
	{
		setOption(option, 1.1f);
	}
	
	public void setOption(T option, float q)
	{
		for (Duet<T,Float> d : options)
		{
			if (d.o.equals(option))
			{
				if (d.q < q) d.q = q;
				return;
			}
		}
		options.add( newDuet(option,q) );
	}
	
	public void setOption(T[] options, float q)
	{
		for (T option : options)
		{
			setOption(option, q);
		}
	}
	
	private Duet<T,Float> newDuet(T option, float q)
	{
		return new Duet<T,Float>(option,q);
	}
}
