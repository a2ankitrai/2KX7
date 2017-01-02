class CompressString {

	public static String compress(String s) {

		char[] sArr = s.toCharArray();
		String o = "";
		boolean firstTimeFlag = true;
		int ctr = 0;
		char currentChar = sArr[0];
		for (int i = 0; i < sArr.length; i++) {

			if (firstTimeFlag == true) {
				o += sArr[i];
				firstTimeFlag = false;
				currentChar = sArr[i];
				ctr++;
			} else {
				if (sArr[i] == currentChar) {
					ctr++;
				} else {
					o += ctr;
					ctr = 0;
					firstTimeFlag = true;
					i--;
				}
			}
		}
		return o+ctr;
	}

	public static void main(String[] args) {
		System.out.println(compress("aabcccccaaa"));
	}
}