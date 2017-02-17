package io.github.talaatharb.fxplotter.plotter2d;

import io.github.talaatharb.function.ParameterizedFunction;
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

	private Series<Number, Number> data;

	@FXML
	private TextField functionText;

	@FXML
	private LineChart<Number, Number> lineChart;

	private final Plotter2DModel model = Plotter2DModel.getModel();

	@FXML
	private TextField resolutionText;

	@FXML
	private CheckBox symbolsCheckBox;
	@FXML
	private NumberAxis xAxis;

	@FXML
	private void functionChanged() {
		model.setFunction(functionText.getText());
		model.getFunction().setParameter(ParameterizedFunction.PARAMETER1_NAME, aSlider.getValue());
		model.setResolution(Integer.parseInt(resolutionText.getText()));
		replot();
	}

	@FXML
	private void initialize() {
		aSlider.valueProperty().addListener((value, oldValue, newValue) -> parametersChanged());
		data = new Series<Number, Number>();
		data.getData().add(new XYChart.Data<Number, Number>(0, 0));
		lineChart.getData().add(data);
		parametersChanged();
	}

	private void parametersChanged() {
		double a = aSlider.getValue();
		String parameterName = ParameterizedFunction.PARAMETER1_NAME;
		aLabel.setText(parameterName + " = " + String.format("%1.2f", a));
		model.getFunction().setParameter(parameterName, a);
		replot();
	}

	private void replot() {
		model.generateData(data);
	}

	@FXML
	private void resolutionChanged() {
		model.setResolution(Integer.parseInt(resolutionText.getText()));
		replot();
	}

	@FXML
	private void symbolsChanged() {
		lineChart.setCreateSymbols(symbolsCheckBox.isSelected());
	}

}
