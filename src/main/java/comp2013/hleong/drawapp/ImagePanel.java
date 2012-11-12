package comp2013.hleong.drawapp;

import com.sun.javafx.sg.PGShape.StrokeType;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class ImagePanel extends Pane {
	
	private Group root = new Group();
	
	public ImagePanel(double height, double width) {
		this.setPrefSize(height, width);
		this.setHeight(height);
		this.setWidth(width);
		this.getChildren().add(root);
	}
	
	public void drawLine(double x1, double y1, double x2, double y2) {
		Line line = new Line(x1,y1,x2,y2);
		root.getChildren().add(line);
	}
	
	public void drawRect(double x1, double y1, double x2, double y2) {
		Rectangle rect = new Rectangle(x1,y1,x2,y2);
		rect.setFill(null);
		rect.setStroke(Color.BLACK);
		root.getChildren().add(rect);
	}
	
	public void drawArc() {
		
	}

}
