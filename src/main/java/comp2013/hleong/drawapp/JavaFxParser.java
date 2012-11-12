package comp2013.hleong.drawapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.StringTokenizer;

public class JavaFxParser {

	private BufferedReader reader;

	public JavaFxParser(Reader reader) {
		this.reader = new BufferedReader(reader);
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

	}

	public void drawLine(String args) throws ParseException {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		return 0;
	}

}
