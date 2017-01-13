package structural.adapter;

public class PayWalletXAdapter implements PaymentGatewaySpec {

	private PayWalletX payWalletX;

	public PayWalletXAdapter(String name, String cardDetails,
			String validityMonthAndYear) {
		super();
		this.payWalletX = new PayWalletX();
		this.setName(name);
		this.setCardDetails(cardDetails);
		this.setValidityMonthAndYear(validityMonthAndYear);
	}

	public PayWalletXAdapter(PayWalletX payWalletX) {
		super();
		this.payWalletX = payWalletX;
	}

	@Override
	public String getName() {

		return payWalletX.getFirstName() +" "+ payWalletX.getLastName();
	}

	@Override
	public void setName(String name) {

		payWalletX.setFirstName(name.split(" ")[0]);
		payWalletX.setLastName(name.split(" ")[1]);
	}

	@Override
	public String getCardDetails() {

		return payWalletX.getCardNo();
	}

	@Override
	public void setCardDetails(String cardDetails) {

		payWalletX.setCardNo(cardDetails);
	}

	@Override
	public String getValidityMonthAndYear() {

		return payWalletX.getValidMonth() + "/" + payWalletX.getValidYear();
	}

	@Override
	public void setValidityMonthAndYear(String validityMonthAndYear) {

		payWalletX.setValidMonth(validityMonthAndYear.split("/")[0]);
		payWalletX.setValidYear(validityMonthAndYear.split("/")[1]);
	}

	public String toString() {
		return "Name: " + this.getName() + "\n" + "Card: "
				+ this.getCardDetails() + "\n" + "Month and Year Validity: "
				+ this.getValidityMonthAndYear();
	}
}
