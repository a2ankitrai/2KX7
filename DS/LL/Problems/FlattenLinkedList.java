/*Flattening a Linked List
Given a linked list where every node represents a linked list and contains two pointers of its type:
(i) Pointer to next node in the main list (we call it ‘right’ pointer in below code)
(ii) Pointer to a linked list where this node is head (we call it ‘down’ pointer in below code).*/

class FlattenLinkedList {

	Node head;

	static class Node {

		int data;
		Node right;
		Node down;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public Node flatten(Node head) {

		if (head == null || head.right == null) { return head; }

		head.right = flatten(head.right);
		head = merge(head, head.right);

		return head;
	}

	private Node merge(Node a, Node b) {

		if (a == null) {
			return b;
		} else if (b == null) {
			return a;
		}

		Node result = null;

		if (a.data < b.data) {
			result = a;
			result.down = merge(a.down, b);
		} else {
			result = b;
			result.down = merge(a, b.down);
		}

		return result;
	}

	void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.down;
		}
		System.out.println();
	}

	/* Utility function to insert a node at begining of the
	   linked list */
	Node push(Node head_ref, int data) {
		/* 1 & 2: Allocate the Node &
		          Put in the data*/
		Node new_node = new Node(data);

		/* 3. Make next of new Node as head */
		new_node.down = head_ref;

		/* 4. Move the head to point to new Node */
		head_ref = new_node;

		/*5. return to link it back */
		return head_ref;
	}

	public static void main(String[] args) {

		FlattenLinkedList L = new FlattenLinkedList();

		L.head = L.push(L.head, 30);
		L.head = L.push(L.head, 8);
		L.head = L.push(L.head, 7);
		L.head = L.push(L.head, 5);

		L.head.right = L.push(L.head.right, 20);
		L.head.right = L.push(L.head.right, 10);

		L.head.right.right = L.push(L.head.right.right, 50);
		L.head.right.right = L.push(L.head.right.right, 22);
		L.head.right.right = L.push(L.head.right.right, 19);

		L.head.right.right.right = L.push(L.head.right.right.right, 45);
		L.head.right.right.right = L.push(L.head.right.right.right, 40);
		L.head.right.right.right = L.push(L.head.right.right.right, 35);
		L.head.right.right.right = L.push(L.head.right.right.right, 20);

		// flatten the list
		L.head = L.flatten(L.head);

		L.printList(L.head);

	}

}