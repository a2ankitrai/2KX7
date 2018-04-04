
class ExceptionTest{

	public static void main(String[] args){

		int a = 1;
		int b = 0;

		System.out.println("Before Exception");

		try {
			System.out.println(divide(a,b));

			String s = null;

			System.out.println(s.length());
		}
		catch(ArithmeticException ae){

			System.out.println("Error Message : "+ ae.getMessage());
			ae.printStackTrace();
		}
		
		
		System.out.println("After Exception");

	}

	public static double divide(int a, int b){
		return a/b;
	}
} 