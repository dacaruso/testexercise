package it.davidecaruso.exercise.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


import it.davidecaruso.exercise.interfaces.ICartItem;
import it.davidecaruso.exercise.interfaces.IGood;
import it.davidecaruso.exercise.interfaces.IShoppingCart;
import it.davidecaruso.exercise.utils.BigIntegerUtils;

public class ShoppingCart implements IShoppingCart{

	List<ICartItem> cartItems;
	
	ICartItem cartItem;
	
	String cartName;
	private BigDecimal totalPrice;
	private BigDecimal totalTaxes; 

	
	public ShoppingCart() {

	}
	
	public ShoppingCart(String cartName) {
		initCart(cartName);
	}
	
	public ICartItem getCartItem() {
		return cartItem;
	}

	public void setCartItem(ICartItem cartItem) {
		this.cartItem = cartItem;
	}

	
	public String getCartName() {
		return cartName;
	}

	public void setCartName(String cartName) {
		this.cartName = cartName;
	}

	
	public void addItem(IGood good,BigDecimal quantity) {
		ICartItem cartItem = new CartItem(good, quantity);
		cartItems.add(cartItem);
	}

	public void addItem(IGood good) {
		addItem(good,new BigDecimal("1"));
	}


	
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public BigDecimal getTotalTaxes() {
		return BigIntegerUtils.roundTax(totalTaxes);
	}

	public BigDecimal getTotalPriceWithTaxes() {
		return this.totalPrice.add(this.totalTaxes);
	}

	
	
	public void checkout() {
		for (ICartItem cartItem : cartItems) {
			IGood good = cartItem.getGood(); 			
			totalPrice = totalPrice.add(good.getPrice().multiply(cartItem.getQuantity()));
			totalTaxes = totalTaxes.add(cartItem.getTax());
		}

	}
	
	public void printReceipt() {
		
		this.checkout();
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.ENGLISH);
		DecimalFormat df = (DecimalFormat)nf;
		df.applyPattern("#,##0.00");
		
		//DecimalFormat df = new DecimalFormat("#,##0.00");
		System.out.println(this.getCartName());
		for (ICartItem cartItem : cartItems) {
			IGood good = cartItem.getGood(); 
			System.out.println(cartItem.getQuantity() +  " " + good.getName() + ":" + df.format(cartItem.getPriceWithTaxes()));
		}

		System.out.println("Sales Taxes:" + df.format(totalTaxes));
		System.out.println("Total:" + df.format(getTotalPriceWithTaxes()));
		
	}
	
	public void initCart(String cartName) {
		this.cartName = cartName;
		initCart();
	}
	
	public void initCart() {
		totalPrice = BigDecimal.ZERO;
		cartItems = new ArrayList<ICartItem>();
		totalTaxes = BigDecimal.ZERO;
	}	

}
