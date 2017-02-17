package io.github.talaatharb.function;

import java.util.HashMap;

public interface ParamterizedExpression {
	/**
	 * Gets the mathematical expression of the function
	 * 
	 * @return the expression of the function
	 */
	public abstract String getExpression();

	/**
	 * Sets the value of the parameter defined for the function
	 * 
	 * @param parameterName
	 *            the name of the parameter to set
	 * @param value
	 *            the value of the parameter to set
	 */
	public abstract void setParameter(String parameterName, double value);

	/**
	 * Sets the value of a list of parameters
	 * 
	 * @param parameters
	 *            the list of parameters to set
	 */
	public abstract void setParameters(HashMap<String, Double> parameters);
}