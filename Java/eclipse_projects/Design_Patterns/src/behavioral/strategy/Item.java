package behavioral.strategy;

import java.math.BigDecimal;

public class Item {

	private String itemCode;
	private BigDecimal price;
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Item(String itemCode, BigDecimal price) {
		super();
		this.itemCode = itemCode;
		this.price = price;
	}
	
}
