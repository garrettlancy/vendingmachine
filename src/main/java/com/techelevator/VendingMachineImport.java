package com.techelevator;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineImport {

	public Map<String, List<Item>> getInventory() throws Exception {
		
		File inventoryFile = new File("vendingmachine.csv");
		Map<String, List<Item>> vendingMachineItems = new HashMap<>();
		try (Scanner reader = new Scanner(inventoryFile)) {
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				String[] parts = line.split("\\|");
				List<Item> items = new ArrayList<>();
				for (int i = 0; i < 5; i++) {
					Item item;
					if (parts[0].startsWith("A")) {
						item = new ChipItem();

					} else if (parts[0].startsWith("B")) {
						item = new CandyItem();

					} else if (parts[0].startsWith("C")) {
						item = new BeverageItem();

					} else {
						item = new GumItem();

					}
					item.setItemName(parts[1]);
					item.setItemPrice( new BigDecimal(parts[2]));
					items.add(item);
				}
				
				// Store each list of items into the map using the item code(parts[0] as the key.
				
				vendingMachineItems.put(parts[0], items);
			}
		}
		return vendingMachineItems;
	}
}
