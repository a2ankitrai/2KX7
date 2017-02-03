package behavioral.strategy;

import java.math.BigDecimal;

public class ShoppingCartTest {

	public static void main(String[] args) {

		ShoppingCart sc = new ShoppingCart();

		sc.addItem(new Item("p234", new BigDecimal(2.02)));

		sc.addItem(new Item("p234", new BigDecimal(2.06)));

		PaymentStrategy ps1 = new NetBankingStrategy();

		sc.pay(ps1);

		PaymentStrategy ps2 = new PayTMStrategy();

		sc.pay(ps2);
	}
}
