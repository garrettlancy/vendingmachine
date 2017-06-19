package com.techelevator;

public class GumItem extends Item {
	
//	public GumItem(String itemName, BigDecimal itemPrice) {
//		super(itemName, itemPrice);
//	}
	
	@Override
	public String getItemSound() {
		
		String gumSound = new String();
		
		gumSound = "\nChew Chew, Yum!";
		
		return gumSound;
	}
	
	

}
