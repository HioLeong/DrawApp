package comp2013.hleong.drawapp;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class ImagePanel extends Pane {
	
	private Group root = new Group();
	
	public ImagePanel(double height, double width) {
		this.setHeight(height);
		this.setWidth(width);
		this.getChildren().add(root);
	}
	
	public void drawLine(double x1, double y1, double x2, double y2) {
		Line line = new Line(x1,y1,x2,y2);
		line.setFill(Color.BLACK);
		root.getChildren().add(line);
	}

}
