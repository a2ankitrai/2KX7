class CompressString {

	public static String compress(String s) {

		int[] charCount = new int[256];

		for (int i = 0; i < s.length(); i++) {
			int val = (int)s.charAt(i);
			charCount[val]++;
		}
	}

	public static void main(String[] args) {
		System.out.println(compress("aabcccccaaa"));
	}
}