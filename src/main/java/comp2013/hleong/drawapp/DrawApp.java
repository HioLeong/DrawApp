package comp2013.hleong.drawapp;

import java.io.Reader;
import java.io.StringReader;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DrawApp extends Application {

	public final static String TEST_PARSE = "SC blue\nDL 0 0 150 150\nDR 150 150 50 50\nDR 0 0 150 150";

	private void init(Stage primaryStage) {
		Group root = new Group();
		primaryStage.setResizable(false);
		primaryStage.setScene(new Scene(root));

		MainWindow mainWindow = new MainWindow();
		root.getChildren().add(mainWindow);
//		Reader reader = new InputStreamReader(System.in);
		Reader reader = new StringReader(TEST_PARSE);
		JavaFxParser parser = new JavaFxParser(reader, mainWindow.getLabel(),
				mainWindow.getImagePanel());
		parser.parse();

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
