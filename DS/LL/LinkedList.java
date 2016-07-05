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

		public void push(int new_data){
			Node newNode = new Node(new_data);

			newNode.next = this.head;
			this.head = newNode;
			//Time complexity of push() is O(1) as it does constant amount of work.
		}

		public void insertAfter(Node targetNode, int new_data){
			if(targetNode==null){
				System.out.println("Null node");
			}
			Node newNode = new Node(new_data);
			newNode.next = targetNode.next;
			targetNode.next = newNode;
			//Time complexity of insertAfter() is O(1) as it does constant amount of work.
		}

		public void append(int new_data){

			if(this.head==null){
				this.head = new Node(new_data);	
				return ;
			}
			Node n = this.head;
			Node newNode = new Node(new_data);
			while(n.next != null){
				n=n.next;
			}
			n.next = newNode;

			/***Time complexity of append is O(n) where n is the number of nodes in linked list. Since there is a loop from head to end, the function does O(n) work.
				This method can also be optimized to work in O(1) by keeping an extra pointer to tail of linked list
			**/
		}

		public static void main(String[] args) {
			LinkedList ll = new LinkedList();

			ll.head = new Node(1);
			Node n2 = new Node(2);
			Node n3 = new Node(3);

			ll.head.next = n2;
			n2.next = n3;

			ll.push(24);
			ll.insertAfter(n2,69);
			ll.append(38);
			ll.append(39);
			ll.append(40);
			ll.printList();				
		}
}