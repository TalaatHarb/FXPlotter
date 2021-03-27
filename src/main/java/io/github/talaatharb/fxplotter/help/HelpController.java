package io.github.talaatharb.fxplotter.help;

import java.io.File;
import java.net.MalformedURLException;

import javafx.fxml.FXML;
import javafx.scene.web.WebView;

public class HelpController {

	private static final String HELP_FILE = "help/index.html";
	@FXML
	private WebView browser;

	@FXML
	private void initialize() {
		try {
			browser.getEngine().load(new File(HELP_FILE).toURI().toURL().toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
