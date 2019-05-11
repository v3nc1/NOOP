import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MainFrame extends JFrame{
	
	private JPanel lPanel;
	private JPanel rPanel;
	private JLabel lblA;
	private JLabel lblB;
	private JLabel lblC;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JButton bttS;
	private JButton bttLs;
	private JTextArea txtArea;
	private JScrollPane scroll;
	private ArrayList<Solution> solList;

	public MainFrame() {
		createComps();
		activateApp();
	}
	
	public void createComps() {
		
		lPanel=new JPanel();
		rPanel=new JPanel();
		lblA = new JLabel("parametar A");
		lblB = new JLabel("parametar B");
		lblC = new JLabel("parametar C");
		txtA = new JTextField(10);
		txtB = new JTextField(10);
		txtC = new JTextField(10);
		bttS = new JButton("Solve");
		bttLs = new JButton("List Solutions");
		txtArea = new JTextArea(20,20);
		scroll=new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		solList=new ArrayList<>();
		
		setTitle("Kvadratna jednadzba");
		setSize(new Dimension(700, 500));
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new GridLayout(1,2));
		
		GridBagConstraints gc=new GridBagConstraints();
		
		lPanel.setLayout(new GridBagLayout());
		setBorders();
		rPanel.setLayout(new GridLayout());
		
		////1 Row
		gc.gridx=0;
		gc.gridy=0;
		
		
		//gc.weightx=0.1;
		//gc.weighty=0.1;
		
		gc.anchor=gc.CENTER;
		gc.insets=new Insets(15, 15, 15, 15);
		//gc.fill=gc.NONE;
		//lPanel.setBorder();
		lPanel.add(lblA,gc);
		
		////2 Row	
		
		gc.gridy=1;
		
		
		gc.anchor=gc.CENTER;
		
		lPanel.add(txtA,gc);
		
		////3 Row
		
		gc.gridy=2;
		
		gc.anchor=gc.CENTER;
		
		lPanel.add(lblB,gc);
		

		////4 Row

		gc.gridy=3;
		gc.anchor=gc.CENTER;

		lPanel.add(txtB,gc);
		////5 Row
		gc.gridy=4;
		gc.anchor=gc.CENTER;

		lPanel.add(lblC,gc);
		////6 Row
		gc.gridy=5;
		gc.anchor=gc.CENTER;

		lPanel.add(txtC,gc);
		////7 Row
		gc.gridy=6;
		gc.anchor=gc.FIRST_LINE_START;

		lPanel.add(bttS,gc);
		
		gc.gridy=6;
		gc.gridx=1;
		gc.anchor=gc.FIRST_LINE_END;

		lPanel.add(bttLs,gc);
		
		add(lPanel);
		
		
		rPanel.add(scroll);
		add(rPanel);
		
		
		
	}
	
	private void setBorders() {
		
		Border top=BorderFactory .createTitledBorder("Kvadratna jednadžba");
		Border bottom=BorderFactory.createEmptyBorder(10, 10, 10, 10);
		lPanel.setBorder(BorderFactory.createCompoundBorder(top, bottom));
		

	}
	
	private void activateApp() {
		
		bttS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Solution sol=new Solution(Double.parseDouble(txtA.getText()),Double.parseDouble(txtB.getText()), Double.parseDouble(txtC.getText()));
					solList.add(sol);

					display(sol);
				}catch(NumberFormatException ev) {
					
					txtArea.append("Niste unjeli broj u sva polja!!!");
				}
				
				txtA.setText("");
				txtB.setText("");
				txtC.setText("");
				
				
			}
		});
		
		bttLs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int br=0;
				for (Solution sol:solList) {
					
					txtArea.append("______________________________\n");
					txtArea.append("Soluion"+br+"\n");
					
					if(sol.getD()<0) {
						
						txtArea.append("Jednadžba ima konjugirano kompleksno riješenje\n");
						txtArea.append("x1= "+sol.getX1()+"\n");
						txtArea.append("x2= "+sol.getX2()+"\n");
						
						
					}else if(sol.getD()>0) {
						
						txtArea.append("Jednadžba ima dva realna riješenja"+"\n");
						txtArea.append("x1= "+sol.getX1()+"\n");
						txtArea.append("x2= "+sol.getX2()+"\n");
						
					}else {
						
						txtArea.append("Jednadžba ima dvostruku nultoèku"+"\n");
						txtArea.append("x1= "+sol.getX1()+"\n");
						txtArea.append("x2= "+sol.getX2()+"\n");
						
					}
					br++;
					
					
				}
				
			}
		});
	}
	
	private void display(Solution sol) {
		
		txtArea.append("______________________________\n");
		if(sol.getD()<0) {
			
			txtArea.append("Soluion"+sol.getCnt());
			txtArea.append("Jednadžba ima konjugirano kompleksno riješenje\n");
			txtArea.append("x1= "+sol.getX1()+"\n");
			txtArea.append("x2= "+sol.getX2()+"\n");
			
			
		}else if(sol.getD()>0) {
			
			txtArea.append("Soluion"+sol.getCnt());
			txtArea.append("Jednadžba ima dva realna riješenja"+"\n");
			txtArea.append("x1= "+sol.getX1()+"\n");
			txtArea.append("x2= "+sol.getX2()+"\n");
			
		}else {
			
			txtArea.append("Soluion"+sol.getCnt());
			txtArea.append("Jednadžba ima dvostruku nultoèku"+"\n");
			txtArea.append("x1= "+sol.getX1()+"\n");
			txtArea.append("x2= "+sol.getX2()+"\n");
			
		}
		
		
		
	}

}
