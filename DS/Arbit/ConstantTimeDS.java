/*
Design a data structure that supports insert, delete, search and getRandom in constant time
Design a data structure that supports following operations in Θ(1) time.

insert(x): Inserts an item x to the data structure if not already present.

remove(x): Removes an item x from the data structure if present.

search(x): Searches an item x in the data structure.

getRandom(): Returns a random element from current set of elements
*/

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.Random;

class ConstantTimeDS {

	private List<Integer> arr;
	private Map<Integer, Integer> map;

	public ConstantTimeDS() {
		arr = new ArrayList<Integer>();
		map = new HashMap<Integer, Integer>();
	}

	public void add(int x) {

		if (map.get(x) != null) {
			System.out.println("Element already exists");
			return;
		}

		int s = arr.size();
		arr.add(x);

		map.put(x, s);

	}

	public void remove(int x) {
		Integer index = map.get(x);

		if (index == null) {
			System.out.println("Element already exists");
			return;
		}
		map.remove(x);

		// Swap element with last element so that remove from
		// arr[] can be done in O(1) time
		int size = arr.size();
		Integer last = arr.get(size - 1);
		Collections.swap(arr, index, size - 1);

		// Remove last element (This is O(1))
		arr.remove(arr.size() - 1);

		// Update hash table for new index of last element
		map.put(last, index);
	}

	public Integer search(int x) {
		return map.get(x);
	}

	public int getRandom() {
		Random rn = new Random();
		int index = rn.nextInt(arr.size());
		return arr.get(index);
	}

	public static void main(String[] args) {

		ConstantTimeDS ds = new ConstantTimeDS();
		ds.add(10);
		ds.add(20);
		ds.add(30);
		ds.add(40);
		System.out.println(ds.search(30));
		ds.remove(20);
		ds.add(50);
		System.out.println(ds.search(50));
		System.out.println(ds.getRandom());
	}
}