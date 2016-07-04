class LinkedList {
		Node head;

		static class Node{
			int data;
			Node next;

			Node(int d){
				data =d;
			}
		}

		public void printList(){
			Node n = head;
			while(n!=null){
				System.out.print(n.data+"-->");
				n=n.next;
			}
		}

		public static void main(String[] args) {
			LinkedList ll = new LinkedList();

			ll.head = new Node(1);
			Node n2 = new Node(2);
			Node n3 = new Node(3);

			ll.head.next = n2;
			n2.next = n3;

			ll.printList();				
		}
}