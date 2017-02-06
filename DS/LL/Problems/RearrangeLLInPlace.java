/*Rearrange a given linked list in-place.
Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln.
Rearrange the nodes in the list so that the new formed list is
: L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 …*/

class RearrangeLLInPlace {

	static class Node {

		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public Node reArrange(Node head) {

		if (head == null || head.next == null) {return head;}

		Node slowPtr = head;
		Node fastPtr = head;

		while (slowPtr != null && fastPtr.next != null) {

			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}

		Node medianNode = slowPtr.next;
		slowPtr.next = null;
		medianNode = reverseLL(medianNode);

		return mergeLL(head, medianNode);
	}

	public Node mergeLL(Node h1, Node h2) {

		Node n1 = h1, n2 = h2;

		while (n1 != null && n2 != null) {
			Node temp1 = n1.next;
			n1.next = n2 ;

			Node temp2 = n2.next;
			n2.next = temp1;

			n1 = temp1;
			n2 = temp2;
		}

		return h1;
	}

	public Node reverseLL(Node head) {
		Node currentNode = head, prevLink = null, nextNode = null;

		while (currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = prevLink;
			prevLink = currentNode;
			currentNode = nextNode;
		}
		head = prevLink;

		return head;
	}

	public void printList(Node head) {
		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {

		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		RearrangeLLInPlace rl = new RearrangeLLInPlace();
		head = rl.reArrange(head);

		rl.printList(head);
	}

}