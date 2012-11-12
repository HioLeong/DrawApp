package comp2013.hleong.drawapp;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DrawApp extends Application {

	private void init(Stage primaryStage) {
		Group root = new Group();
		primaryStage.setResizable(true);
		primaryStage.setScene(new Scene(root, 500, 500));

		ImagePanel imagePanel = new ImagePanel(500, 300);
		imagePanel.drawLine(0, 0, 150, 150);
		root.getChildren().add(imagePanel);

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
