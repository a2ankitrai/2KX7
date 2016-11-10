/**
*Check if the two strings have identical character counts.
*/

class CheckPermutation {

	public static boolean isPermutation(String a, String b) {

		if (a.length() != b.length())
			return false;


		int[] asciiLetters = new int[256];

		char[] aChar = a.toCharArray();
		for (char c : aChar) {
			asciiLetters[c]++;
		}

		for (int i = 0; i < b.length(); i++) {
			int c = (int) b.charAt(i);
			if (--asciiLetters[c] < 0) {
				return false;
			}
		}

		return true;

	}

	public static void main(String[] args) {

		System.out.println(isPermutation("abc", "bcs"));
		System.out.println(isPermutation("abbccd", "abacd"));
	}
}