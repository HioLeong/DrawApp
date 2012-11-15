package comp2013.hleong.drawapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JavaFxParser {

	private BufferedReader reader;
	private ImagePanel imagePanel;
	private Label label;
	private MainWindow mainWindow;
	private Stage primaryStage;

	public JavaFxParser(Reader reader, 
			MainWindow mainWindow, Stage primaryStage) {
		this.mainWindow = mainWindow;
		this.reader = new BufferedReader(reader);
		this.imagePanel = mainWindow.getImagePanel();
		this.label = mainWindow.getLabel();
		this.primaryStage = primaryStage;
	}

	public void parse() {

		String currentLine = "";

		try {
			String line = reader.readLine();
			while (line != null) {
				currentLine = line;
				parseLine(line);
				line = reader.readLine();
			}
			label.setText("Drawing Complete");
		} catch (IOException e) {
			label.setText("IO Exception");
		} catch (ParseException e) {
			label.setText("Parse Exception: \n" + currentLine);
		}
	}

	public void singleStepParse() {
		String parsedLine = "";
		try {
			String line = reader.readLine();
			parsedLine = line;
			if (line != null) {
				parseLine(line);
				label.setText("Parsed line: \n" + line);
			} else {
				label.setText("Drawing Complete");
			}
		} catch (IOException e) {
			label.setText("IO Exception");
		} catch (ParseException e) {

			label.setText("Parse Exception: \n" + parsedLine);
		}
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
		if (command.equals("DI")) {
			drawImage(line.substring(2, line.length()));
		}
		if (command.equals("SG")) {
			setGradient(line.substring(2, line.length()));
		}
		if (command.equals("SD")) {
			setDimension(line.substring(2, line.length()));
		}

	}

	public void setDimension(String args) throws ParseException {

		StringTokenizer tokenizer = new StringTokenizer(args);

		int x = 0;
		int y = 0;

		x = getInteger(tokenizer);
		y = getInteger(tokenizer);

		mainWindow.setDimension(x, y);
		primaryStage.setHeight(y*1.3);
		primaryStage.setWidth(x);
		
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
		s = s.concat(getStrings(tokenizer));

		imagePanel.drawString(x, y, s);

	}

	public void drawImage(String args) throws ParseException {

		int x = 0;
		int y = 0;
		int width = 0;
		int height = 0;
		String fileName = "";

		StringTokenizer tokenizer = new StringTokenizer(args);

		x = getInteger(tokenizer);
		y = getInteger(tokenizer);
		width = getInteger(tokenizer);
		height = getInteger(tokenizer);
		fileName = getString(tokenizer);

		imagePanel.drawImage(x, y, width, height, fileName);
	}

	public void setColour(String colourName) throws ParseException {

		imagePanel.setColor(getColor(colourName));
		return;

	}

	public void setGradient(String args) throws ParseException {

		StringTokenizer tokenizer = new StringTokenizer(args);

		List<Color> colours = new ArrayList<Color>();
		while (tokenizer.hasMoreElements()) {
			colours.add(getColor(getString(tokenizer)));
		}

		imagePanel.setGradient(colours);
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
			s = tokenizer.nextToken();
			return s;
		} else {
			throw new ParseException("Missing String value");
		}
	}

	public String getStrings(StringTokenizer tokenizer) throws ParseException {
		String s = "";
		if (tokenizer.hasMoreElements()) {
			while (tokenizer.hasMoreElements()) {
				s = s.concat(" " + getString(tokenizer));
			}
			return s;
		} else {
			throw new ParseException("Missing String value");
		}
	}

	public Color getColor(String colourName) throws ParseException {

		if (colourName.equals("black")) {
			return Color.BLACK;
		}
		if (colourName.equals("blue")) {
			return Color.BLUE;
		}
		if (colourName.equals("cyan")) {
			return Color.CYAN;
		}
		if (colourName.equals("darkgrey")) {
			return Color.DARKGREY;
		}
		if (colourName.equals("grey")) {
			return Color.GREY;
		}
		if (colourName.equals("green")) {
			return Color.GREEN;
		}
		if (colourName.equals("lightgrey")) {
			return Color.LIGHTGREY;
		}
		if (colourName.equals("magenta")) {
			return Color.MAGENTA;
		}
		if (colourName.equals("orange")) {
			return Color.ORANGE;
		}
		if (colourName.equals("pink")) {
			return Color.PINK;
		}
		if (colourName.equals("red")) {
			return Color.RED;
		}
		if (colourName.equals("white")) {
			return Color.WHITE;
		}
		if (colourName.equals("yellow")) {
			return Color.YELLOW;
		}

		throw new ParseException("Invalid colour name");
	}
}
