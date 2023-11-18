
public class SinglyLinkedList<E> implements ListInterface<E>
{
	SingleNode<E> head;
	
	public SinglyLinkedList()
	{
		// TODO Auto-generated constructor stub
		head = new SingleNode();
		head.next = null;		
	}
	
	@Override
	public void add(E item)
	{
		// TODO Auto-generated method stub
		SingleNode<E> newNode = new SingleNode<E>();
		newNode.item = item;
		newNode.next = null;
		
		SingleNode<E> p = head;
		
		while(p.next != null)
		{
			p = p.next;
		}
		
		p.next = newNode;
	}

	@Override
	public void add(int index, E item)
	{
		// TODO Auto-generated method stub
		SingleNode<E> newNode = new SingleNode<E>();
		newNode.item = item;
		newNode.next = null;
		
		SingleNode<E> p = head;
		
		for(int i=0;i < index;i++)
		{		
			p = p.next;
			
			if(p == null)
				return;
		}
		
		newNode.next = p.next;
		p.next = newNode;		
	}

	@Override
	public void clear()
	{
		// TODO Auto-generated method stub
		head.next = null;
	}

	@Override
	public boolean contains(E item)
	{
		// TODO Auto-generated method stub
		SingleNode<E> p = head.next;
		
		while(p != null)
		{		
			if(p.item == item)
				return true;
			p = p.next;			
		}
		
		return false;
	}

	@Override
	public E get(int index)
	{
		// TODO Auto-generated method stub
		SingleNode<E> p = head;
		
		for(int i=0;i < index;i++)
		{		
			p = p.next;
			
			if(p == null)
				return null;
		}
		return p.next.item;
	}

	@Override
	public int indexOf(E item)
	{
		// TODO Auto-generated method stub
		SingleNode<E> p = head.next;
		int idx = 0;
		while(p != null)
		{		
			if(p.item == item)
				return idx;
			p = p.next;
			idx++;
		}		
		
		return -1;
	}

	@Override
	public boolean isEmpty()
	{
		// TODO Auto-generated method stub
		if(head.next == null)
			return true;
		else
			return false;
	}

	@Override
	public E remove(int index)
	{
		// TODO Auto-generated method stub
		SingleNode<E> p = head;
		
		for(int i=0;i < index;i++)
		{		
			p = p.next;
			
			if(p == null)
				return null;
		}
		E value = p.next.item;
		p.next = p.next.next;		
		
		return value;
	}

	@Override
	public E set(int index, E item)
	{
		// TODO Auto-generated method stub
		SingleNode<E> p = head;
		
		for(int i=0;i < index;i++)
		{		
			p = p.next;
			
			if(p == null)
				return null;
		}
		
		p.next.item = item;		
		
		return p.next.item;		
	}

	@Override
	public int size()
	{
		// TODO Auto-generated method stub
		int count = 0;
		SingleNode<E> p = head;
		
		while(p.next != null)
		{
			count++;
			p = p.next;
		}
		return count;
	}

}
