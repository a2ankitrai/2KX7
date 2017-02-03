package behavioral.strategy;

import java.math.BigDecimal;

public class NetBankingStrategy implements PaymentStrategy {

	String bankName;
	String userId;
	char[] password;
	
	@Override
	public void pay(BigDecimal amount) {
		System.out.println("Paying Rs. "+ amount+" with NetBanking");
	}

}
