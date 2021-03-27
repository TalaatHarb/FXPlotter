package io.github.talaatharb.function;

public interface ScriptedExpression {

	/**
	 * Sets the expression to be used by the scripting language
	 * 
	 * @param expression
	 *            the expression to be evaluated
	 */
	public abstract void setExpression(String expression);
}
