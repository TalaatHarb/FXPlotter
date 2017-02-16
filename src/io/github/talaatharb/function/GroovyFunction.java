package io.github.talaatharb.function;

import groovy.lang.GroovyShell;
import groovy.lang.MissingPropertyException;
import groovy.lang.Script;

public class GroovyFunction extends AbstractFunction implements ScriptedFunction {

	private static final GroovyShell shell = new GroovyShell();
	private Script script;

	@Override
	public double applyAsDouble(Double x) {
		script.setProperty(VARIABLE1_NAME, x);

		for (String key : parameters.keySet()) {
			script.setProperty(key, parameters.get(key));
		}

		try {
			script.run();
		} catch (MissingPropertyException e) {
			e.printStackTrace();
			script.setProperty(RESULT_VARIABLE, 0.0);
		}

		return (double) script.getProperty(RESULT_VARIABLE);
	}

	@Override
	public void setExpression(String expression) {
		this.expression = expression;
		script = shell.parse("import static java.lang.Math.*;" + RESULT_VARIABLE + " = (" + expression + ");");
	}

}
