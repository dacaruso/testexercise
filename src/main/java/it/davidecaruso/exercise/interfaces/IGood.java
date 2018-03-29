package it.davidecaruso.exercise.interfaces;

import java.math.BigDecimal;

public interface IGood {
	public void setName(String s);
	public String getName();
	public void setPrice(BigDecimal p);
	public BigDecimal getPrice();
	public boolean isImported();
	public boolean isExempt();
}
