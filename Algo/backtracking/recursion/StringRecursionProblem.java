class StringRecursionProblem {

	public static void printVertical(String str) {
		if (str == null || str.equals("")) {
			return;
		} else {
			System.out.println(str.charAt(0));
			printVertical(str.substring(1));
		}
	}

	public static int numOccur(char c, String s) {
		return numOccurAux(c, s, 0);
	}

	public static int numOccurAux(char c, String s , int count) {
		if (s == null || s.equals("")) {
			return count;
		} else {
			if (c == s.charAt(0)) {
				count++;
			}
			return numOccurAux(c, s.substring(1), count);
		}
	}

	public static String removeVowels(String s) {

		if (s == null || s.equals("")) {
			return "";
		} else {
			char c = s.charAt(0);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				return removeVowels(s.substring(1));
			} else {
				return c + removeVowels(s.substring(1));
			}
		}

	}

	public static void main(String[] args) {

		System.out.println(removeVowels("ankit"));
	}
}