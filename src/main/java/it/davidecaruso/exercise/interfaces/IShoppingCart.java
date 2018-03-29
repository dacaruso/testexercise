package it.davidecaruso.exercise.interfaces;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import it.davidecaruso.exercise.interfaces.ICartItem;
import it.davidecaruso.exercise.interfaces.IGood;

public interface IShoppingCart {
	
	public void addItem(IGood good,BigDecimal quantity);

	public void addItem(IGood good);
	
	public void printReceipt();
	
	public void checkout();
	
	public BigDecimal getTotalPrice();

	public BigDecimal getTotalTaxes();
	
	public BigDecimal getTotalPriceWithTaxes();
	
	public void setCartName(String s);
	
	public String getCartName();
	
	public void initCart(String cartName);
}
