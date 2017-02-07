import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map.Entry;

class LongestPrefixMatch {

	public static String longestMatchingPrefix(Trie trie, String word) {

		Map<Character, TrieNode> children = trie.root.children;
		String res = "";
		String currentLongestMatch = "";

		for (int i = 0 ; i < word.length(); i++) {

			char s = word.charAt(i);
			TrieNode t;

			if (children.containsKey(s)) {
				t = children.get(s);
				res += t.c;
				if (t.isLeaf && currentLongestMatch.length() < res.length()) {
					currentLongestMatch = res;
				}
				children = t.children;

			} else {
				break;
			}
		}

		if(currentLongestMatch == ""){
			currentLongestMatch = "<EMPTY>";
		}

		return currentLongestMatch;
	}


	public static void main(String[] args) {

		Trie trie = new Trie();

		trie.insert("are");
		trie.insert("area");
		trie.insert("base");
		trie.insert("cat");
		trie.insert("cater");
		trie.insert("children");
		trie.insert("basement");


		System.out.println("caterer :" + longestMatchingPrefix(trie, "caterer"));
		System.out.println("basemexy :" + longestMatchingPrefix(trie, "basemexy"));
		System.out.println("child :" + longestMatchingPrefix(trie, "child"));


	}

}