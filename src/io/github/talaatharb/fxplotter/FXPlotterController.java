package io.github.talaatharb.fxplotter;

import io.github.talaatharb.utils.gui.GUIUtils;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class FXPlotterController {

	@FXML
	private AnchorPane helpPane;

	@FXML
	private AnchorPane helpView;

	@FXML
	private AnchorPane plotter2DPane;

	@FXML
	private AnchorPane plotter2DView;

	@FXML
	private AnchorPane plotter3DPane;

	@FXML
	private AnchorPane plotter3DView;

	@FXML
	private void initialize() {
		helpPane.getChildren().add(helpView);
		GUIUtils.setAnchorZeroOffset(helpView);
		plotter2DPane.getChildren().add(plotter2DView);
		GUIUtils.setAnchorZeroOffset(plotter2DView);
		plotter3DPane.getChildren().add(plotter3DView);
		GUIUtils.setAnchorZeroOffset(plotter3DView);
	}
}
