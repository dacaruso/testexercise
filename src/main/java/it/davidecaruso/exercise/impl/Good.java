package it.davidecaruso.exercise.impl;

import java.math.BigDecimal;

public class Good extends AbstractGood //implements IGood 
{

	public Good(String name, BigDecimal price, boolean exempt) {
		super(name,price,exempt);
	}
	
	public boolean isImported() {
		return false;
	}

}
