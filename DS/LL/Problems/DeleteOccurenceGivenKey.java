/**
*Given a singly linked list, delete all occurrences of a given key in it. 
*For example, consider the following list.
*Input: 2 -> 2 -> 1 -> 8 -> 2 ->  3 ->  2 -> 7
*       Key to delete = 2
*Output:  1 -> 8 -> 3 -> 7
**/

import java.util.*;

class DeleteOccurenceGivenKey {


	/*static void deleteGivenKey(LinkedList<Integer> list, int k){

		Iterator<Integer> it = list.iterator();

		while(it.hasNext()){
			if(it.next() == k){
				it.remove();
			}
		}
	}*/

	static void removeOccurence(MyLinkedList ml, int k){

		if(ml == null || ml.head == null){return ;}

		MyLinkedList.Node temp = ml.head;
		MyLinkedList.Node prev = null;

		while(temp != null){
			if(temp.data == k){				
				if(temp == ml.head){
					ml.head = temp.next;
				}
				else {
					prev.next = temp.next;
				}
			}
			prev = temp;
			temp = temp.next;
		}

	}

	static void printList(MyLinkedList ml){

		if(ml == null || ml.head == null){return ;}

		MyLinkedList.Node temp = ml.head;

		while(temp != null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}


	public static void main(String[] args) {
		
		MyLinkedList ml = new MyLinkedList();

		ml.push(7);
		ml.push(2);
		ml.push(3);
		ml.push(2);
		ml.push(8);
		ml.push(1);
		ml.push(2);
		ml.push(2);

		printList(ml);

		removeOccurence(ml,2);
		System.out.println();

		printList(ml);


		/*LinkedList<Integer> l1 = new LinkedList<>();

		l1.add(7);
		l1.add(2);
		l1.add(3);
		l1.add(2);
		l1.add(8);
		l1.add(1);
		l1.add(2);
		l1.add(2);

		deleteGivenKey(l1,2);

		for(Integer i : l1){
			System.out.print(i+ " ");
		}
*/
	}
	
}