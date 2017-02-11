/***
	Problem: Write a function that takes L and F, and returns the merge of L and F.
	Your code should use O(1) additional storage—it should reuse the nodes from
the lists provided as input. Your function should use O(1) additional storage,
*/

class MergeSortedLists {

	public static void mergeList(LinkedList list1, LinkedList list2) {
		LinkedList.Node tempNode1 = list1.head;
		LinkedList.Node tempNode2 = list2.head;

		LinkedList.Node current = null;

		while (tempNode1 != null && tempNode2 != null) {
			if (tempNode1.data <= tempNode2.data) {
				if (current == null) {
					current = tempNode1;
				} else {
					current.next = tempNode1;
					current = tempNode1;
				}
				tempNode1 = tempNode1.next;
			} else {
				if (current == null) {
					current = tempNode2;
				} else {
					current.next = tempNode2;
					current = tempNode2;
				}
				tempNode2 = tempNode2.next;
			}
		}

		/* while (tempNode1 != null) {
			current.next = tempNode1;
			current = tempNode1;
			tempNode1 = tempNode1.next;
		}

		while (tempNode2 != null) {
			current.next = tempNode2;
			current = tempNode2;
			tempNode2 = tempNode2.next;
		}*/

		current.next = tempNode1 != null ? tempNode1 : tempNode2;
	}

	public static void main(String[] args) {

		LinkedList list1 = new LinkedList();
		list1.append(2);
		list1.append(5);
		list1.append(7);

		LinkedList list2 = new LinkedList();
		list2.append(3);
		list2.append(11);

		list1.printList();
		System.out.println();
		list2.printList();
		mergeList(list1, list2);
		System.out.println("\n Merged List");
		list1.printList();

	}
}