package comp2013.hleong.drawapp;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParametersBuilder;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

import javax.imageio.ImageIO;

public class DrawApp extends Application {

	public final static String TEST_PARSE  = "SC blue\nFG 10 10 150 150 150 100";
	private final static boolean TEST = true;

	private void init(Stage primaryStage) {
		Group root = new Group();
		Scene scene = new Scene(root);
		primaryStage.setResizable(true);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Draw App");

		final MainWindow mainWindow = new MainWindow();
		root.getChildren().add(mainWindow);

		Reader reader;

		if (TEST) {
			reader = new StringReader(TEST_PARSE);
		} else {
			reader = new InputStreamReader(System.in);
		}

		final JavaFxParser parser = new JavaFxParser(reader, mainWindow,
				primaryStage);

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

		mainWindow.getSnapshotButton().setOnAction(
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {

						int width = (int) mainWindow.getImagePanel().getWidth();
						int height = (int) mainWindow.getImagePanel()
								.getHeight();

						WritableImage writableImage = new WritableImage(width,
								height);
						Image image = mainWindow.getImagePanel().snapshot(
								SnapshotParametersBuilder.create().build(),
								writableImage);
						try {
							
							ImageIO.write(
									SwingFXUtils.fromFXImage(image, null),
									"png", new File("screenshot.png"));
						} catch (IOException e) {
							e.printStackTrace();
						}
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
