package behavioral.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	List<Item> items;
	
	public ShoppingCart(){
		this.items=new ArrayList<Item>();
	}
	
	public void addItem(Item item){
		this.items.add(item);
	}
	
	public void removeItem(Item item){
		this.items.remove(item);
	}
	
	public BigDecimal calculateTotal(){
		BigDecimal sum = new BigDecimal(0);
		for(Item item : items){
			sum = sum.add(item.getPrice());
		}
		sum = sum.setScale(2, RoundingMode.FLOOR);
		return sum;
	}
	
	public void pay(PaymentStrategy paymentMethod){
		BigDecimal amount = calculateTotal();
		paymentMethod.pay(amount);
	}
}
