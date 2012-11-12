package comp2013.hleong.drawapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.StringTokenizer;

import javafx.scene.control.Label;

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

	public void drawArc(String args) throws ParseException {
	    int x = 0;
	    int y = 0;
	    int width = 0;
	    int height = 0;
	    int startAngle = 0;
	    int arcAngle = 0;
	    
	    StringTokenizer tokenizer = new StringTokenizer(args);
	    x = getInteger(tokenizer);
	    y = getInteger(tokenizer);
	    width = getInteger(tokenizer);
	    height = getInteger(tokenizer);
	    startAngle = getInteger(tokenizer);
	    arcAngle = getInteger(tokenizer);
	    imagePanel.drawArc();

	}

	public void drawOval(String args) throws ParseException {
		// TODO Auto-generated method stub

	}

	public void drawString(String args) throws ParseException {
		// TODO Auto-generated method stub

	}

	public void setColour(String colourName) throws ParseException {
		// TODO Auto-generated method stub

	}

	public int getInteger(StringTokenizer tokenizer) throws ParseException {
		if (tokenizer.hasMoreElements()) {
			return Integer.parseInt(tokenizer.nextToken());
		} else {
			throw new ParseException("Missing Integer value");
		}
	}

}
