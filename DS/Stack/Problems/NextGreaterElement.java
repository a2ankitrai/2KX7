import java.util.*;

class NextGreaterElement {

	static int[] greater(int[] nums1 , int[] nums2) {

		int[] res = new int[nums1.length];

		for (int i = 0; i < nums1.length; i++) {
			int t = nums1[i];

			for (int j = 0 ; j < nums2.length; j++) {

				if (nums2[j] == t) {
					int gr = -1;
					for (int k = j + 1; k < nums2.length; k++) {
						if (nums2[k] > nums2[j]) {
							gr = nums2[k];
							break;
						}
					}
					res[i] = gr;
					break;
				}

			}
		}
		return res;

	}

	public static int[] nextGreaterElement(int[] findNums, int[] nums) {
		Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
		Stack<Integer> stack = new Stack<>();
		for (int num : nums) {
			while (!stack.isEmpty() && stack.peek() < num)
				map.put(stack.pop(), num);
			stack.push(num);
		}
		for (int i = 0; i < findNums.length; i++) {
			//	findNums[i] = map.getOrDefault(findNums[i], -1);  // java 8 syntax
			Integer k = map.get(findNums[i]);
			if (k != null) {
				findNums[i] = k;
			} else {
				findNums[i] = -1;
			}
		}
		return findNums;
	}


	public static void main(String[] args) {

		int[] nums1 = {4, 1, 2}, nums2 = {1, 3, 4, 2};

		int[] res = nextGreaterElement(nums1, nums2);

		for (int i : res ) {
			System.out.print(i + " ");
		}

	}
}