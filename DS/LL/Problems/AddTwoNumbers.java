import java.util.*;

/***
Not Working...

*/

class AddTwoNumbers {

	public static LinkedList sum(LinkedList l1, LinkedList l2) {
		LinkedList.Node sumHead = null, sumCurrent = null;
		int carryOver = 0;
		LinkedList.Node temp1 = l1.head;
		LinkedList.Node temp2 = l2.head;
		LinkedList sumList = new LinkedList();

		while (temp1 != null && temp2 != null) {
			LinkedList.Node sumNode = null;
			int tSum = temp1.data + temp2.data + carryOver;

			if (tSum >= 10) {
				sumList.append(tSum - 10);
				carryOver = 1;
			} else {
				sumList.append(tSum);
				carryOver = 0;
			}

			temp1 = temp1.next;
			temp2 = temp2.next;
		}


		if (temp1 != null) {
			sumList.append();
		}
		if (temp2 != null) {
			sumCurrent.next = new LinkedList.Node(temp2.data + carryOver);
			temp2 = temp2.next;
			while (temp2 != null) {
				sumCurrent.next = new LinkedList.Node(temp2.data);
				temp2 = temp2.next;
			}
		}

		if(carryOver == 1){
			sumList.append(1);
		}

		return sumList;
	}

	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();

		System.out.println("List 1");
		l1.append(1);
		l1.append(3);
		l1.append(4);
		
		l2.append(2);
		l2.append(4);
		l2.append(6);

		l1.printList();
		System.out.println("\nList 2");
		l2.printList();
		System.out.println("\nResult");
		LinkedList sumList = sum(l1, l2);

		sumList.printList();
	}
}