//Swap nodes in a linked list without swapping data

class SwapNodes {

	private LinkedList list;

	public SwapNodes(LinkedList list) {
		this.list = list;
	}

	public void swap(LinkedList.Node n1, LinkedList.Node n2) {
		LinkedList.Node n1Prev = null, n2Prev = null, n1Next = null, n2Next = null;

		LinkedList.Node temp = list.head, prev = null;
		boolean n1Found = false, n2Found = false;

		while (temp != null) {
			if (temp == n1) {
				n1Prev = prev;
				n1Next = temp.next;
				n1Found = true;
			}
			if (temp == n2) {
				n2Prev = prev;
				n2Next = temp.next;
				n2Found = true;
			}
			prev = temp;
			temp = temp.next;
		}

		if (!n1Found) {
			System.out.println("Node 1 not found");
			return ;
		}

		if (!n2Found) {
			System.out.println("Node 2 not found");
			return ;
		}


		//n1 is head
		if (n1Prev == null) {
			list.head = n2;
			n2.next = n1.next;
			n2Prev.next = n1;
			n1.next = n2Next;
			return;
		}

		//n2 is head
		if (n2Prev == null) {
			list.head = n2;
			n2.next = n1.next;
			n2Prev.next = n1;
			n1.next = n2Next;
			return;
		}

		//if n1 and n2 are adjacent
		if(n1Next == n2 ){
			n1Prev.next = n2;
			n2.next = n1;
			n1.next = n2Next;
			return;
		}

		if(n2Next == n1 ){
			n2Prev.next = n1;
			n1.next = n2;
			n2.next = n1Next;
			return;
		}

		n1Prev.next = n2;
		n2.next = n1Next;
		n2Prev.next = n1;
		n1.next = n2Next;
		return;
	}

	public static void main(String[] args) {


		LinkedList ll = new LinkedList();

		LinkedList.Node n1 = new LinkedList.Node(10);
		LinkedList.Node n2 = new LinkedList.Node(15);
		LinkedList.Node n3 = new LinkedList.Node(12);
		LinkedList.Node n4 = new LinkedList.Node(13);
		LinkedList.Node n5 = new LinkedList.Node(20);
		LinkedList.Node n6 = new LinkedList.Node(14);

		ll.head = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		System.out.println("Before Swap: ");
		ll.printList();

		SwapNodes sn = new SwapNodes(ll);

		sn.swap(n3, n3);
		System.out.println("\nAfter Swap: ");
		ll.printList();

	}
}