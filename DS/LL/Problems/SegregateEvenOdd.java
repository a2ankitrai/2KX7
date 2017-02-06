class SegregateEvenOdd {

	static class Node {

		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public Node segregate(Node head) {

		if (head == null || head.next == null) {
			return head;
		}

		Node odd = head;
		Node even = head.next;

		Node evenFirst = even;

		while (true) {

			if (odd == null || even == null || even.next == null) {
				odd.next = evenFirst;
				break;
			}

			odd.next = even.next;
			odd = even.next;

			if (odd.next == null) {
				even.next = null;
				odd.next = evenFirst;
				break;
			}

			even.next = odd.next;
			even = odd.next;

		}
		return head;
	}

	void printlist(Node node) {
		while (node != null) {
			System.out.print(node.data+"->");
			node = node.next;
		}
	}
	public static void main(String[] args) {
		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		SegregateEvenOdd se = new SegregateEvenOdd();

		head = se.segregate(head);

		se.printlist(head);
	}
}