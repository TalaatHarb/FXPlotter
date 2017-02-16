package io.github.talaatharb.utils.gui;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class GUIUtils {
	
	public static final void setAnchorOffset(Node node, double offset) {
		AnchorPane.setBottomAnchor(node, offset);
		AnchorPane.setLeftAnchor(node, offset);
		AnchorPane.setRightAnchor(node, offset);
		AnchorPane.setTopAnchor(node, offset);
	}

	public static final void setAnchorZeroOffset(Node node) {
		setAnchorOffset(node, 0.0);
	}

	private GUIUtils(){
	}
}
