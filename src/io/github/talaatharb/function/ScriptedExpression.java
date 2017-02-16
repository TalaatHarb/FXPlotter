package io.github.talaatharb.function;

public interface ScriptedExpression {

	public final static String RESULT_VARIABLE = "result";
	public final static String VARIABLE1_NAME = "x";
	public final static String VARIABLE2_NAME = "y";

	/**
	 * Sets the expression to be used by the scripting language
	 * 
	 * @param expression
	 *            the expression to be evaluated
	 */
	public abstract void setExpression(String expression);
}
