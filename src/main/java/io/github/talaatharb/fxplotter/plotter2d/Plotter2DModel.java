package io.github.talaatharb.fxplotter.plotter2d;

import io.github.talaatharb.function.GroovyFunction;
import io.github.talaatharb.function.ParameterizedFunction;
import io.github.talaatharb.function.ScriptedFunction;
import io.github.talaatharb.function.SincFunction;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

public class Plotter2DModel {

	public static final ParameterizedFunction DEFAULT_FUNCTION = new SincFunction();
	public static final double DEFAULT_MAX_X = Math.PI;
	public static final double DEFAULT_MIN_X = -Math.PI;
	public static final int DEFAULT_RESOLUTION = 128;

	private static final Plotter2DModel MODEL = new Plotter2DModel();

	public synchronized static final Plotter2DModel getModel() {
		return MODEL;
	}

	private ParameterizedFunction function;

	private double maxX;
	private double minX;
	private int resolution;

	private Plotter2DModel() {
		setResolution(DEFAULT_RESOLUTION);
		this.function = DEFAULT_FUNCTION;
		minX = DEFAULT_MIN_X;
		maxX = DEFAULT_MAX_X;
	}

	public void generateData(Series<Number, Number> data) {
		double dx = 1;
		int res = resolution - 1;
		if (res > 0) {
			dx = (maxX - minX) / res;
		} else {
			dx = (maxX - minX) / (DEFAULT_RESOLUTION - 1);
		}

		data.getData().clear();
		double x = minX;
		double y = 0;
		for (int i = 0; i <= res; i++) {
			y = function.applyAsDouble(x);
			data.getData().add(new XYChart.Data<>(x, y));
			x += dx;
		}
	}

	public ParameterizedFunction getFunction() {
		return function;
	}

	public int getResolution() {
		return resolution;
	}

	public void setFunction(String expression) {
		if (!(function instanceof ScriptedFunction)) {
			function = new GroovyFunction();
		}
		((ScriptedFunction) function).setExpression(expression);
	}

	public void setResolution(int resolution) {
		this.resolution = resolution;
	}
}
