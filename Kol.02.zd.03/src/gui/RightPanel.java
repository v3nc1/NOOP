package gui;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.Controller;

public class RightPanel extends JPanel {

	private JList lista;
	private JComboBox payCombo;
	private JCheckBox gftCard;
	private JCheckBox gftDecortiveBox;
	private JCheckBox newsLetter;
	private JTextField giftText;
	private JLabel giftTxtLabel;
	private JRadioButton rbtnExpr;
	private JRadioButton rbntNrml;
	private ButtonGroup rBtngroup;
	private JButton confirmBtn;
	private FormListener fLst;
	private Controller cnt;
	private MainFrame mfr;
	
	private ArrayList<JCheckBox> chcArray = new ArrayList<>();

	
	public RightPanel() {

		createRightComp();
		setBorders();
		setRightLayout();
		activateRightPanel();

	}

	private void setRightLayout() {

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		///////////////////// First Column /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(new JLabel("Izaberi kategoriju: "), gbc);

		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(new JScrollPane(lista, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(gftCard, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(gftDecortiveBox, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(newsLetter, gbc);

		///////////////////// Second Column /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.1;

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(new JLabel("Payment method: "), gbc);

		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(payCombo, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(giftTxtLabel, gbc);


		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(giftText, gbc);

		///////////////////// Third Column /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.1;

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(rbtnExpr, gbc);

		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(rbntNrml, gbc);

		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		gbc.insets = new Insets(0, 25, 15, 15);
		add(confirmBtn,gbc);

	}

	private void createRightComp() {

		lista = new JList();
		DefaultListModel listModel = new DefaultListModel();
		listModel.add(0, "Kategorija proizvoda 1");
		listModel.add(1, "Kategorija proizvoda 2");
		listModel.add(2, "Kategorija proizvoda 3");
		listModel.add(3, "Kategorija proizvoda 4");
		listModel.add(4, "Kategorija proizvoda 5");
		lista.setModel(listModel);
		lista.setBorder(BorderFactory.createEtchedBorder());
		lista.setVisibleRowCount(3);
                lista.setSelectedIndex(0); // Select first category by default

		payCombo = new JComboBox();
		DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
		comboModel.addElement("American");
		comboModel.addElement("Visa");
		comboModel.addElement("PayPal");
		comboModel.addElement("Google Wallet");
		comboModel.addElement("Ethereum");
		payCombo.setModel(comboModel);
                payCombo.setSelectedIndex(2); // Select PayPal by default

		gftCard = new JCheckBox("Gift Card");
		gftDecortiveBox = new JCheckBox("Decorative box");
		newsLetter = new JCheckBox("News Letters");
		giftText = new JTextField(10);
		giftTxtLabel = new JLabel("Short Gift Text:");
		giftText.setEnabled(false);
		giftTxtLabel.setEnabled(false);

		rbtnExpr = new JRadioButton("Express delivery");
		rbntNrml = new JRadioButton("Normal delivery");
		rBtngroup = new ButtonGroup();
		rBtngroup.add(rbtnExpr);
		rBtngroup.add(rbntNrml);
                rbntNrml.setSelected(true); // Select normal delivery by default

		confirmBtn = new JButton("confirm");
		
		chcArray.add(gftCard);
		chcArray.add(gftDecortiveBox);
		chcArray.add(newsLetter);

	}

	private void setBorders() {

		Border inner = BorderFactory.createTitledBorder("Purchase data:");
		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);

		setBorder(BorderFactory.createCompoundBorder(outer, inner));
	}

	private void activateRightPanel() {

		gftCard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (gftCard.isSelected()) {

					giftText.setEnabled(true);
					giftTxtLabel.setEnabled(true);

				} else {

					giftText.setEnabled(false);
					giftTxtLabel.setEnabled(false);

				}

			}
		});

		confirmBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int category = lista.getSelectedIndex();
				boolean gCard = gftCard.isSelected();
				boolean decPckg = gftDecortiveBox.isSelected();
				boolean nLetters = newsLetter.isSelected();
				String delivery = null;

				String payment = (String) payCombo.getSelectedItem();
				String gcText = giftText.getText();

				if(rbtnExpr.isSelected()) {

					delivery = "Express";
				} else {
					delivery = "Normal";
				}

				RightFormEvent rfe = new RightFormEvent(confirmBtn);
				rfe.setDelivery(delivery);
				rfe.setGcText(gcText);
				rfe.setDecorativePack(decPckg);
				rfe.setGiftCard(gCard);
				rfe.setNewLetter(nLetters);
				rfe.setPaymentMet(payment);
				rfe.setProducrCat(category);
	

				if(fLst != null) {
					fLst.rightPanelEventOccured(rfe);
				}

				resetRightForm();
			}
		});
	}

	public void setRightFormListener(FormListener listener) {

		this.fLst = listener;
	}
	
	private void resetRightForm() {
		
		lista.setSelectedIndex(0);
		payCombo.setSelectedIndex(2);
		giftText.setEnabled(false);
		giftTxtLabel.setEnabled(false);
		
		rbntNrml.setSelected(true);
		for(JCheckBox ch : chcArray) {
			
			ch.setSelected(false);
		}
	}

}