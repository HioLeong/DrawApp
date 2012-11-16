package comp2013.hleong.drawapp;

import javafx.scene.control.Label;

public class ParseException extends Exception
{
  public ParseException()
  {
    super("Exception during parsing");
  }

  public ParseException(String message)
  {
    super(message);
  }
  
  public ParseException(Label label, String message) {
	  super(message);
	  label.setText(message);
  }
  
}
