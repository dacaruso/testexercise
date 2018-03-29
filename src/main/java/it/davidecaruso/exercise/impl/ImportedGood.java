package it.davidecaruso.exercise.impl;

import java.math.BigDecimal;

import it.davidecaruso.exercise.interfaces.IGood;

public class ImportedGood extends AbstractGood{
	
	public ImportedGood(String name, BigDecimal price, boolean exempt) {
		super(name,price,exempt);
	}
	
	public boolean isImported() {
		return true;
	}	
}
