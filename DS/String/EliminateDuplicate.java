import java.util.*;

class EliminateDuplicate {

	public static Set<String> removeDuplicates(List<String> ipList) {

		Set<String> set = new LinkedHashSet<String>();
		Set<String> dupes = new HashSet<>();


		for (String s : ipList) {
			if (set.contains(s)) {
				set.remove(s);
				dupes.add(s);
			} else {
				if (!dupes.contains(s)) {
					set.add(s);
				}
			}
		}
		return set;

	}

	public static void main(String[] args) {


		String[] sArr = { "Ted", "John", "Mark", "Ted", "David"};

		List<String> sl = Arrays.asList(sArr);

		Set<String> output = removeDuplicates(sl);

		for(String s : output){
			System.out.print(s+" ");
		}

	}

}