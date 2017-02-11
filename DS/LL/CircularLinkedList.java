class CircularLinkedList {

	Node head;
	Node tail;

	static class Node {
		int key;
		Node next;

		Node(int key) {
			this.key = key;
		}

	}

	public void insert(int key) {

		Node newNode = new Node(key);

		if (head == null) {
			head = newNode;
			newNode.next = head;
			tail = head;
		} else {
			newNode.next = head;
			head = newNode;
			tail.next = newNode;
		}

	}

	public void traverse() {
		if (head == null) {return ;}

		Node temp = head;
		System.out.print(temp.key + " ");
		temp = temp.next;
		

		while (temp != head) {
			System.out.print(temp.key + " ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		
		CircularLinkedList cl = new CircularLinkedList();

		cl.insert(1);
		cl.insert(2);
		cl.insert(3);
		cl.insert(4);
		cl.insert(5);
		cl.insert(6);
		cl.insert(7);

		cl.traverse();
	}

}