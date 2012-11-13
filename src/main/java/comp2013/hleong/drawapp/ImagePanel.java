package comp2013.hleong.drawapp;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ImagePanel extends Pane {

	private static final Color DEFAULT_COLOR = Color.BLACK;

	private Color currentColor;
	private Group root = new Group();

	public ImagePanel(double height, double width) {
		currentColor = DEFAULT_COLOR;
		this.setPrefSize(height, width);
		this.setHeight(height);
		this.setWidth(width);
		this.getChildren().add(root);
	}

	public void drawLine(double x1, double y1, double x2, double y2) {
		Line line = new Line(x1, y1, x2, y2);
		line.setStroke(currentColor);
		root.getChildren().add(line);
	}

	public void drawRect(double x1, double y1, double x2, double y2) {
		Rectangle rect = new Rectangle(x1, y1, x2, y2);
		rect.setFill(null);
		rect.setStroke(currentColor);
		root.getChildren().add(rect);
	}
	
	public void fillRect(double x1, double y1, double x2, double y2) {
		Rectangle rect = new Rectangle(x1, y1, x2, y2);
		rect.setFill(currentColor);
		root.getChildren().add(rect);
	}

	public void drawArc(double centerX, double centerY, double radiusX,
			double radiusY, double startAngle, double length) {
		Arc arc = new Arc(centerX, centerY, radiusX, radiusY, startAngle,
				length);
		arc.setFill(null);
		arc.setStroke(currentColor);
		root.getChildren().add(arc);
	}

	public void drawOval(double centerX, double centerY, double radiusX,
			double radiusY) {
		Ellipse oval = new Ellipse(centerX, centerY, radiusX, radiusY);
		oval.setFill(null);
		oval.setStroke(currentColor);
		root.getChildren().add(oval);
	}

	public void drawString(double centerX, double centerY, String s) {
		Text text = new Text(centerX, centerY, s);
		text.setFill(currentColor);
		text.setStroke(currentColor);
		root.getChildren().add(text);
	}

	public void setColor(Color color) {
		currentColor = color;
	}

}
