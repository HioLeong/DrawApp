package comp2013.hleong.drawapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.StringTokenizer;

public class JavaFxParser {

	private BufferedReader reader;
	private ImagePanel imagePanel;

	public JavaFxParser(Reader reader, ImagePanel imagePanel) {
		this.reader = new BufferedReader(reader);
		this.imagePanel = imagePanel;
	}

	public void parse() {
		try {
			String line = reader.readLine();
			while (line != null) {
				parseLine(line);
				line = reader.readLine();
			}
		} catch (IOException e) {

		} catch (ParseException e) {

		}
	}

	private void parseLine(String line) throws ParseException {
		if (line.length() < 2)
			return;
		String command = line.substring(0, 2);
		if (command.equals("DL")) {
			drawLine(line.substring(2, line.length()));
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

	public void fillRect(String args) throws ParseException {
		// TODO Auto-generated method stub

	}

	public void drawArc(String args) throws ParseException {
		// TODO Auto-generated method stub

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
