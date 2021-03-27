package io.github.talaatharb.function;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractParameterizedExpression implements ParamterizedExpression {

	protected String expression = VARIABLE1_NAME;
	protected final Map<String, Double> parameters = new HashMap<>();

	@Override
	public String getExpression() {
		return this.expression;
	}

	@Override
	public void setParameter(String parameterName, double value) {
		this.parameters.put(parameterName, value);
	}

	@Override
	public void setParameters(Map<String, Double> parameters) {
		this.parameters.putAll(parameters);
	}

}
