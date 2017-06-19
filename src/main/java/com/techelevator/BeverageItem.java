package com.techelevator;

public class BeverageItem extends Item {
	
//	public BeverageItem(String itemName, BigDecimal itemPrice) {
//		super(itemName, itemPrice);
//	}
	
	@Override
	public String getItemSound() {
		
		String beverageSound = new String();
		
		beverageSound = "\nGlug Glug, Yum!";
		
		return beverageSound;
	}
	
	

}

