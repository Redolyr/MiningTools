package MiningTools;

import joptsimple.internal.Classes;

public class ClassInstance<T>
{
	public ClassInstance()
	{
		
	}
	public T newInstance()
	{
		try
		{
			return (T) Classes.class.newInstance();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
