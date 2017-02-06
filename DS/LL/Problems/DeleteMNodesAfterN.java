class DeleteMNodesAfterN {

	static class Node {

		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public void deleteNodes(Node head, int m, int n) {

		if (head == null || n <= 0 ) {
			return;
		}

		deleteNodesUtil(head, m, n);
	}

	public void deleteNodesUtil(Node head, int m, int n) {

		Node temp = head, currentPos;

		while (temp != null) {
			for (int i = 1; i < m && temp != null; i++) {
				temp = temp.next;
			}

			if (temp == null) {
				return ;
			}

			currentPos = temp.next;

			for (int i = 1 ; i <= n && currentPos != null; i++) {
				Node temp2 = currentPos;
				currentPos = currentPos.next;
				temp2 = null;
			}

			temp.next = currentPos;

			temp = currentPos;
		}
	}

	public void printList(Node head) {
		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {

		DeleteMNodesAfterN dm = new DeleteMNodesAfterN();

		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);

		int m = 2, n = 2;

		dm.deleteNodes(head, m, n);

		dm.printList(head);
	}

}