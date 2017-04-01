class DeleteAlternateNode {

	Node head;

	static class Node {
		int val;
		Node next;

		public Node(int val){
			this.val = val;
		}
	}

	public void deleteAlternate() {
		if (head == null || head.next == null) return;

		Node curr = head, prev = null;
		boolean flag = false;

		while (curr != null) {

			if (!flag) {
				prev = curr;
			} else {
				prev.next = curr.next;
			}
			curr = curr.next;
			flag = !flag;
		}
	}

	public void printList() {
		Node n = head;
		while (n != null) {
			System.out.print(n.val);
			if (n.next != null) {
				System.out.print(" --> ");
			}
			n = n.next;
		}
	}

	public static void main(String[] args) {
		DeleteAlternateNode dal = new DeleteAlternateNode();
		dal.head = new Node(1);
		dal.head.next = new Node(2);
		dal.head.next.next = new Node(3);
		dal.head.next.next.next = new Node(4);
		dal.head.next.next.next.next = new Node(5);
		dal.head.next.next.next.next.next = new Node(6);

		dal.deleteAlternate();

		dal.printList();

	}

}