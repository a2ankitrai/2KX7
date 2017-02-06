import java.util.*;
import java.util.LinkedList;

class IntersectionSortedLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public LinkedList<Integer> getIntesectionList(LinkedList<Integer> l1 , LinkedList<Integer> l2) {

		LinkedList<Integer> intersectList = new LinkedList<Integer>();

		Iterator<Integer> it = l1.iterator();

		while (it.hasNext()) {

			Integer i = it.next();

			Iterator<Integer> it2 = l2.iterator();

			while (it2.hasNext()) {

				Integer j = it2.next();

				if (i == j) {
					intersectList.add(i);
				}
			}
		}
		return intersectList;
	}

	public Node getIntesectionList2(Node l1 , Node l2) {

		if (l1 == null || l2 == null) {
			return null;
		}

		if (l1.data < l2.data) {
			return getIntesectionList2(l1.next, l2);
		} else if (l1.data > l2.data) {
			return getIntesectionList2(l1, l2.next);
		}

		Node merger = new Node(l1.data);
		merger.next = getIntesectionList2(l1.next, l2.next);

		return merger;
	}

	public static void main(String[] args) {

		IntersectionSortedLinkedList is = new IntersectionSortedLinkedList();

		LinkedList<Integer> l1 = new LinkedList<>();
		LinkedList<Integer> l2 = new LinkedList<>();

		l1.add(1); //->2->3->4->6
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(5);
		l1.add(6);

		l2.add(2);
		l2.add(4);
		l2.add(6);
		l2.add(8);

		LinkedList<Integer> merger = is.getIntesectionList(l1, l2);

		for (Integer i : merger) {
//			System.out.print(i + "->");
		}

		Node s1  = new Node(1);
		s1.next = new Node(2);
		s1.next.next = new Node(3);
		s1.next.next.next = new Node(4);
		s1.next.next.next.next = new Node(5);
		s1.next.next.next.next.next = new Node(6);

		Node s2 = new Node(2);
		s2.next = new Node(4);
		s2.next.next = new Node(6);
		s2.next.next.next = new Node(8);

		Node merger2 = is.getIntesectionList2(s1, s2);

		while (merger2 != null) {
			System.out.print(merger2.data + " ");
			merger2 = merger2.next;
		}

	}
}