/*
Design an algorithm that takes a set of files containing stock trade
information in sorted order, and writes a single file containing the lines appearing in the
individual files sorted in sorted order. The algorithm should use very little RAM, ideally of
the order of a few kilobytes.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

class MergeSortedArrays {

	// @include
	private static class ArrayEntry {
		public Integer value;
		public Integer arrayId;

		public ArrayEntry(Integer value, Integer arrayId) {
			this.value = value;
			this.arrayId = arrayId;
		}
	}

	



	public static List<Integer> mergeSortedArrays(
	    List<List<Integer>> sortedArrays) {
		List<Iterator<Integer>> iters = new ArrayList<>(sortedArrays.size());
		for (List<Integer> array : sortedArrays) {
			iters.add(array.iterator());
		}
		PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(
		(sortedArrays.size()), new Comparator<ArrayEntry>() {
			@Override
			public int compare(ArrayEntry o1, ArrayEntry o2) {
				return Integer.compare(o1.value, o2.value);
			}
		});
		for (int i = 0; i < iters.size(); ++i) {
			if (iters.get(i).hasNext()) {
				minHeap.add(new ArrayEntry(iters.get(i).next(), i));
			}
		}

		List<Integer> result = new ArrayList<>();
		while (!minHeap.isEmpty()) {
			ArrayEntry headEntry = minHeap.poll();
			result.add(headEntry.value);
			if (iters.get(headEntry.arrayId).hasNext()) {
				minHeap.add(new ArrayEntry(iters.get(headEntry.arrayId).next(),
				                           headEntry.arrayId));
			}
		}
		return result;
	}
}