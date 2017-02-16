package io.github.talaatharb.fxplotter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXPlotter extends Application {
	private static final String CSS_FILE = "/io/github/talaatharb/fxplotter/theme.css";
	private static final int HEIGHT = 600;
	private static final String MAIN_FXML = "/io/github/talaatharb/fxplotter/FXPlotterView.fxml";
	private static final int WIDTH = 800;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource(MAIN_FXML));
			Scene scene = new Scene(root, WIDTH, HEIGHT);
			scene.getStylesheets().add(getClass().getResource(CSS_FILE).toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
