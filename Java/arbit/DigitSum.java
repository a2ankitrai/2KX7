
/** Calculate the Sum of the digit given. If negative return the positive sum
*/

class DigitSum {

	public static int digit_sum(long number){
		long divider = 10;
		int sum = 0;

		while(number != 0){
			long temp = number % divider;
			sum += temp/(divider/10);
			number -= temp;
			divider *= 10;
		}

		return Math.abs(sum);

	}

	public static int digit_sum2(long number){
		
		if(number < 0 ){
			number *= -1;
		}

		int sum = 0;

		while (number > 0){
			sum += number % 10;
			number /= 10;
		}

		return sum;
	}

	public static void main(String[] args) {
		
		System.out.println(digit_sum2(-3456));



	}
}