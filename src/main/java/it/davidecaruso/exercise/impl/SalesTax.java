package it.davidecaruso.exercise.impl;

import java.math.BigDecimal;

import it.davidecaruso.exercise.interfaces.ISalesTax;

public class SalesTax implements ISalesTax {

	private BigDecimal rate;

	private BigDecimal additionalRate;

	public SalesTax() {
		this.rate =new BigDecimal(10);
		this.additionalRate =new BigDecimal(5);
	}

	public SalesTax(BigDecimal rate,BigDecimal additionalRate) {
		this.rate =rate;
		this.additionalRate =additionalRate;
	}

	public BigDecimal getAdditionalRate() {
		return this.additionalRate;
	}
	
	public BigDecimal getRate() {
		return this.rate;
	}
	
	public void setAdditionalRate(BigDecimal r) {
		this.additionalRate =r;
	}
	
	public void setRate(BigDecimal r) {
		this.rate = r;
	}
	
}
