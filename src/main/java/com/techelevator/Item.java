package com.techelevator;

import java.math.BigDecimal;

public abstract class Item {
	
	 String itemName;
	 BigDecimal itemPrice;
	
//	public Item(String itemName, BigDecimal itemPrice) {
//		this.itemName = itemName;
//		this.itemPrice = itemPrice;
//	}
	
	public String getItemSound() {
		return null;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public BigDecimal getItemPrice() {
		return itemPrice;
	}

}
