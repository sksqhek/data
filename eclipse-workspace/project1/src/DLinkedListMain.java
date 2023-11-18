class DNode {
	String data;
	DNode llink;
	DNode rlink;

	public DNode(String x) {
		data = x;
		llink = null;
		rlink = null;
	}
}

class DLinkedList {
	DNode head;

	public void addLast(String x) {
		DNode newNode = new DNode(x);
		if (head == null) {
			head = newNode;
		} else {
			DNode p = head;
			while (p.rlink != null) {
				p = p.rlink;
			}
			p.rlink = newNode;
			newNode.llink = p;
		}
	}

	public void addFirst(String x) {
		DNode newNode = new DNode(x);
		if (head == null) {
			head = newNode;
		}
		newNode.rlink = head;
		head.llink = newNode;
		head = newNode;
	}

	public String deleteLast() {
		String x;
		DNode p, q;
		if (head == null) {
			return "삭제할 원소 없음";
		}
		p = head;
		q = null;
		while (p.rlink != null) {
			q = p;
			p = p.rlink;
		}
		x = p.data;
		q.rlink = null; // last node
		return x;
	}

	public String deleteFirst() {
		String x = " ";
		if (head == null) {
			return "삭제할 원소 없음";
		}
		x = head.data;
		head = head.rlink;
		head.llink = null;
		return x;
	}

	public void print() {
		DNode p = head;
		while (p != null) {
			System.out.print(" " + p.data);
			p = p.rlink;
		}
		System.out.println();
		
		p = head;
		while (p != null) {
			System.out.print(" " + p.data);
			p = p.rlink;
		}
		System.out.println();
	}
	
	
}

public class DLinkedListMain {
	public static void main(String[] args) {
		DLinkedList dlist1 = new DLinkedList();
		dlist1.addLast("Kim");
		dlist1.addLast("Lee");
		dlist1.addLast("Park");
		dlist1.addLast("Choi");
		dlist1.addLast("Min");
		dlist1.addLast("Ko");
		dlist1.print();
		System.out.println("삭제된 마지막 노드  " + dlist1.deleteLast());
		dlist1.print();
		dlist1.addFirst("Yoo");
		dlist1.print();
		System.out.println("삭제된 첫번째 노드 " + dlist1.deleteFirst());
		dlist1.print();
	}
}