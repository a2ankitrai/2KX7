package structural.adapter;

public class PayGateUPI implements PaymentGatewaySpec {

	private String name;
	private String cardDetails;
	private String validityMonthAndYear;
	
	public PayGateUPI(String name, String cardDetails,
			String validityMonthAndYear) {
		super();
		this.name = name;
		this.cardDetails = cardDetails;
		this.validityMonthAndYear = validityMonthAndYear;
	}
	
	@Override
	public String getName() { 
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getCardDetails() {
		// TODO Auto-generated method stub
		return cardDetails;
	}

	@Override
	public void setCardDetails(String cardDetails) {
		this.cardDetails = cardDetails;
	}

	@Override
	public String getValidityMonthAndYear() {
		// TODO Auto-generated method stub
		return validityMonthAndYear;
	}

	@Override
	public void setValidityMonthAndYear(String validityMonthAndYear) {
		this.validityMonthAndYear = validityMonthAndYear;
	}
 
	public String toString() {
		return "Name: " + this.getName() + "\n" + "Card: "
				+ this.getCardDetails() + "\n" + "Month and Year Validity: "
				+ this.getValidityMonthAndYear();
	}
}
