import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.instrument.IllegalClassFormatException;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.IllegalFormatFlagsException;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MainFrane extends JFrame {

	private JPanel panel;
	private JLabel nameLbl;
	private JLabel lastLbl;
	private JLabel depLbl;
	private JLabel idLbl;
	private JTextField txtName;
	private JTextField txtLast;
	private JComboBox<String> comboBox;
	private JTextField txtId;
	private JRadioButton rBttnCro;
	private JRadioButton rBttnFor;
	private ButtonGroup rBttnGrop;
	private DefaultComboBoxModel<String> deCoMo;
	private JButton bttnSend;
	private JButton bttnCancel;
	private JButton bttnSearch;
	private dataSearch ds;
	private Map<Integer, Student> stList;

	public MainFrane() {
		createComps();
		activateApp();

	}

	public void activateApp() {

		bttnSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String ctz;
				boolean flag=false;
				try {
				if (rBttnCro.isSelected()) {

					ctz = rBttnCro.getText();
				} else {
					ctz = rBttnFor.getText();
				}
				Student st = new Student(txtName.getText(), txtLast.getText(), Integer.parseInt(txtId.getText()),
						ctz, comboBox.getSelectedItem().toString());
				
				
				if(stList.containsKey(Integer.parseInt(txtId.getText()))) {
					
					flag=true;
				}else {
					stList.put(Integer.parseInt(txtId.getText()), st);

					if (stList.size() == 3) {
						bttnSearch.setEnabled(true);
					}
				}
				if(flag) {
					
					JOptionPane.showMessageDialog(null, "Taj ID vec postoji!", "GREŠKA", JOptionPane.ERROR_MESSAGE);
				}
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Podaci nusu ispravno uneseni", "GREŠKA", JOptionPane.ERROR_MESSAGE);
				}

				
				txtName.setText("");
				txtLast.setText("");
				txtId.setText("");
				rBttnCro.setSelected(true);
				comboBox.setSelectedIndex(0);

			}
		});

		bttnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				SearchPanel sp = new SearchPanel(new JFrame());
				sp.setList(stList);

			}
		});

	}

	public void setDataSearch(dataSearch ds) {

		this.ds = ds;

	}

	public void createComps() {

		panel = new JPanel();
		nameLbl = new JLabel("Fist name:");
		lastLbl = new JLabel("Last name:");
		depLbl = new JLabel("Department:");
		idLbl = new JLabel("Unique ID:");
		txtName = new JTextField(10);
		txtLast = new JTextField(10);
		txtId = new JTextField(7);
		comboBox = new JComboBox<>();
		rBttnCro = new JRadioButton("CRO citizenship");
		rBttnFor = new JRadioButton("Foreign citizenship");
		deCoMo = new DefaultComboBoxModel<>();
		bttnSearch = new JButton("Search");
		bttnSearch.setEnabled(false);
		bttnSend = new JButton("Send data");
		bttnCancel = new JButton("Cancel");

		deCoMo.addElement("Komparativna književnost");
		deCoMo.addElement("Podmorske znansti");
		deCoMo.addElement("Filozofske znanosti");
		deCoMo.addElement("IT znanosti");
		rBttnGrop = new ButtonGroup();

		comboBox.setModel(deCoMo);

		rBttnGrop.add(rBttnCro);
		rBttnGrop.add(rBttnFor);

		rBttnCro.setSelected(true);

		stList = new HashMap<>();

		setVisible(true);
		setSize(700, 400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Enrollment app");

		setLayout(new BorderLayout());

		setBorders();

		GridBagConstraints gc = new GridBagConstraints();

		panel.setLayout(new GridBagLayout());

		//// ROW 1 ////

		gc.gridx = 0;
		gc.gridy = 0;
		gc.insets = new Insets(0, 5, 0, 50);
		gc.anchor = gc.LINE_START;

		panel.add(nameLbl, gc);

		gc.gridx = 1;
		gc.gridy = 0;

		gc.anchor = gc.LINE_START;

		panel.add(lastLbl, gc);

		gc.gridx = 2;
		gc.gridy = 0;

		gc.anchor = gc.LINE_START;

		panel.add(depLbl, gc);

		//// ROW 2 ////

		gc.gridx = 0;
		gc.gridy = 1;

		gc.anchor = gc.LINE_START;

		panel.add(txtName, gc);

		gc.gridx = 1;
		gc.gridy = 1;

		gc.anchor = gc.LINE_START;

		panel.add(txtLast, gc);

		gc.gridx = 2;
		gc.gridy = 1;

		gc.anchor = gc.LINE_START;

		panel.add(comboBox, gc);

		//// ROW 3 ////

		gc.gridx = 0;
		gc.gridy = 2;
		gc.insets = new Insets(50, 5, 0, 0);
		gc.anchor = gc.LINE_START;

		panel.add(idLbl, gc);

		gc.gridx = 0;
		gc.gridy = 3;
		gc.insets = new Insets(0, 5, 0, 0);
		gc.anchor = gc.LINE_START;

		panel.add(txtId, gc);

		gc.gridx = 1;
		gc.gridy = 3;
		gc.insets = new Insets(0, 50, 0, 0);
		gc.anchor = gc.LINE_START;
		// panel.add(rBttnGrop,gc);
		panel.add(rBttnCro, gc);

		gc.gridx = 1;
		gc.gridy = 4;
		gc.insets = new Insets(0, 50, 100, 0);
		gc.anchor = gc.LINE_START;

		panel.add(rBttnFor, gc);

		//// ROW 4 ////

		gc.gridx = 0;
		gc.gridy = 5;
		gc.insets = new Insets(10, 5, 0, 100);
		gc.anchor = gc.LINE_END;

		panel.add(bttnSend, gc);

		gc.gridx = 1;
		gc.gridy = 5;
		gc.insets = new Insets(10, 50, 0, 0);
		gc.anchor = gc.LINE_START;

		panel.add(bttnCancel, gc);

		gc.gridx = 2;
		gc.gridy = 5;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = gc.SOUTHEAST;

		panel.add(bttnSearch, gc);

		add(panel, BorderLayout.CENTER);

	}

	public void setBorders() {

		Border top = BorderFactory.createTitledBorder("Student's data");
		Border bottom = BorderFactory.createEmptyBorder(5, 5, 5, 5);

		panel.setBorder(BorderFactory.createCompoundBorder(top, bottom));

	}
}
