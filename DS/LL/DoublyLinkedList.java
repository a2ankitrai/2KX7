class DoublyLinkedList {

	private Node head;

	static class Node {

		Node prev;
		Node next;
		int key;

		Node() {
			prev = null;
			next = null;
			key = -1;
		}

		Node(int key) {
			prev = null;
			next = null;
			this.key = key;
		}

	}

	public DoublyLinkedList() {
	}

	public void insert(int key) {
		Node newNode = new Node(key);

		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			head = newNode;
			newNode.next = temp;
			temp.prev = newNode;
		}
	}

	public void delete(int key) {
		if (head == null) {
			System.out.println("Empty Linked List");
		} else {
			Node temp = head;
			while (temp != null && temp.key != key) {
				temp = temp.next;
			}
			if (temp == null) {
				System.out.println(key + " Key not found");
			} else {
				temp.prev.next = temp.next;
				if (temp.next != null)
					temp.next.prev = temp.prev;
				System.out.println(key + " Key Removed");
			}
		}
	}

	public void display() {
		if (head == null) {
			System.out.println("Empty DoublyLinkedList");
		} else {
			Node temp = head;
			String s = "";
			while (temp != null) {
				s += temp.key + " -> ";
				temp = temp.next;
			}
			System.out.println(s);
		}
	} 

	public static void main(String[] args) {
		DoublyLinkedList dL = new DoublyLinkedList();

		dL.insert(3);
		dL.insert(21);
		dL.insert(8);
		dL.insert(65);
		dL.insert(45);

		dL.display();

		dL.delete(8);

		dL.display();

		dL.delete(69);

		dL.delete(3);

		dL.display();
	}
}