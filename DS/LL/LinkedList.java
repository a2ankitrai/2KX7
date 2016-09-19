class LinkedList {
	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
		}
	}

	public void deleteNodeByValue(int value) {
		Node temp = head, prev = null;

		if (temp == null) {
			return;
		}

		if (temp.data == value) {
			if (temp.next != null) {
				head = temp.next;
			} else {
				head = null;
			}
			return;
		}

		while (temp != null && temp.data != value) {
			prev = temp;
			temp = temp.next;
		}
		if (temp != null) {
			prev.next = temp.next;
		} else {
			System.out.println("Node value to be deleted not found..");
		}

	}

	public void deleteNodeByIndex(int index) {
		Node temp = head, prev = null;

		if (temp == null) {
			System.out.println("Empty LinkedList");
			return;
		}

		int counter = 0;
		while (temp != null) {
			if (counter == index) {
				if (temp == head) {
					head = temp.next;
				} else {
					prev.next = temp.next;
				}
				break;
			}
			counter++;
			prev = temp;
			temp = temp.next;
		}
//		System.out.println(counter);
		if (counter < index) {
			System.out.println("Index not found");
		}

	}

	public void printList() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data);
			if (n.next != null) {
				System.out.print(" --> ");
			}
			n = n.next;
		}
	}

	public void push(int new_data) {
		Node newNode = new Node(new_data);

		newNode.next = this.head;
		this.head = newNode;
		//Time complexity of push() is O(1) as it does constant amount of work.
	}

	public void insertAfter(Node targetNode, int new_data) {
		if (targetNode == null) {
			System.out.println("Null node");
		}
		Node newNode = new Node(new_data);
		newNode.next = targetNode.next;
		targetNode.next = newNode;
		//Time complexity of insertAfter() is O(1) as it does constant amount of work.
	}

	public void append(int new_data) {

		if (this.head == null) {
			this.head = new Node(new_data);
			return ;
		}
		Node n = this.head;
		Node newNode = new Node(new_data);
		while (n.next != null) {
			n = n.next;
		}
		n.next = newNode;

		/***Time complexity of append is O(n) where n is the number of nodes in linked list. Since there is a loop from head to end, the function does O(n) work.
			This method can also be optimized to work in O(1) by keeping an extra pointer to tail of linked list
		**/
	}

	/* Returns count of nodes in linked list */
	public int getCount() {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	/* Returns count of nodes in linked list */
	public int getCountRecursively() {
		return getCountR(head);
	}

	public int getCountR(Node n) {
		if (n == null) {
			return 0;
		} else {
			return 1 + getCountR(n.next);
		}
	}

	public Node search(int key) {
		Node temp = head;

		while (temp != null && temp.data != key) {
			temp = temp.next;
		}
		return temp;
	}

	public void reverseLL() {
		Node currentNode = head, prevLink = null, temp = null;

		while (currentNode != null) {
			temp = currentNode.next;
			currentNode.next = prevLink;
			prevLink = currentNode;
			currentNode = temp;
		}

	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();

		ll.head = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);

		ll.head.next = n2;
		n2.next = n3;

		ll.push(24);
		ll.insertAfter(n2, 69);
		ll.append(38);
		ll.append(39);
		ll.append(40);

		//ll.deleteNodeByValue(2);
		ll.deleteNodeByIndex(3);

		ll.printList();
		//	ll.reverseLL();
		//	System.out.println("\nAfter Reversing: ");
		//	ll.printList();
		//System.out.println("\nLinkedList size: " + ll.getCountRecursively());
		System.out.println();
		System.out.println(ll.search(39) == null ? null : ll.search(39).data);
		System.out.println(ll.search(22) == null ? null : ll.search(22).data);
	}
}