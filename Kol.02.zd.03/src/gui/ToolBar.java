package gui;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import controller.Controller;

public class ToolBar extends JPanel implements ActionListener {

	private JButton clrBtn;
	private JButton readBtn;
	private JButton cstBtn;
	private ToolBarListener tListener;
	private TextPanel txtP;

	public ToolBar() {

		createComps();
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(clrBtn);
		add(readBtn);
		add(cstBtn);
		activateComps();

	}

	private void createComps() {

		clrBtn = new JButton("clear");
		readBtn = new JButton("read file ...");
		cstBtn = new JButton("customers");
		txtP = new TextPanel();

	}

	private void activateComps() {

		clrBtn.addActionListener(this);
		readBtn.addActionListener(this);
		cstBtn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent ev) {

		BufferedReader br;
		StringBuilder sb;

		if (ev.getSource() == clrBtn) {

			tListener.clearAllText();
			System.out.println("clear text");

		} else if (ev.getSource() == readBtn) {
			
			JFileChooser fc = new JFileChooser();
			int val = fc.showOpenDialog(this);
			
			if(val == JFileChooser.APPROVE_OPTION) {
				
				File file = fc.getSelectedFile();
				
				try {
					br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
					sb = new StringBuilder();
					String line;
					while((line = br.readLine()) != null) {
						sb.append(line);
						sb.append("\n");
					}
					
					br.close();
					
					tListener.setTextFromFile(sb.toString());
					
				} catch (UnsupportedEncodingException | FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} 	

		} else if (ev.getSource() == cstBtn) {
			
			tListener.listAllCustomers();
			
			tListener.listCustomers();
			tListener.listOrders();
			//txtP.writeText(tListener.listCustomers());
			
			
			
		} else {
			System.out.println("Cancelled by User ...");
		}

	}

	public void setToolBarListener(ToolBarListener lst) {
		this.tListener = lst;
	}

}
