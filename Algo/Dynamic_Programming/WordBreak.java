import java.util.*;

class WordBreak {

	public static boolean wordBreaker(String s, Set<String> dict) {

		boolean[] f = new boolean[s.length() + 1];

		f[0] = true;

		// Second DP
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (f[j] && dict.contains(s.substring(j, i))) {
					f[i] = true;
					break;
				}
			}
		}

		return f[s.length()];
	}

	public static void main(String[] args) {
		String s = "leetcode";
		Set<String> dict = new HashSet<>();
		dict.add("leet"); dict.add("code");

		System.out.println(wordBreaker(s, dict));

	}

}