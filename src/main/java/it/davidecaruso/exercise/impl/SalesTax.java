package it.davidecaruso.exercise.impl;

import java.math.BigDecimal;

public class SalesTax {


	private static final BigDecimal rate =new BigDecimal(10);

	private static final BigDecimal additionalRate =new BigDecimal(5);
	
	public static BigDecimal getAdditionalRate() {
		return additionalRate;
	}
	
	public static BigDecimal getRate() {
		return rate;
	}
	
}
