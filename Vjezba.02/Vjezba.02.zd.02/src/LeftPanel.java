import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class LeftPanel extends JPanel{
	
	private JPanel topPanel;
	private JPanel bottomPanel;
	
	private JTextField txtName;
	private JButton btnAdd;
	
	private JTextArea txtObsData;
	private JButton btnList;
	private JComboBox cmbObs;
	private DefaultComboBoxModel<ObserverWth> cmbModObs;
	private JButton btnRemove;
	
	private WeatherStation wth;
	private Obs obs;
	
	public LeftPanel() {
		
		runCreate();
		runLayout();
		runAction();
		
	}
	
	private void runAction() {
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				obs=new Obs(txtName.getText());
				
				ObserverGUI obsGui=new ObserverGUI(obs);
				
				obs.setGui(obsGui);
				
				wth.add(obs);
				
				cmbModObs.addElement(obs);
				txtName.setText("");
				
				
				
			}
		});
		
		btnList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				txtObsData.setText("");
				for(ObserverWth ob:wth.getList()) {
					
					txtObsData.append("#------------------------------#\n");
					txtObsData.append("Active observer:"+ob.toString()+"\n");
				}
				
			}
		});
		
		btnRemove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				wth.remove((ObserverWth) cmbModObs.getSelectedItem());
				cmbModObs.removeElement(cmbObs.getSelectedItem());
				
			}
		});
		
	}
	
	public void setWeatherStation(WeatherStation wth) {
		this.wth=wth;
		
	}
	private void runCreate() {
		
		topPanel=new JPanel();
		bottomPanel=new JPanel();
		
		txtName=new JTextField(20);
		btnAdd=new JButton("Dodaj na listu");
		
		txtObsData=new JTextArea(10,20);
		btnList=new JButton("Izlistaj");
		cmbModObs=new DefaultComboBoxModel<>();
		cmbObs=new JComboBox<>();
		
		cmbObs.setModel(cmbModObs);
		btnRemove=new JButton("Ukloni");
		
	}
	
	private void runLayout() {
		
		setLayout(new GridBagLayout());
		
		topPanel.setLayout(new GridBagLayout());
		bottomPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gc=new GridBagConstraints();
		
		gc.gridx=0;
		gc.gridy=0;
		gc.insets=new Insets(10, 10, 10, 10);
		gc.anchor=gc.LINE_START;
		
		topPanel.add(new JLabel("Novi promatrac:"),gc);
		
		gc.gridy=1;
		
		topPanel.add(txtName, gc);
		
		gc.gridy=2;
		
		topPanel.add(btnAdd, gc);
		
		gc.gridx=0;
		gc.gridy=0;
		gc.insets=new Insets(10, 10, 10, 10);
		gc.anchor=gc.CENTER;
		
		bottomPanel.add(new JScrollPane(txtObsData,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),gc);
		
		gc.gridy=1;
		
		bottomPanel.add(btnList, gc);
		
		gc.gridy=2;
		
		bottomPanel.add(cmbObs, gc);
		
		gc.gridy=3;
		
		bottomPanel.add(btnRemove, gc);
		
		
		runBorder(bottomPanel, "Podaci o promatracima");
		
		gc.gridx=0;
		gc.gridy=0;
		gc.insets=new Insets(10, 10, 10, 10);
		gc.anchor=gc.LINE_START;
		
		add(topPanel,gc);
		
		gc.gridy=1;
		
		add(bottomPanel,gc);
		
	}
	
	
	private void runBorder(JPanel panel,String name) {
		
		Border top=BorderFactory.createTitledBorder(name);
		Border bottom=BorderFactory.createEmptyBorder(10, 10, 10, 10);
		
		panel.setBorder(BorderFactory.createCompoundBorder(top, bottom));
		
	}

	
	

}
