package it.davidecaruso.exercise.impl;

import java.math.BigDecimal;

import it.davidecaruso.exercise.interfaces.IGood;

public abstract class AbstractGood implements IGood {
	
	private String name;
	private BigDecimal price;
	private boolean exempt;

	public AbstractGood(String name, BigDecimal price, boolean exempt) {
		super();
		this.name = name;
		this.price = price;
		this.exempt = exempt;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public boolean isExempt() {
		return exempt;
	}
	public void setExempt(boolean exempt) {
		this.exempt = exempt;
	}

}
