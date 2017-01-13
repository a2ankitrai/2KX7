package structural.adapter;

public class TestPaymentGateway {

	public static void main(String[] args) {
		
		PaymentGatewaySpec px1 = new PayGateUPI("Ankit Rai","62565","12/34");
		
		PaymentGatewaySpec px2 = new PayWalletXAdapter("John Williams","6524344234","05/22");
		
		PayWalletX pwx = new PayWalletX();
		pwx.setCardNo("243253453");
		pwx.setFirstName("Gayle");
		pwx.setLastName("Marley");
		pwx.setValidMonth("11");
		pwx.setValidYear("25");
		PaymentGatewaySpec px3 = new PayWalletXAdapter(pwx);
	
		System.out.println("PaymentGatwayUPI ");
		System.out.println(px1);
		System.out.println();
		
		System.out.println("PayWalletXAdapter parameterized");
		System.out.println(px2);
		System.out.println();
		
		System.out.println("PaymentGatwayUPI PayWalletX");
		System.out.println(px3);
		System.out.println();
	}
}
