import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Mainframe extends JFrame {
	
	private LeftPanel leftPanel;
	private RightPanel rightPanel;
	private WeatherStation wth;
	
	public Mainframe() {
		
		setVisible(true);
		setSize(700, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		runCreate();
		runLayout();
		
		
	}
	
	private void runCreate() {
		
		wth=new WeatherStation();
		leftPanel=new LeftPanel();
		rightPanel=new RightPanel();
		leftPanel.setWeatherStation(wth);
		rightPanel.setWeatherStation(wth);
		
	}
	
	private void runLayout() {
		
		setLayout(new GridLayout(1, 2));
		
		add(leftPanel);
		add(rightPanel);
		
		
		
	}

}
