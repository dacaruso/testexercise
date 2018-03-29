package it.davidecaruso.exercise.interfaces;

import java.math.BigDecimal;
import java.math.RoundingMode;

import it.davidecaruso.exercise.interfaces.IGood;

public interface ICartItem {

	public IGood getGood();

	public void setGood(IGood good);

	public BigDecimal getQuantity();

	public void setQuantity(BigDecimal quantity);

	public BigDecimal getTax();

	public BigDecimal getPriceWithTaxes();
		
	
}
