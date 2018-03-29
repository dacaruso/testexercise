package it.davidecaruso;

import java.math.BigDecimal;

import it.davidecaruso.exercise.impl.Good;
import it.davidecaruso.exercise.impl.ImportedGood;
import it.davidecaruso.exercise.impl.SalesTax;
import it.davidecaruso.exercise.impl.ShoppingCart;
import it.davidecaruso.exercise.interfaces.IGood;
import it.davidecaruso.exercise.interfaces.ISalesTax;
import it.davidecaruso.exercise.interfaces.IShoppingCart;


public class App {

	
	
	public static void main(String[] args) {
	
		ISalesTax salesTax = new SalesTax();

		IGood book = new Good("book", new BigDecimal(12.49), true);
		IGood musicCD = new Good("Music CD", new BigDecimal(14.99), false);
		IGood chocolateBar = new Good("chocolate bar", new BigDecimal(0.85), true);

		IShoppingCart cart = new ShoppingCart();
		cart.initCart("Output 1");
		cart.addItem(book,salesTax);
		cart.addItem(musicCD,salesTax);
		cart.addItem(chocolateBar,salesTax);

		cart.printReceipt();
		

		IGood boxOfChocolates = new ImportedGood("box Of Chocolates", new BigDecimal(10.00), true);
		IGood bottleOfPerfume = new ImportedGood("bottle Of Perfume", new BigDecimal(47.50), false);

		cart = new ShoppingCart();
		cart.initCart("Output 2");
		cart.addItem(boxOfChocolates,salesTax);
		cart.addItem(bottleOfPerfume,salesTax);

		cart.printReceipt();
		

		IGood importedPerfume = new ImportedGood("imported bottle of perfume", new BigDecimal(27.99), false);
		IGood perfume = new Good("bottle of perfume", new BigDecimal(18.99), false);
		IGood headeachePills = new Good("packet of headache pills", new BigDecimal(9.75), true);
		IGood boxOfImportedChocolates = new ImportedGood("box Of imported Chocolates", new BigDecimal(11.25), true);

		cart = new ShoppingCart();
		cart.initCart("Output 3");
		cart.addItem(importedPerfume,salesTax);
		cart.addItem(perfume,salesTax);
		cart.addItem(headeachePills,salesTax);
		cart.addItem(boxOfImportedChocolates,salesTax);
		
		cart.printReceipt();

	}


}
