class SentinelLinkedList {

	Node sentinel;

	static class Node {
		int data;
		Node prev;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public SentinelLinkedList() {
		sentinel = new Node(-1);
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
	}

	public void insert(int data) {
		Node newNode = new Node(data);
		Node prevLink = sentinel.next;

		newNode.next = prevLink;
		newNode.prev = sentinel;
		sentinel.next = newNode;

		if (sentinel.prev == sentinel) {
			sentinel.prev = newNode;
		}
	}

	public void printList() {
		Node n = sentinel.next;
		if (sentinel.next == sentinel) {
			System.out.println("Empty List");
		} else {
			while (n != sentinel) {
				System.out.print(n.data);
				if (n.next != null) {
					System.out.print(" <--> ");
				}
				n = n.next;
			}
		}
	}

	public static void main(String[] args) {
		SentinelLinkedList sL =  new SentinelLinkedList();

		sL.insert(5);
		sL.insert(2);
		sL.insert(23);
		sL.insert(11);
		sL.insert(15);

		sL.printList();
	}

}