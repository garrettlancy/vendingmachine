package com.techelevator;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };
	private static final String FEED_MONEY_OPTION_ONE_DOLLARS = "1";
	private static final String FEED_MONEY_OPTION_TWO_DOLLARS = "2";
	private static final String FEED_MONEY_OPTION_FIVE_DOLLARS = "5";
	private static final String FEED_MONEY_OPTION_TEN_DOLLARS = "10";
	private static final String[] FEED_MONEY_OPTIONS = { FEED_MONEY_OPTION_ONE_DOLLARS, FEED_MONEY_OPTION_TWO_DOLLARS, FEED_MONEY_OPTION_FIVE_DOLLARS, FEED_MONEY_OPTION_TEN_DOLLARS };
	private static final String SELECT_PRODUCT_OPTION_A1 = "A1";
	private static final String SELECT_PRODUCT_OPTION_A2 = "A2";
	private static final String SELECT_PRODUCT_OPTION_A3 = "A3";
	private static final String SELECT_PRODUCT_OPTION_A4 = "A4";
	private static final String SELECT_PRODUCT_OPTION_B1 = "B1";
	private static final String SELECT_PRODUCT_OPTION_B2 = "B2";
	private static final String SELECT_PRODUCT_OPTION_B3 = "B3";
	private static final String SELECT_PRODUCT_OPTION_B4 = "B4";
	private static final String SELECT_PRODUCT_OPTION_C1 = "C1";
	private static final String SELECT_PRODUCT_OPTION_C2 = "C2";
	private static final String SELECT_PRODUCT_OPTION_C3 = "C3";
	private static final String SELECT_PRODUCT_OPTION_C4 = "C4";
	private static final String SELECT_PRODUCT_OPTION_D1 = "D1";
	private static final String SELECT_PRODUCT_OPTION_D2 = "D2";
	private static final String SELECT_PRODUCT_OPTION_D3 = "D3";
	private static final String SELECT_PRODUCT_OPTION_D4 = "D4";
	private static final String[] SELECT_PRODUCT_OPTION = { SELECT_PRODUCT_OPTION_A1, SELECT_PRODUCT_OPTION_A2, SELECT_PRODUCT_OPTION_A3, SELECT_PRODUCT_OPTION_A4,
			SELECT_PRODUCT_OPTION_B1, SELECT_PRODUCT_OPTION_B2,SELECT_PRODUCT_OPTION_B3, SELECT_PRODUCT_OPTION_B4, SELECT_PRODUCT_OPTION_C1, SELECT_PRODUCT_OPTION_C2, 
			SELECT_PRODUCT_OPTION_C3, SELECT_PRODUCT_OPTION_C4, SELECT_PRODUCT_OPTION_D1, SELECT_PRODUCT_OPTION_D2,SELECT_PRODUCT_OPTION_D3, SELECT_PRODUCT_OPTION_D4 };
	
	private VendoMatic500 vm;
	private Menu menu;
	
	public VendingMachineCLI(Menu menu, VendoMatic500 vm) {
		this.menu = menu;
		this.vm = vm;
	}
	
	public void run() {
		while(true) {
			String choice = (String)menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			
			if(choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				System.out.println(vm.getInventory());
				
			} else if(choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while(true) {
					System.out.println("\nCurrent Balance: $" + vm.getBalance());
				String purchaseChoice = (String)menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				if(purchaseChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
					String feedMoneyChoice = (String)menu.getChoiceFromOptions(FEED_MONEY_OPTIONS);
					vm.balance(feedMoneyChoice);
					
				} else if(purchaseChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
					String productChoice = (String)menu.getChoiceFromOptions(SELECT_PRODUCT_OPTION);
					vm.purchaseProduct(productChoice);
					
				} else if(purchaseChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
					System.out.println(vm.getChange());
					break;
				}
			}
		}
	}
	}
	public static void main(String[] args) throws Exception {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu, new VendoMatic500());
		cli.run();
	}
}
