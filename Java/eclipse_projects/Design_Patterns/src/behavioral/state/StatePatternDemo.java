package behavioral.state;

public class StatePatternDemo {

	public static void main(String[] args) {

		CeilingFanPullChain chain = new CeilingFanPullChain();
		
		int count  = 10;
		
		while(count > 0 ){
			System.out.print("Press ");
			chain.pull();
			count--;
		}
	}
}
