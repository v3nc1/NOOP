import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Frame extends JFrame {

	JButton btt1;
	JButton btt2;
	JButton btt3;
	JButton btt4;
	JButton btt5[][];

	public Frame() {

		createComps();
	}

	private void createComps() {

		setSize(300, 300);
		setVisible(true);

		btt1 = new JButton("Botun 1");
		btt2 = new JButton("Botun 2");
		btt3 = new JButton("Botun 3");
		btt4 = new JButton("Botun 4");

		btt5 = new JButton[4][4];

		/*for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 4; j++) {

				btt5[i][j].setBackground(new Color(6));
			}
		}*/

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = gc.LINE_START;

		add(btt1, gc);

		gc.gridx = 1;

		add(btt2, gc);

		gc.gridx = 2;

		add(btt3, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 3;

		gc.fill = gc.HORIZONTAL;

		add(btt4, gc);

		/*
		gc.gridx = 0;
		gc.gridy = 2;
		gc.gridwidth = 2;
		gc.fill = gc.NONE;
		*/
		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 4; j++) {
				btt5[i][j]=new JButton(i+" "+j);
				gc.gridx = j;
				gc.gridy = i+2;
				gc.gridwidth = 1;
				
				gc.fill = gc.BOTH;
				add(btt5[i][j],gc);
				btt5[i][j].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						
						
						//btt5[i][j].setEnabled(false);
						JOptionPane.showMessageDialog(null,arg0.getSource().hashCode() , "Test", JOptionPane.INFORMATION_MESSAGE);
						getFocusOwner().setEnabled(false);
					}
				});
			}
		}
		
		//add(btt5, gc);

	}

}
