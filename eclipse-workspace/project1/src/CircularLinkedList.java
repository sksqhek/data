
public class CircularLinkedList<E> implements ListInterface<E>
{
	SingleNode<E> Tail;
	
	public CircularLinkedList()
	{
		// TODO Auto-generated constructor stub
		Tail = null;
	}
	
	@Override
	public void add(E item)
	{
		// TODO Auto-generated method stub
		SingleNode<E> add = new SingleNode<E>();
		add.item = item;
		
		if(Tail == null)
		{
			Tail = add;
			Tail.next = Tail;
		}else
		{
			add.next = Tail.next;
			Tail.next = add;
			Tail = add;
		}
		
	}
	@Override
	public void add(int index, E item)
	{
		// TODO Auto-generated method stub
		SingleNode<E> p = Tail;
		
		for(int i=0;i < index;i++)
		{
		
		}
	}
	@Override
	public void clear()
	{
		// TODO Auto-generated method stub
		Tail = null;
	}
	@Override
	public boolean contains(E item)
	{
		// TODO Auto-generated method stub
		SingleNode<E> p = Tail.next;
		
		while(p != Tail)
		{
			if(p.item == item)
				return true;
			
			p = p.next;
		}
		if(Tail.item == item)
			return true;
		
		return false;
	}
	@Override
	public E get(int index)
	{
		// TODO Auto-generated method stub
		SingleNode<E> p = Tail.next;
		
		for(int i=0;i < index;i++)
		{	
			p = p.next;
		}
		return p.item;
	}
	@Override
	public int indexOf(E item)
	{
		// TODO Auto-generated method stub
		SingleNode<E> p = Tail.next;
		int idx = 0;
		while(p != Tail)
		{
			if(p.item == item)
				return idx;
			
			idx++;
			p = p.next;
		}
		if(Tail.item == item)
			return idx + 1;
		return -1;
	}
	@Override
	public boolean isEmpty()
	{
		// TODO Auto-generated method stub
		if(Tail == null)
			return true;
		
		return false;
	}
	@Override
	public E remove(int index)
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public E set(int index, E item)
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int size()
	{
		// TODO Auto-generated method stub
		return 0;
	}
}

class SingleNode<E>
{
	E item;
	SingleNode<E> next;
}