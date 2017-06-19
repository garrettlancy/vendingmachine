package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class VendoMatic500 {
	
	BigDecimal balance = new BigDecimal(0);
	String change = "";
	Log logWriter = new Log();
	
	
	private Map<String, List<Item>> inventory;
	
	public VendoMatic500() throws Exception {
		
		VendingMachineImport importer = new VendingMachineImport();
		inventory = importer.getInventory();
	}
	
	public String getInventory() {
		String output = "";
		List<String> keyList = new ArrayList<>(inventory.keySet());
		Collections.sort(keyList);
		for(String key : keyList) {
			output += key;
			List<Item>inventoryList = inventory.get(key);
			if(inventoryList.isEmpty()) {
				output += "\nThis item slot is empty.";
				
			} else {
				output += " - " + String.format("%-25s", inventory.get(key).get(0).getItemName());
				output += " $" + inventory.get(key).get(1).getItemPrice();
				output += " - Quantity (" + inventory.get(key).size() + ")";
			}
		output += "\n";
		}
		
		return output;
		
	}
	
	public void  balance(String feedMoneyChoice) {
		
		BigDecimal dollarAmount = new BigDecimal(feedMoneyChoice);
		
		logWriter.logMessage("FEED MONEY: $" + dollarAmount + "\t $" + balance.add(dollarAmount));
		
		balance = balance.add(dollarAmount);
			
	}
	
	public BigDecimal getBalance() {
		
		return balance;
	}

	public String purchaseProduct(String productChoice) {
		
		if(inventory.get(productChoice).isEmpty()) {
			System.out.println("\nThis item slot is empty.");
			return null;
		}
		BigDecimal productPrice = inventory.get(productChoice).get(0).getItemPrice();
		Item product = inventory.get(productChoice).get(0);
		if (balance.subtract(productPrice).signum() >= 0) {
			inventory.get(productChoice).remove(0);
			logWriter.logMessage(product.getItemName() + productChoice + " $" + balance + "\t $" + balance.subtract(productPrice));
			balance = balance.subtract(productPrice);
			System.out.print(product.getItemSound());
		} else {
			System.out.println("\nInsufficient funds!");
		}

		return null;
	}
	
	public String getChange() {

		logWriter.logMessage("GIVE CHANGE: $" + balance + "\t $" + balance.subtract(balance));
		int nickelCount = 0;
		int dimeCount = 0;
		int quarterCount = 0;

		BigDecimal balanceBeforeChange = new BigDecimal(0);
		balanceBeforeChange = balance;
		BigDecimal nickel = new BigDecimal(".05");
		BigDecimal dime = new BigDecimal(".10");
		BigDecimal quarter = new BigDecimal(".25");

		while (balance.subtract(quarter).signum() >= 0) {
			balance = balance.subtract(quarter);
			quarterCount++;
		}
		while (balance.subtract(dime).signum() >= 0) {
			balance = balance.subtract(dime);
			dimeCount++;
		}
		while (balance.subtract(nickel).signum() >= 0) {
			balance = balance.subtract(nickel);
			nickelCount++;
			break;
		}	
		return "\nYour change is $" + balanceBeforeChange + ", returned as: " + quarterCount + " Quarters, " + dimeCount
				+ " Dimes, and " + nickelCount + " nickels";
	}
	
	
}
