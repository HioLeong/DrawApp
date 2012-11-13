package comp2013.hleong.drawapp;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainWindow extends VBox {

	public static final double DEFAULT_WIDTH = 500;
	public static final double DEFAULT_HEIGHT = 300;

	private ImagePanel imagePanel;
	private Label label;
	private HBox buttonBox;
	private Button nextStep;

	public MainWindow() {
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	public MainWindow(double width, double height) {
		imagePanel = new ImagePanel(width, height);

		label = new Label();
		label.setPrefSize(width, height / 2);

		buttonBox = new HBox();
		
		buttonBox.getChildren().add(
				ButtonBuilder.create().text("Close")
						.onAction(new EventHandler<ActionEvent>() {

							@Override
							public void handle(ActionEvent arg0) {
								Platform.exit();
							}

						}).build());
		
		nextStep = new Button();
		nextStep.setText("Next Step");
		
		buttonBox.getChildren().add(nextStep);
		buttonBox.setPadding(new Insets(10, 10, 10, 10));
		buildGUI();
	}

	/**
	 * Method to build the widgets onto the stage.
	 */
	private void buildGUI() {

		imagePanel.setStyle("-fx-border-color: grey;");
		getChildren().add(imagePanel);

		label.setStyle("-fx-padding: 10px");
		label.setAlignment(Pos.TOP_LEFT);
		getChildren().add(label);

		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setStyle("-fx-border-color: grey");
		getChildren().add(buttonBox);

	}

	public ImagePanel getImagePanel() {
		return imagePanel;
	}

	public Label getLabel() {
		return label;
	}
	
	public Button getNextStepButton() {
		return nextStep;
	}

}
