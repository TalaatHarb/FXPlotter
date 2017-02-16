package io.github.talaatharb.fxplotter.plotter2d;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class Plotter2DController {

	@FXML
	private Label aLabel;

	@FXML
	private Slider aSlider;

	@FXML
	private TextField functionText;

	@FXML
	private LineChart<Number, Number> lineChart;

	@FXML
	private TextField resolutionText;

	@FXML
	private CheckBox symbolsCheckBox;

	private NumberAxis xAxis;

	private NumberAxis yAxis;

	@FXML
	private void functionChanged() {

		replot();
	}

	@FXML
	private void initialize() {
		aSlider.valueProperty().addListener((value, oldValue, newValue) -> parametersChanged());

		Series<Number, Number> data = new Series<Number, Number>();
		data.getData().add(new XYChart.Data<Number, Number>(0, 0));
		xAxis = (NumberAxis) lineChart.getXAxis();
		yAxis = (NumberAxis) lineChart.getYAxis();

		lineChart.getData().add(data);
	}

	private void parametersChanged() {

		replot();
	}

	private void replot() {

	}

	@FXML
	private void resolutionChanged() {

		replot();
	}

	@FXML
	private void symbolsChanged() {
		lineChart.setCreateSymbols(symbolsCheckBox.isSelected());
	}

}
