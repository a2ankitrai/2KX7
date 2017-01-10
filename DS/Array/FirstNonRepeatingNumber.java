import java.util.LinkedHashMap;
import java.util.Map;

class FirstNonRepeatingNumber {

	public static int getNonRepeatingNum(int[] arr) {
		Map<Integer, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		for (Integer i : map.keySet()) {
			if (map.get(i) == 1) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {2,5,3,3,1,3,2,5,8,1};
		System.out.println(getNonRepeatingNum(arr));
	}

}