import java.util.*;

class DetectNRemoveLoop {

	Node head;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public boolean isLoop() {

		if (head == null || head.next == null) {return false;}

		Node slow = head.next;
		Node fast = null;

		if (slow.next != null) {
			fast = slow.next;
		}

		while (slow != null && fast != null) {
			if (slow == fast) {
				return true;
			}

			slow = slow.next;
			if (fast.next != null) {
				fast = fast.next.next;
			} else {
				fast = null;
			}

		}

		return false;
	}

	public void breakLoop() {

		HashSet<Node> set = new HashSet<>();

		Node temp = head;
		Node prev = null;

		while (temp != null) {
			if (!set.contains(temp)) {
				set.add(temp);
				prev = temp;
				temp = temp.next;
			} else {
				prev.next = null;
				break;
			}
		}
	}


	public void printList() {
		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

	}


	public static void main(String[] args) {

		DetectNRemoveLoop l = new DetectNRemoveLoop();

		l.head = new Node(1);
		l.head.next = new Node(2);
		l.head.next.next = new Node(3);
		l.head.next.next.next = new Node(4);
		l.head.next.next.next.next = new Node(5);
		l.head.next.next.next.next.next = l.head.next;

		System.out.println(l.isLoop());

		if (l.isLoop() == true) {l.breakLoop();}

		System.out.println(l.isLoop());

		l.printList();


	}

}