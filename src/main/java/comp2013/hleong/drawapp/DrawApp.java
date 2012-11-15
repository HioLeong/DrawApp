package comp2013.hleong.drawapp;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DrawApp extends Application {

	public final static String TEST_PARSE = "SG blue black yellow grey\nFR 0 0 150 150";
	private final static boolean TEST = true;

	private void init(Stage primaryStage) {
		Group root = new Group();
		primaryStage.setResizable(true);
		primaryStage.setScene(new Scene(root));

		MainWindow mainWindow = new MainWindow();
		root.getChildren().add(mainWindow);
		
		Reader reader;
		
		if (TEST) {
			reader = new StringReader(TEST_PARSE);
		} else {
			reader = new InputStreamReader(System.in);
		}
		
		final JavaFxParser parser = new JavaFxParser(reader,
				mainWindow.getLabel(), mainWindow.getImagePanel());

		mainWindow.getNextStepButton().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						parser.singleStepParse();
					}

				});

		mainWindow.getCompleteButton().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						parser.parse();
					}

				});

	}

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		init(primaryStage);
		primaryStage.show();
	}

}
