package com.techelevator;

public class ChipItem extends Item {
	
//	public ChipItem(String itemName, BigDecimal itemPrice) {
//		super(itemName, itemPrice);
//	}

	@Override
	public String getItemSound() {
		
		String chipSound = new String();
		
		chipSound = "\nCrunch Crunch, Yum!";
		
		return chipSound;
	}
	
	

}
