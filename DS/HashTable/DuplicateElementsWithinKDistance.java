import java.util.*;

class DuplicateElementsWithinKDistance {

	public static boolean isDuplicateWithinK(int[] a, int k) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0 ; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				int prevIndex = map.get(a[i]);
				if(Math.abs(prevIndex - i) <= 3){
					return true;
				}				
			} else {
				map.put(a[i], i);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		
		int a[] = {1, 2, 3, 4, 1, 2, 3, 4};
		System.out.println("Is duplicate a: "+ isDuplicateWithinK(a,3));

		int b[] = {1, 2, 3, 4, 5};
		System.out.println("Is duplicate b: "+ isDuplicateWithinK(b,3));

		int c[] = {1, 2, 3, 1, 4, 5};
		System.out.println("Is duplicate c: "+ isDuplicateWithinK(c,3));

	}
}