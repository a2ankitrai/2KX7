class SwapNumbers {
	
	public static void main(String[] args) {
		int a = 75;
		int b = 89;

		System.out.println("Before Swap");
		System.out.println("a : "+ a);
		System.out.println("b : "+ b);

		a = a^b;
		b = a^b;
		a = a^b;

		System.out.println("After Swap");
		System.out.println("a : "+ a);
		System.out.println("b : "+ b);

		System.out.println("--------------");

		System.out.println(Integer.toBinaryString(-4 >> 1)); 
	}
}