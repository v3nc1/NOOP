import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ObserverGUI extends JFrame implements ObserverWth{
	
	private Obs obs;
	private JPanel obsPanel;
	private JTextField txtTemp;
	private JTextField txtHum;
	private JTextField txtPress;
	private String name;
	private ObserverWth obsWth;
	

	public ObserverGUI(Obs obs) {
		
		super(obs.toString());
		
		this.obs=obs;
		
		setVisible(true);
		setSize(350, 250);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		runCreate();
		runLayout();
		runAction();

	}
	
	
	
	private void runAction() {
		
		
		
	}

	private void runCreate() {
		
		
		obsPanel = new JPanel();
		txtTemp = new JTextField(10);
		txtHum = new JTextField(10);
		txtPress = new JTextField(10);

	}

	private void runLayout() {
		
		setLayout(new FlowLayout());
		
		obsPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gc=new GridBagConstraints();
		
		gc.gridx=0;
		gc.gridy=0;
		gc.insets=new Insets(10, 10, 10, 10);
		gc.anchor=gc.LINE_START;
		obsPanel.add(new JLabel("Temperatura: "),gc);
		
		gc.gridy=1;
		obsPanel.add(new JLabel("Vlaznost: "),gc);
		
		gc.gridy=2;
		obsPanel.add(new JLabel("Tlak: "),gc);
		
		gc.gridx=1;
		gc.gridy=0;
		obsPanel.add(txtTemp, gc);
		
		gc.gridy=1;
		obsPanel.add(txtHum, gc);
		
		gc.gridy=2;
		obsPanel.add(txtPress, gc);
		
		runBorder(obsPanel, "Stanje");
		
		add(obsPanel);

	}

	private void runBorder(JPanel panel, String name) {

		Border top = BorderFactory.createTitledBorder(name);
		Border bottom = BorderFactory.createEmptyBorder(10, 10, 10, 10);

		panel.setBorder(BorderFactory.createCompoundBorder(top, bottom));

		
	}



	@Override
	public void update(float temp, float hum, float press) {
		
		txtTemp.setText(obs.getTemp());
		txtHum.setText(obs.getHum());
		txtPress.setText(obs.getPress());
		
	}


	
}
