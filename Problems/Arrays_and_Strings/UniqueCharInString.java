class UniqueCharInString {

	public static boolean containsUniqueCharacters(String s) {
		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
			for (int j = 0; j < s.length(); j++) {
				if (i != j && s.charAt(i) == s.charAt(j)) {
					return false;
				}
			}
		}

		return true;
	}

	public static boolean isUniqueCharInString(String s) {
		if (s.length() > 256) return false;

		boolean[] charset = new boolean[256];

		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i);
			if (charset[val]) {
				return false;
			}
			charset[val] = true;
		}
		return true;
	}

	public static void main(String[] args) {

	//	System.out.println(containsUniqueCharacters("RWEEWRWERWRDFG"));
		System.out.println(isUniqueCharInString("RWEGHJTYUss"));

	}
}