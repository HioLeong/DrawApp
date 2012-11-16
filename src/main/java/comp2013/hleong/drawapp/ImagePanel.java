package comp2013.hleong.drawapp;

import java.io.File;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ImagePanel extends Pane {

	private static final Color DEFAULT_COLOR = Color.BLACK;

	private Paint currentColor;
	private Group root = new Group();

	public ImagePanel(double height, double width) {
		currentColor = DEFAULT_COLOR;
		setPrefSize(height, width);
		setMaxSize(height, width);
		getChildren().add(root);
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
		rect.setStroke(currentColor);
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

	public void drawImage(double x, double y, double width, double height,
			String fileName) {

		File file = new File(fileName);

		ImageView image = new ImageView(file.toURI().toString());

		image.setX(x);
		image.setY(y);

		image.setFitWidth(width);
		image.setFitHeight(height);

		root.getChildren().add(image);

	}

	public void setColor(Color color) {
		currentColor = color;
	}

	public void setGradient(List<Color> colours) {

		Stop[] stops = new Stop[colours.size()];
		double proportion = (double) 1 / colours.size();
		System.out.println("Proportion: " + proportion);

		for (int i = 0; i < colours.size(); i++) {
			if (i != 0) {
				stops[i] = new Stop((i+1) * proportion, colours.get(i));
			} else {
				stops[i] = new Stop(i* proportion, colours.get(i));
			}
		}

		LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true,
				CycleMethod.REPEAT, stops);

		currentColor = gradient;
	}

	public void setDimension(double width, double height) {
		setPrefSize(width, height);
	}

	public void drawPolygon(double[] coordinates) {
		
		Polygon polygon = new Polygon(coordinates);
		polygon.setFill(null);
		polygon.setStroke(currentColor);
		root.getChildren().add(polygon);
		
	}

	public void fillPolygon(double[] coordinates) {
		Polygon polygon = new Polygon(coordinates);
		polygon.setFill(currentColor);
		polygon.setStroke(null);
		root.getChildren().add(polygon);
	}

}
