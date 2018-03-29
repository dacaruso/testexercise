package it.davidecaruso.exercise.interfaces;

import java.math.BigDecimal;

public interface ISalesTax {
	public BigDecimal getAdditionalRate();
	
	public BigDecimal getRate();
	
	public void setAdditionalRate(BigDecimal r);
	
	public void setRate(BigDecimal r);
}

