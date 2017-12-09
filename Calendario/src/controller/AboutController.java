package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class AboutController {

	@FXML
	private Label lbsad;

	@FXML
	private Pane anchorPaneAbout;
	@FXML
	private Label lbline2;
	
	@FXML
	private Hyperlink hiperlk;
	

	public void initialize(URL location, ResourceBundle resources) {
	}

	public void handlerMenuItemAbout() throws IOException {
		AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("controller.AboutController"));
		anchorPaneAbout.getChildren().setAll(a);
	}
}
