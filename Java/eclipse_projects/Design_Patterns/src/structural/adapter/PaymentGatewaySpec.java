package structural.adapter;

public interface PaymentGatewaySpec {

	public String getName();
	
	public void setName(String name);
	
	public String getCardDetails();
	
	public void setCardDetails(String cardDetails);
	
	public String getValidityMonthAndYear();
	
	public void setValidityMonthAndYear(String validityMonthAndYear);
	
	
}
