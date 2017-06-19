package com.techelevator;

public class CandyItem extends Item {
	
//	public CandyItem(String itemName, BigDecimal itemPrice) {
//		super(itemName, itemPrice);
//	}

	@Override
	public String getItemSound() {
		
		String candySound = new String();
		
		candySound = "\nMunch Munch, Yum!";
		
		return candySound;
	}
	
	

}

