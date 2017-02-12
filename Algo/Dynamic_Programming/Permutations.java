import java.util.*;

class Permutations {

	public static ArrayList<String> getPerms(String str) {
		if (str == null) {return null;}

		ArrayList<String> permutation = new ArrayList<String>();

		if (str.length() == 0) {
			permutation.add("");
			return permutation;
		}

		char first = str.charAt(0);
		String remainder = str.substring(1);
		ArrayList<String> words = getPerms(remainder);
		for (String word : words) {
			for (int j = 0 ; j <= word.length(); j++) {
				String s = insertCharAt(word, first, j);
				permutation.add(s);
			}
		}
		return permutation;
	}

	 static String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}

	public static void main(String[] args) {
		
		ArrayList<String> pList = getPerms("81433086");

		for(String str : pList){
			System.out.print(str + " ");
		}
	}

}