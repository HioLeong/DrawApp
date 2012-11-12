package comp2013.hleong.drawapp;

import java.io.Reader;
import java.io.StringReader;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DrawApp extends Application {

	public final static String TEST_PARSE = "DO 150 150 1 1";

	private void init(Stage primaryStage) {
		Group root = new Group();
		primaryStage.setResizable(false);
		primaryStage.setScene(new Scene(root));

		MainWindow mainWindow = new MainWindow();
		root.getChildren().add(mainWindow);
		Reader reader = new StringReader(TEST_PARSE);
		JavaFxParser parser = new JavaFxParser(reader, mainWindow.getLabel(),
				mainWindow.getImagePanel());
		parser.parse();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch();
		/*
		 * Reader reader = new InputStreamReader(System.in); BufferedReader
		 * bReader = new BufferedReader(reader); try { String line =
		 * bReader.readLine(); System.out.println("Java");
		 * System.out.println(line); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		init(primaryStage);
		primaryStage.show();
	}

}
