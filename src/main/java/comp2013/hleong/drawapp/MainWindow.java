package comp2013.hleong.drawapp;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainWindow extends VBox {

	public static final double DEFAULT_WIDTH = 500;
	public static final double DEFAULT_HEIGHT = 300;

	private ImagePanel imagePanel;
	private Label label;
	private HBox buttonBox;
	private Button nextStep;
	private Button complete;
	private Button snapshot;

	public MainWindow() {
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	public MainWindow(double width, double height) {
		imagePanel = new ImagePanel(width, height);

		ScrollPane sp = new ScrollPane();
		sp.setPrefSize(width / 2, height / 2);
		label = new Label();
		sp.setContent(label);
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

		complete = new Button();
		complete.setText("Complete");
		
		snapshot = new Button();
		snapshot.setText("");
		buttonBox.getChildren().add(complete);
		buttonBox.getChildren().add(nextStep);
		buttonBox.setPadding(new Insets(10, 10, 10, 10));
		buildGUI();
	}

	/**
	 * Method to build the widgets onto the stage.
	 */
	private void buildGUI() {

		getChildren().add(imagePanel);

		label.setStyle("-fx-padding: 10px; -fx-border-color: grey; -fx-background-color: white;");
		label.setAlignment(Pos.TOP_LEFT);
		getChildren().add(label);

		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setStyle("-fx-background-color: white;");
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

	public Button getCompleteButton() {
		return complete;
	}

	public void setDimension(double width, double height) {
		imagePanel.setDimension(width, height);
		label.setPrefSize(width, height / 2);
	}

}
