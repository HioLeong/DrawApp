package comp2013.hleong.drawapp;

public class MainWindow {

	public static final double DEFAULT_WIDTH = 500;
	public static final double DEFAULT_HEIGHT = 300;
	
	private ImagePanel imagePanel;
	
	public MainWindow() {
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	public MainWindow(double width, double height) {
		imagePanel = new ImagePanel(width, height);
	}

	public ImagePanel getImagePanel() {
		return imagePanel;
	}
	
}
