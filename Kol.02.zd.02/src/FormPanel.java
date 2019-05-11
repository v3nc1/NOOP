import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {

	private JComboBox playersCombo;
	private JLabel numLabel;
	private JTextField numField;
	private JButton btnPlay;
	private JButton btnNewGame;
	private JLabel usrNameLbl;
	private JTextField usrField;
	private JLabel ageLbl;
	private JTextField ageField;
	private JButton newPlyBtn;
	private DefaultComboBoxModel cmbBoxPlyModel;
	private JPanel left;
	private JPanel right;
	private GameActions gameA;
	public JTextArea gTxt;

	public FormPanel() {

		setLayout(new BorderLayout());
		createComp();
		leftPanel();
		rightPanel();
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.CENTER);
		layoutComponentsLeft();
		layoutComponentsRight();

	}

	private void createComp() {
		
		gameA=new GameActions(this);

		cmbBoxPlyModel = createComboModel();
		playersCombo = new JComboBox(cmbBoxPlyModel);
		numLabel = new JLabel("Number:");
		numField = new JTextField(4);
		usrField = new JTextField(10);
		btnPlay = new JButton("play");
		btnNewGame = new JButton("New Game");
		usrNameLbl = new JLabel("User name:");
		ageLbl = new JLabel("Your age:");
		ageField = new JTextField(10);
		newPlyBtn = new JButton("Create profile");
		gTxt=new JTextArea();
		
		gameA.playerCombo=playersCombo;

		left = new JPanel();
		right = new JPanel();
		
		btnPlay.addActionListener(gameA);
		newPlyBtn.addActionListener(gameA);
		btnNewGame.addActionListener(gameA);
		
	}

	private DefaultComboBoxModel createComboModel() {

		DefaultComboBoxModel cmbBoxPlyModel = new DefaultComboBoxModel();

		cmbBoxPlyModel.addElement("player 1");
		cmbBoxPlyModel.addElement("player 2");
		cmbBoxPlyModel.addElement("player 3");

		return cmbBoxPlyModel;
	}
	public void addPlayer(String name){
		
		cmbBoxPlyModel.addElement(name);
		
	}
	public int getPlayer(String name) {
		
		return cmbBoxPlyModel.getIndexOf(name);
	}

	private void layoutComponentsLeft() {

		left.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		///////////////////// First Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		left.add(numLabel, gbc);
		///////////////////// Second Row /////////////////////
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(5, 0, 0, 15);

		gbc.anchor = GridBagConstraints.LINE_END;
		left.add(playersCombo, gbc);

		gbc.weightx = 1;

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		left.add(numField, gbc);
		///////////////////// Third Row /////////////////////
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weighty = 1;
		gbc.insets = new Insets(25, 0, 0, 0);
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		left.add(btnPlay, gbc);
		////////////////////Fourth Row//////////////////////
		gbc.gridx = 0;
		gbc.gridy = 3;
		//gbc.weightx=2;
		//gbc.insets = new Insets(10, 0, 0, 20);
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		left.add(btnNewGame, gbc);

	}

	private void layoutComponentsRight() {

		right.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		///////////////////// First Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(20, 10, 0, 10);
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		right.add(usrNameLbl, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(20, 10, 0, 10);
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		right.add(usrField, gbc);
		///////////////////// Second Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(20, 10, 0, 10);
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		right.add(ageLbl, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(20, 10, 0, 10);
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		right.add(ageField, gbc);
		///////////////////// Last Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty =2;

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		right.add(newPlyBtn, gbc);

	}

	private void leftPanel() {

		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border inner = BorderFactory.createTitledBorder("Play game");
		left.setBorder(BorderFactory.createCompoundBorder(outer, inner));
		Dimension dim = left.getPreferredSize();
		dim.width = 350;
		left.setPreferredSize(dim);
	}

	private void rightPanel() {

		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border inner = BorderFactory.createTitledBorder("Add new player");
		right.setBorder(BorderFactory.createCompoundBorder(outer, inner));
		Dimension dim = left.getPreferredSize();
		dim.width = 200;
		left.setPreferredSize(dim);
	}
	
	
	public String getTxt() {
		
		return numField.getText();
		
	}
	
	public void setTxt(String txt) {
		
		numField.setText(txt);
		
	}
	
	public String getName() {
		                                        
		
		return cmbBoxPlyModel.getElementAt(playersCombo.getSelectedIndex()).toString();
	}
	
	public String getUser() {
		
		return usrField.getText();
		
	}
	public void clearUser() {
		
		usrField.setText("");
		ageField.setText("");
	}
	
	public void focus() {
		
		numField.grabFocus();
	}
	
	public void userFocus() {
		
		usrField.grabFocus();
	}
	

}
