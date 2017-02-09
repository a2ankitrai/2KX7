import java.util.*;

class MatchPattern {

	int hashcode(String word) {

		char[] cArr = word.toCharArray();
		int hash = 0;
		int ctr = 0;
		HashMap<Character, Integer> map = new HashMap<>();

		for (char c : cArr) {
			if (!map.containsKey(c)) {
				map.put(c, ctr++);
			}
			hash += map.get(c);
		}
		return hash;
	}

	List<String> getMatchedWords(String[] words, String pattern) {

		int patternHash = hashcode(pattern);
		List<String> matchWordList = new ArrayList<>();

		for (String word : words) {

			if (word.length() == pattern.length() && hashcode(word) == patternHash) {
				matchWordList.add(word);
			}
		}
		if (matchWordList.size() > 0) {
			return matchWordList;
		}
		return null;
	}

	public static void main(String[] args) {
		MatchPattern mp = new MatchPattern();

		String[] dict = { "abb", "abc", "xyz", "xyy" };
		String pattern = "foo";

		List<String> matchWordList = mp.getMatchedWords(dict,pattern);

		if(matchWordList != null){

			for (String w : matchWordList ) {
				System.out.print(w+" ");
			}
		}
		else {
			System.out.println("no words exists for given pattern");
		}

	}

}