package comp2013.hleong.drawapp;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class Turtle extends Group {

	private double x;
	private double y;
	private double angle;
	private Polygon turtle;

	public Turtle(double x, double y) {

		turtle = new Polygon(new double[] { 0, 0, -6, -4, -4, 0, -6, 4 });
		turtle.setFill(Color.BLACK);
		getChildren().add(turtle);

		turtle.getTransforms().add(new Translate(x, y));

		// Set its initial coordinates and angle.
		angle = 0;
		this.setX(x);
		this.setY(y);
	}

	public void forward(double pixel) {
		double oldx = getX();
		double oldy = getY();

		x += pixel * Math.cos(Math.toRadians(angle));
		y += pixel * Math.sin(Math.toRadians(angle));
		
		System.out.println(x);
		System.out.println(y);

		// for pen up/down
		Line l = new Line(oldx, oldy, x, y);
		getChildren().add(l);
		
		Translate t = new Translate(x , y);
		turtle.getTransforms().add(t);

	}

	public void turnLeft(double dAngle) {
		angle -= dAngle;
		Rotate r = new Rotate(-dAngle);
		turtle.getTransforms().add(r);
	}

	public void turnRight(double dAngle) {
		angle += dAngle;
		Rotate r = new Rotate(dAngle);
		turtle.getTransforms().add(r);
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

}
