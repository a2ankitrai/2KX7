import java.util.*;

class UnionIntersectionOfLinkedList {

	public static LinkedList<Integer> union(LinkedList<Integer> l1, LinkedList<Integer> l2) {

		if (l1 == null && l2 == null) {return null;}
		if (l1 == null) {return l2;}
		if (l2 == null) {return l1;}

		HashSet<Integer> set = new HashSet<>();

		Iterator<Integer> it  = l1.iterator();

		while (it.hasNext()) {
			set.add(it.next());
		}

		Iterator<Integer> it2  = l2.iterator();

		while (it2.hasNext()) {

			Integer i = it2.next();

			if (!set.contains(i)) {
				set.add(i);
			}
		}

		LinkedList<Integer> unionList = new LinkedList<>(set);
		return unionList;
	}

	public static LinkedList<Integer> intersection(LinkedList<Integer> l1, LinkedList<Integer> l2) {

		if (l1 == null && l2 == null) {return null;}
		if (l1 == null) {return l2;}
		if (l2 == null) {return l1;}

		HashSet<Integer> l1Set = new HashSet<>();

		Iterator<Integer> it  = l1.iterator();

		while (it.hasNext()) {
			l1Set.add(it.next());
		}

		HashSet<Integer> intersectionSet = new HashSet<>();
		Iterator<Integer> it2  = l2.iterator();

		while (it2.hasNext()) {

			Integer i = it2.next();

			if (l1Set.contains(i)) {
				intersectionSet.add(i);
			}
		}
		LinkedList<Integer> intersectionList = new LinkedList<>(intersectionSet);
		return intersectionList;
	}

	public static void main(String[] args) {

		LinkedList<Integer> l1 = new LinkedList<>();
		LinkedList<Integer> l2 = new LinkedList<>();

		l1.add(20);
		l1.add(4);
		l1.add(15);
		l1.add(10);

		l2.add(10);
		l2.add(2);
		l2.add(4);
		l2.add(8);

		LinkedList<Integer> unionList = union(l1, l2);
		System.out.println("Union of LL: ");
		for (Integer i : unionList) {
			System.out.print(i + " ");
		}

		LinkedList<Integer> intersectionList = intersection(l1, l2);
		System.out.println("\nIntersection of LL: ");
		for (Integer i : intersectionList) {
			System.out.print(i + " ");
		}
	}

}