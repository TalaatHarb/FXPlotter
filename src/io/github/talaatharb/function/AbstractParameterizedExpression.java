package io.github.talaatharb.function;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractParameterizedExpression implements ParamterizedExpression {

	protected String expression = ScriptedExpression.VARIABLE1_NAME;
	protected final Map<String, Double> parameters = new HashMap<String, Double>();

	@Override
	public String getExpression() {
		return this.expression;
	}

	@Override
	public void setParameter(String parameterName, double value) {
		this.parameters.put(parameterName, value);
	}

	@Override
	public void setParameters(HashMap<String, Double> parameters) {
		this.parameters.putAll(parameters);
	}

}
