import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class SearchPanel extends JDialog implements Data {

	private JPanel pLeft;
	private JPanel pRight;
	private JPanel pBottom;
	private JTextField txtName;
	private JTextField txtLast;
	private JTextField txtId;
	private JTextArea txtData;
	private JScrollPane scroll;
	private JButton btnShow;
	private JButton btnExit;
	private JButton btnList;
	private ArrayList<Djelatnik> baza;
	private Djelatnik dj;

	public SearchPanel(JFrame frame) {
		super(frame, "Data frame", false);

		setVisible(true);
		setSize(600, 350);
		createComps();
		layoutRun();
		actionRun();

	}

	private void actionRun() {

		btnShow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int tempID = Integer.parseInt(txtId.getText());

				dj = searchDjelatnik(tempID);

				txtName.setText(dj.getIme());
				txtLast.setText(dj.getPrezime());
				
				txtData.setText("");

			}
		});

		btnList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int tempID = Integer.parseInt(txtId.getText());

				dj = searchDjelatnik(tempID);
				
				txtData.append("ID: "+ dj.getId()+"\n");
				txtData.append("Ime: "+dj.getIme()+"\n");
				txtData.append("Prezime: "+ dj.getPrezime()+"\n");
				txtData.append("Odjel: "+ dj.getOdjel()+"\n");
				txtData.append("Struèna sprema: "+ dj.getSs()+"\n");
				txtData.append("Dodatci: "+ dj.getDodaci()+"\n");
				
				

			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				txtName.setText("");
				txtLast.setText("");
				txtData.setText("");
				txtId.setText("");
				
				setVisible(false);
			}
		});

	}

	private Djelatnik searchDjelatnik(int id) {
		
		boolean flag=false;
		for (Djelatnik d : baza) {

			if (d.getId() == id) {
				flag=true;
				return d;
			} 
		}
			if(flag==false){

				JOptionPane.showMessageDialog(null, "Ne postoji djelatnik unesenim IDom", "Greška",
						JOptionPane.INFORMATION_MESSAGE);
			}


		return null;
	}

	private void createComps() {

		pRight = new JPanel();
		pLeft = new JPanel();
		pBottom = new JPanel();
		txtName = new JTextField(15);
		txtLast = new JTextField(15);
		txtId = new JTextField(10);
		txtData = new JTextArea(10, 20);
		scroll = new JScrollPane(txtData, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		btnExit = new JButton("Exit");
		btnShow = new JButton("Show data");
		btnList = new JButton("List all");
		baza=new ArrayList<>();

	}

	private void layoutRun() {

		setLayout(new FlowLayout());
		pLeft.setLayout(new GridLayout(4, 1));

		Border top = BorderFactory.createTitledBorder("Data");
		Border bott = BorderFactory.createEmptyBorder(20, 20, 40, 20);

		pLeft.add(new Label("Ime"));
		pLeft.add(txtName);
		pLeft.add(new Label("Prezime"));
		pLeft.add(txtLast);
		pLeft.setBorder(BorderFactory.createCompoundBorder(top, bott));

		add(pLeft);

		pRight.setLayout(new FlowLayout());

		pRight.add(scroll);

		add(pRight);

		pBottom.setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1.0;
		gc.anchor = gc.LINE_START;
		gc.insets = new Insets(5, 0, 10, 10);
		pBottom.add(new JLabel("ID"), gc);

		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 1.0;
		gc.anchor = gc.LINE_START;
		pBottom.add(txtId, gc);

		gc.gridx = 1;
		gc.gridy = 1;

		pBottom.add(btnShow, gc);

		gc.gridx = 2;
		gc.gridy = 1;

		pBottom.add(btnExit, gc);

		gc.gridx = 3;
		gc.gridy = 1;

		pBottom.add(btnList, gc);

		add(pBottom);

	}
	

	@Override
	public void getBaza(SearchDataEvent se) {
		
		baza= se.getBazaDj();
		
	}

}
