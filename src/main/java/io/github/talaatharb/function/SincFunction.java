package io.github.talaatharb.function;

public class SincFunction extends AbstractFunction {
	
	public SincFunction() {
		this.expression = "sin(a * x) / (a * x)";
	}

	@Override
	public double applyAsDouble(Double x) {
		double a = parameters.get(PARAMETER1_NAME);
		return Math.sin(a * x) / (a * x);
	}

}
