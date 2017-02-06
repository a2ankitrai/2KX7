/*Pairwise swap elements of a given linked list
Given a singly linked list, write a function to swap elements pairwise. 
For example, if the linked list is 1->2->3->4->5 then the function should change it to 2->1->4->3->5, 
and if the linked list is 1->2->3->4->5->6 then the function should change it to 2->1->4->3->6->5. 
*/

class PairWiseSwap {

	static class Node {

		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public Node swapPair(Node head) {

		Node temp = head;
		Node prev = null;

		while (temp != null && temp.next != null) {

			Node save = temp.next;
			temp.next = save.next;
			save.next = temp;

			if (prev == null) {
				head = save;
			}
			else {
				prev.next = save;	
			}			

			prev = 	temp;
			temp = temp.next;
		}


		return head;
	}

	public void swap(Node n1, Node n2) {

		Node temp = n2.next;
		n1.next = temp;

	}

	public void dataSwap(Node head) {

		Node temp = head;

		while (temp != null && temp.next != null) {
			int k = temp.data;
			temp.data = temp.next.data;
			temp.next.data = k;
			temp = temp.next.next;
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

		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		PairWiseSwap pw = new PairWiseSwap();

		head = pw.swapPair(head);
		//	pw.dataSwap(head);
		pw.printList(head);

	}

}