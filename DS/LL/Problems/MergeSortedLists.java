/***
	Problem: Write a function that takes L and F, and returns the merge of L and F.
	Your code should use O(1) additional storage—it should reuse the nodes from
the lists provided as input. Your function should use O(1) additional storage,
*/

public class MergeSortedLists {

	public static LinkedList.Node mergeList(LinkedList list1, LinkedList list2) {
		LinkedList.Node tempNode1 = list1.head;
		LinkedList.Node tempNode2 = list2.head;

		LinkedList.Node head = new LinkedList.Node(0);
		LinkedList.Node current = head;

		while (tempNode1 != null && tempNode2 != null) {
			if (tempNode1.data <= tempNode2.data) {
				current.next = tempNode1;
				current = tempNode1;
				tempNode1 = tempNode1.next;
			} else {
				current.next = tempNode2;
				current = tempNode2;
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
		return head.next;
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
		LinkedList.Node merged = mergeList(list1, list2);
		System.out.println("\n Merged List");
		//list1.printList();
		while(merged != null){
			System.out.print(merged.data+" -> ");
			merged = merged.next;		
		}

	}
}