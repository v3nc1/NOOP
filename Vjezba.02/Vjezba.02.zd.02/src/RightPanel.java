import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class RightPanel extends JPanel{
	
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JTextField txtTemp;
	private JTextField txtHum;
	private JTextField txtPress;
	private JButton btnSubmit;

	private JTextArea txtWthData;
	private WeatherStation wth;
	
	public RightPanel() {
		
		runCreate();
		runLayout();
		runAction();

	}
	
	private void runAction() {
		
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				wth.notifyObs(Float.parseFloat(txtTemp.getText()),Float.parseFloat( txtHum.getText()), Float.parseFloat(txtPress.getText()));
				
				txtWthData.append("#-----------------------------#\n");
				txtWthData.append("Temperatura: "+txtTemp.getText()+" °C\n");
				txtWthData.append("Vlaznost: "+txtHum.getText()+" %\n");
				txtWthData.append("Tlak: "+txtPress.getText()+" hPa\n");
			}
		});
	}

	private void runCreate() {
		
		topPanel=new JPanel();
		bottomPanel=new JPanel();
		txtTemp=new JTextField(10);
		txtHum=new JTextField(10);
		txtPress=new JTextField(10);
		
		btnSubmit=new JButton("Unesi promjene");
		
		txtWthData=new JTextArea(10,20);
		

	}
	
	public void setWeatherStation(WeatherStation wth) {
		this.wth=wth;
		
	}

	private void runLayout() {
		
		GridBagConstraints gc=new GridBagConstraints();
		
		setLayout(new FlowLayout());
		topPanel.setLayout(new GridBagLayout());
		bottomPanel.setLayout(new FlowLayout());
		
		gc.gridx=0;
		gc.gridy=0;
		gc.insets=new Insets(10, 10, 10, 10);
		gc.anchor=gc.LINE_START;
		
		topPanel.add(new JLabel("Temperatura: "), gc);
		
		gc.gridy=1;
		
		topPanel.add(new JLabel("Vlaznost: "), gc);
		
		gc.gridy=2;
		
		topPanel.add(new JLabel("Tlak: "), gc);
		
		gc.gridx=1;
		gc.gridy=0;
		
		topPanel.add(txtTemp, gc);
		
		gc.gridy=1;
		
		topPanel.add(txtHum, gc);
		
		gc.gridy=2;
		
		topPanel.add(txtPress, gc);
		
		gc.gridy=3;
		
		topPanel.add(btnSubmit, gc);
		
		runBorder(topPanel, "Stanje");
		
		bottomPanel.add(new JScrollPane(txtWthData,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		
		
		runBorder(bottomPanel, "Prikaz");
		
		add(topPanel);
		add(bottomPanel);

	}

	private void runBorder(JPanel panel, String name) {

		Border top = BorderFactory.createTitledBorder(name);
		Border bottom = BorderFactory.createEmptyBorder(10, 10, 10, 10);

		panel.setBorder(BorderFactory.createCompoundBorder(top, bottom));

	}

	

}
