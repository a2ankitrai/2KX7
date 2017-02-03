package behavioral.strategy;

import java.math.BigDecimal;

public class PayTMStrategy implements PaymentStrategy {

	String userName;
	String userMobileNo;
	
	@Override
	public void pay(BigDecimal amount) {
		System.out.println("Paying Rs. "+amount+" by PayTM");
	}

}
