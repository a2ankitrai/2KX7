/**
*Leaders in an array
*Write a program to print all the LEADERS in the array. 
* An element is leader if it is greater than all the elements to its right side. 
* And the rightmost element is always a leader. 
* For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
*/


import java.util.*;


class LeadersInArray {

	public static Integer[] leaders(int [] a) {

		ArrayList<Integer> list = new ArrayList<>();

		int currentMax = -1;
		int l = a.length;

		for (int i = l - 1 ; i >= 0; i--) {
			if (a[i] > currentMax) {
				list.add(a[i]);
				currentMax = a[i];
			}
		}

		Integer[] res = list.toArray(new Integer[list.size()]);

		return res;
	}

	public static void main(String[] args) {

		int[] a = {16, 17, 4, 3, 5, 2};

		Integer[] res = leaders(a);

		for (Integer i : res) {
			System.out.print(" " + i);
		}

	}
}