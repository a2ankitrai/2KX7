class KthLastElement {

	public static LinkedList.Node findKthLastElement(LinkedList.Node head, int k) {
		LinkedList.Node slow = head;
		LinkedList.Node fast = head;

		for (int i = 0; i < k; i++) {
			if (fast.next != null)
				fast = fast.next;
			else {
				return null;
			}
		}

		while(fast!=null){
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();

		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.append(5);
		ll.append(6);
		ll.append(7);

		System.out.println(findKthLastElement(ll.head,3).data);	

	}

}