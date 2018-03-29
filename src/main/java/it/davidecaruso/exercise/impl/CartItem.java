package it.davidecaruso.exercise.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import it.davidecaruso.exercise.interfaces.ICartItem;
import it.davidecaruso.exercise.interfaces.IGood;
import it.davidecaruso.exercise.interfaces.ISalesTax;
import it.davidecaruso.exercise.utils.BigIntegerUtils;

public class CartItem implements ICartItem{
	private IGood good;
	private BigDecimal quantity;
	private ISalesTax salesTax;
	
	public CartItem() {
		
	}
	
	public CartItem(IGood good,BigDecimal quantity,ISalesTax salesTax) {
		this.good = good;
		this.quantity = quantity;
		this.salesTax = salesTax;
	}

	public IGood getGood() {
		return good;
	}

	public void setGood(IGood good) {
		this.good = good;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTax() {
		BigDecimal salesTaxes = BigDecimal.ZERO;
		if (!good.isExempt()) {
			BigDecimal tax = BigIntegerUtils.roundTax(good.getPrice().multiply(salesTax.getRate()).divide(new BigDecimal(100)));
			salesTaxes = salesTaxes.add(tax);
		}
		if (good.isImported()) {
			BigDecimal tax = BigIntegerUtils.roundTax(
					good.getPrice().multiply(salesTax.getAdditionalRate()).divide(new BigDecimal(100)));
			salesTaxes = salesTaxes.add(tax);
		}
		return salesTaxes;
	}

	

	
	public BigDecimal getPriceWithTaxes() {
		
		return good.getPrice().add(this.getTax());

	}
	
	
}
