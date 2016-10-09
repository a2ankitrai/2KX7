/***
 @problem
   Write a program that takes a reference to the head of a singly linked list
   and returns null if there does not exist a
   cycle, and the reference to the start of the cycle, if a cycle is present.
   (You do not know the length of the list in advance.)

 @hint
   Consider using two iterators, one fast and one slow.

*/

class CheckingCycle {

	public static boolean checkForCycle(LinkedList list) {
		if (list.head == null) {
			System.out.println("List is empty");
			return false;
		}

		LinkedList.Node slow = list.head.next;
		LinkedList.Node fast = null;

		if (slow != null) {
			fast = list.head.next.next;
		}

		while (slow != null && fast != null) {
			if (slow == fast) {
				System.out.println("Cycle Exists");

				// Let's check cycle length

				int cycleLength = 0;

				do {
					cycleLength++;
					fast = fast.next;
				} while (slow != fast);

				System.out.println(" Cycle Length is: " + cycleLength);

				return true;
			}
			slow = slow.next;
			if (fast.next != null) {
				fast = fast.next.next;
			} else {
				fast = null;
			}
		}
		System.out.println("Cycle Does not Exists");
		return false;

	}

	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();
		list1.append(2);
		list1.append(5);
		list1.append(7);
		list1.append(9);

		System.out.println("Cycle Check for List 1:");
		checkForCycle(list1);


		LinkedList ll = new LinkedList();
		ll.head = new LinkedList.Node(1);
		LinkedList.Node n2 = new LinkedList.Node(2);
		LinkedList.Node n3 = new LinkedList.Node(3);
		LinkedList.Node n4 = new LinkedList.Node(6);
		LinkedList.Node n5 = new LinkedList.Node(9);

		ll.head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = ll.head;

		System.out.println("Cycle Check for List 2:");
		checkForCycle(ll);
	}

}