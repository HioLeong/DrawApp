package comp2013.hleong.drawapp;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import com.sun.media.jfxmediaimpl.platform.Platform;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DrawApp extends Application {

	public final static String TEST_PARSE = "SD 300 500";
	private final static boolean TEST = true;

	private void init(Stage primaryStage) {
		Group root = new Group();
		primaryStage.setResizable(true);
		primaryStage.setScene(new Scene(root));
		primaryStage.setTitle("Draw App");

		MainWindow mainWindow = new MainWindow();
		root.getChildren().add(mainWindow);

		Reader reader;

		if (TEST) {
			reader = new StringReader(TEST_PARSE);
		} else {
			reader = new InputStreamReader(System.in);
		}

		final JavaFxParser parser = new JavaFxParser(reader,
				mainWindow, primaryStage);

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
