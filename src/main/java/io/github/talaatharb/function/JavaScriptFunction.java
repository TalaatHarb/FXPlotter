package io.github.talaatharb.function;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptFunction extends AbstractFunction implements ScriptedFunction {
	
	private static final ScriptEngineManager ENGINE_MANAGER = new ScriptEngineManager();

	private static final ScriptEngine JS_ENGINE = ENGINE_MANAGER.getEngineByName("js");


	@Override
	public double applyAsDouble(Double x) {
		double result = 0.0;
		try {
			scriptEval(VARIABLE1_NAME + " = " + x + ";");
			for (String key : parameters.keySet()) {
				scriptEval(key + " = " + parameters.get(key) + ";");
			}

			String resultString = scriptEval(expression);
			result = Double.parseDouble(resultString);
		} catch (ScriptException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	private final String scriptEval(String expr) throws ScriptException {
		return JS_ENGINE.eval("with(Math){" + expr +";}").toString();
	}

	@Override
	public void setExpression(String expression) {
		this.expression = expression;
	}

}
