package io.github.talaatharb.function;

public class SincFunction extends AbstractFunction {
	
	public SincFunction() {
		this.expression = "sin(a * x) / x";
	}

	@Override
	public double applyAsDouble(Double x) {
		double a = parameters.get(PARAMETER1_NAME);
		return Math.sin(a * x) / x;
	}

}
