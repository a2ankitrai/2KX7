class ReverseString {

	public static String reverse(String s) {
		int size = s.length();
		char[] result = new char[size];

		for (int i = size - 1, j = 0; i >= 0; i--, j++) {
			result[j] = s.charAt(i);
		}

		return String.valueOf(result);
	}

	//swapping the characters
	public static String reverse2(String s) {

		char[] ch = s.toCharArray();
		int start = 0, end = ch.length - 1;
		while (start < end) {
			char temp = ch[start];
			ch[start++] = ch[end];
			ch[end--] = temp;
		}

		return String.valueOf(ch);
	}

	public static void main(String[] args) {
		System.out.println(reverse2("kisd dsje dfkjs "));
	}
}