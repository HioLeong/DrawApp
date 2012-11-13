package comp2013.hleong.drawapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.StringTokenizer;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class JavaFxParser {

	private BufferedReader reader;
	private ImagePanel imagePanel;
	private Label label;

	public JavaFxParser(Reader reader, Label label, ImagePanel imagePanel) {
		this.reader = new BufferedReader(reader);
		this.imagePanel = imagePanel;
		this.label = label;
	}

	public void parse() {
		try {
			String line = reader.readLine();
			while (line != null) {
				parseLine(line);
				line = reader.readLine();
			}
		} catch (IOException e) {
			label.setText("IO Exception");
		} catch (ParseException e) {
			label.setText("Parse Exception");
		}
		label.setText("Drawing Complete");
	}

	private void parseLine(String line) throws ParseException {
		if (line.length() < 2)
			return;
		String command = line.substring(0, 2);
		if (command.equals("DL")) {
			drawLine(line.substring(2, line.length()));
		}
		if (command.equals("DR")) {
			drawRect(line.substring(2, line.length()));
		}
		if (command.equals("FR")) {
			fillRect(line.substring(2, line.length()));
		}
		if (command.equals("DA")) {
			drawArc(line.substring(2, line.length()));
		}
		if (command.equals("DO")) {
			drawOval(line.substring(2, line.length()));
		}
		if (command.equals("DS")) {
			drawString(line.substring(2, line.length()));
		}
		if (command.equals("SC")) {
			setColour(line.substring(3, line.length()));
		}

	}

	public void drawLine(String args) throws ParseException {
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;

		StringTokenizer tokenizer = new StringTokenizer(args);
		x1 = getInteger(tokenizer);
		y1 = getInteger(tokenizer);
		x2 = getInteger(tokenizer);
		y2 = getInteger(tokenizer);

		imagePanel.drawLine(x1, y1, x2, y2);
	}

	public void drawRect(String args) throws ParseException {
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;

		StringTokenizer tokenizer = new StringTokenizer(args);
		x1 = getInteger(tokenizer);
		y1 = getInteger(tokenizer);
		x2 = getInteger(tokenizer);
		y2 = getInteger(tokenizer);

		imagePanel.drawRect(x1, y1, x2, y2);

	}

	public void fillRect(String args) throws ParseException {
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;

		StringTokenizer tokenizer = new StringTokenizer(args);
		x1 = getInteger(tokenizer);
		y1 = getInteger(tokenizer);
		x2 = getInteger(tokenizer);
		y2 = getInteger(tokenizer);

		imagePanel.fillRect(x1, y1, x2, y2);
	}

	public void drawArc(String args) throws ParseException {
		int centerX = 0;
		int centerY = 0;
		int radiusX = 0;
		int radiusY = 0;
		int startAngle = 0;
		int length = 0;

		StringTokenizer tokenizer = new StringTokenizer(args);
		centerX = getInteger(tokenizer);
		centerY = getInteger(tokenizer);
		radiusX = getInteger(tokenizer);
		radiusY = getInteger(tokenizer);
		startAngle = getInteger(tokenizer);
		length = getInteger(tokenizer);

		imagePanel.drawArc(centerX, centerY, radiusX, radiusY, startAngle,
				length);
	}

	public void drawOval(String args) throws ParseException {

		int centerX = 0;
		int centerY = 0;
		int radiusX = 0;
		int radiusY = 0;

		StringTokenizer tokenizer = new StringTokenizer(args);
		centerX = getInteger(tokenizer);
		centerY = getInteger(tokenizer);
		radiusX = getInteger(tokenizer);
		radiusY = getInteger(tokenizer);

		imagePanel.drawOval(centerX, centerY, radiusX, radiusY);
	}

	public void drawString(String args) throws ParseException {

		int x = 0;
		int y = 0;
		String s = "";

		StringTokenizer tokenizer = new StringTokenizer(args);
		x = getInteger(tokenizer);
		y = getInteger(tokenizer);
		s = s.concat(getString(tokenizer));

		imagePanel.drawString(x, y, s);

	}

	public void setColour(String colourName) throws ParseException {

		if (colourName.equals("black")) {
			imagePanel.setColor(Color.BLACK);
		}
		if (colourName.equals("blue")) {
			imagePanel.setColor(Color.BLUE);
		}
		if (colourName.equals("cyan")) {
			imagePanel.setColor(Color.CYAN);
		}
		if (colourName.equals("darkgrey")) {
			imagePanel.setColor(Color.DARKGREY);
		}
		if (colourName.equals("grey")) {
			imagePanel.setColor(Color.GREY);
		}
		if (colourName.equals("green")) {
			imagePanel.setColor(Color.GREEN);
		}
		if (colourName.equals("lightgray")) {
			imagePanel.setColor(Color.LIGHTGREY);
		}
		if (colourName.equals("magenta")) {
			imagePanel.setColor(Color.MAGENTA);
		}
		if (colourName.equals("orange")) {
			imagePanel.setColor(Color.ORANGE);
		}
		if (colourName.equals("pink")) {
			imagePanel.setColor(Color.PINK);
		}
		if (colourName.equals("red")) {
			imagePanel.setColor(Color.RED);
		}
		if (colourName.equals("white")) {
			imagePanel.setColor(Color.WHITE);
		}
		if (colourName.equals("yellow")) {
			imagePanel.setColor(Color.YELLOW);
		}
		// throw new ParseException("Invalid colour name");

	}

	public int getInteger(StringTokenizer tokenizer) throws ParseException {
		if (tokenizer.hasMoreElements()) {
			return Integer.parseInt(tokenizer.nextToken());
		} else {
			label.setText("Missing Integer value");
			throw new ParseException("Missing Integer value");
		}
	}

	public String getString(StringTokenizer tokenizer) throws ParseException {
		String s = "";
		if (tokenizer.hasMoreElements()) {
			while (tokenizer.hasMoreElements()) {
				s = s.concat(" " + tokenizer.nextToken());
			}
			return s;
		} else {
			throw new ParseException("Missing String value");
		}
	}

}
