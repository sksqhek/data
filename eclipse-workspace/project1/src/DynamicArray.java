
public class DynamicArray<E> implements DynamicSizable<E>
{
	Object array[];
	int cap;
	int size;
	
	public DynamicArray()
	{
		cap = 1;
		size = 0;
		array = new Object[cap];		
	}
	
	@Override
	public void add(E item)
	{
		if(cap == size)
		{
			cap *= 2;
			Object tmp[] = new Object[cap];
			
			for(int i=0;i < size;i++)
			{
				tmp[i] = array[i];
			}
			array = tmp;
		}
		array[size] = item;
		size++;
	}

	@Override
	public void add(int index, E item)
	{	
		if(cap == size)
		{
			cap *= 2;
			Object tmp[] = new Object[cap];
			
			for(int i=0;i < size;i++)
			{
				tmp[i] = array[i];
			}
			array = tmp;
		}
		
		for(int i=size-1;i >= index;i--)
		{
			array[i+1] = array[i];
		}
		array[index] = item;
		size++;
	}

	@Override
	public int capacity()
	{
		return cap;
	}

	@Override
	public void clear()
	{
		size = 0;
		cap = 1;
		array = new Object[cap];
	}

	@Override
	public boolean contains(E item)
	{
		for(int i=0;i < size;i++)
		{
			if(array[i] == item)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public E get(int index)
	{	
		return (E)array[index];
	}

	@Override
	public int indexOf(E item)
	{		
		for(int i=0;i < size;i++)
		{
			if(array[i] == item)
			{
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty()
	{		
		return size == 0;
	}

	@Override
	public E remove(int index)
	{
		if(size <= cap / 2)
		{
			cap /= 2;
			Object tmp[] = new Object[cap];
			
			for(int i=0;i < size;i++)
			{
				tmp[i] = array[i];
			}
			array = tmp;
		}
		
		E e = (E)array[index];
		
		for(int i=index;i < size-1;i++)
		{
			array[i] = array[i+1];
		}
		size--;
		return e;
	}

	@Override
	public E set(int index, E item)
	{
		E e = (E)array[index];
		
		array[index] = item;
		
		return e;
	}

	@Override
	public int size()
	{
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public String toString()
	{
		String out = "{S:" + size + ", C:" + cap + ", [";
		
		for(int i=0;i < size;i++)
		{
			out += (array[i] + "");
			
			if(i < size-1)
			{
				out += ",";
			}
		}
		
		out += "]}";
		return out;
	}
}
