
public class DoublyLinkedList<E> implements ListInterface<E>
{
	DoubleNode<E> head;
	DoubleNode<E> tail;
	
	public DoublyLinkedList()
	{
		// TODO Auto-generated constructor stub
		head = new DoubleNode();
		tail = new DoubleNode();
		head.next = tail;	
		tail.prev = head; 
	}
	
	@Override
	public void add(E item)
	{
		// TODO Auto-generated method stub
		DoubleNode<E> newNode = new DoubleNode<E>();
		newNode.item = item;
		
		newNode.prev = tail.prev;
		tail.prev.next = newNode;		
		
		newNode.next = tail;
		tail.prev = newNode;
	}

	@Override
	public void add(int index, E item)
	{
		// TODO Auto-generated method stub
		DoubleNode<E> newNode = new DoubleNode<E>();
		newNode.item = item;
				
		DoubleNode<E> p = head;
		
		for(int i=0;i < index;i++)
		{		
			p = p.next;
			
			if(p == tail)
				return;
		}
		
		newNode.next = p.next;
		p.next.prev = newNode;
		
		newNode.prev = p;
		p.next = newNode;
	}

	@Override
	public void clear()
	{
		// TODO Auto-generated method stub
		head.next = tail;
	}

	@Override
	public boolean contains(E item)
	{
		// TODO Auto-generated method stub
		DoubleNode<E> p = head.next;
		
		while(p != tail)
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
		DoubleNode<E> p = head;
		
		for(int i=0;i < index;i++)
		{		
			p = p.next;
			
			if(p == tail)
				return null;
		}
		return p.next.item;
	}

	@Override
	public int indexOf(E item)
	{
		// TODO Auto-generated method stub
		DoubleNode<E> p = head.next;
		int idx = 0;
		while(p != tail)
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
		if(head.next == tail)
			return true;
		else
			return false;
	}

	@Override
	public E remove(int index)
	{
		// TODO Auto-generated method stub
		DoubleNode<E> p = head;
		
		for(int i=0;i < index;i++)
		{		
			p = p.next;
			
			if(p == tail)
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
		DoubleNode<E> p = head;
		
		for(int i=0;i < index;i++)
		{		
			p = p.next;
			
			if(p == tail)
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
		DoubleNode<E> p = head;
		
		while(p.next != tail)
		{
			count++;
			p = p.next;
		}
		return count;
	}

}

class DoubleNode<E>
{
	E item;
	DoubleNode<E> next;
	DoubleNode<E> prev;
}
