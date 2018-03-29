package it.davidecaruso.exercise.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigIntegerUtils {

	public static BigDecimal roundTax(BigDecimal tax) {

		return round2(tax, new BigDecimal(0.05), RoundingMode.UP);
	}

	private static BigDecimal round2(BigDecimal value, BigDecimal increment, RoundingMode roundingMode) {
		if (increment.signum() == 0) {
			return value;
		} else {
			BigDecimal divided = value.divide(increment, 0, roundingMode);
			BigDecimal result = divided.multiply(increment);
			return result;
		}
	}
	
}
