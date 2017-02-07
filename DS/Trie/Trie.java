import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map.Entry;


class Trie {

	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		Map<Character, TrieNode> children = root.children;

		for (int i = 0; i < word.length(); i++) {
			char s = word.charAt(i);

			TrieNode t;

			if (children.containsKey(s)) {
				t = children.get(s);
			} else {
				t = new TrieNode(s);
				children.put(s, t);
			}
			children = t.children;

			if (i == word.length() - 1) {
				t.isLeaf = true;
			}
		}
	}

	public TrieNode searchNode(String word) {
		Map<Character, TrieNode> children = root.children;

		TrieNode t = null;

		for (int i = 0; i < word.length(); i++) {
			char c  = word.charAt(i);
			if (children.containsKey(c)) {
				t = children.get(c);
				children = t.children;
			} else {
				return null;
			}
		}
		return t;
	}

	public boolean startsWith(String prefix) {
		TrieNode t = searchNode(prefix);
		if (t != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean search(String word) {
		if (searchNode(word) != null ) {
			return true;
		} else {
			return false;
		}
	}

	public List<String> getWordsFromPrefix(String prefix) {
		List<String> wordList =  new ArrayList<String>();
		Map<Character, TrieNode> children = root.children;

		String bWord = prefix;
		TrieNode t = searchNode(prefix);

		if (t != null) {
			getWordsFromPrefixUtil(wordList, prefix, t);
		}

		return wordList;
	}

	public void printWordsFromPrefix(String prefix) {
		List<String> wordList = getWordsFromPrefix(prefix);
		if (!wordList.isEmpty()) {
			for (String s : wordList) {
				System.out.println(s);
			}
		}
	}

	private void getWordsFromPrefixUtil(List<String> wordList, String wordSoFar, TrieNode t) {
		if (t.isLeaf) {
			wordList.add(wordSoFar );
		}

		Map<Character, TrieNode> children = t.children;
		for (Map.Entry<Character, TrieNode> entry : children.entrySet()) {
			getWordsFromPrefixUtil(wordList, wordSoFar + entry.getKey(), entry.getValue());
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();

		trie.insert("tiger");
		trie.insert("titan");

		trie.insert("area");
		trie.insert("are");
		trie.insert("arealove");
		trie.insert("car");
		trie.insert("cat");

		trie.printWordsFromPrefix("area");
	}
}