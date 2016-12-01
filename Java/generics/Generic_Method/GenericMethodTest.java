class GenericMethodTest {
	public static void main(String[] args) {
		Pair<Integer, String> p1 = new Pair<>(1, "apple");
		Pair<Integer, String> p2 = new Pair<>(2, "pear");
		Pair<Integer, String> p3 = new Pair<>(1, "apple");

		boolean same1 = Util.<Integer, String>compare(p1, p2);

		boolean same2 = Util.<Integer, String>compare(p1, p3);

		System.out.println("Compare p1 & p2: " + same1);
		System.out.println("Compare p1 & p3: " + same2);

	}
}