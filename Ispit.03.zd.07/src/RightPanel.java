import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RightPanel extends JPanel {
	
	private JTextArea txtArea;
	private JScrollPane scroll;
	private JButton btnSend;
	private JButton btnCancel;
	private JButton btnSearch;
	
	
	public JTextArea getTxtArea() {
		return txtArea;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public JButton getBtnSend() {
		return btnSend;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public RightPanel() {
		
		createComps();
		layoutRun();
		actionRun();
		
		
	}
	
	public void resetData() {
		
		txtArea.setText("");
	}
	private void actionRun() {
		
		btnSearch.setEnabled(false);
		
	}
	
	private void createComps() {
		
		txtArea=new JTextArea();
		scroll=new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		btnSend=new JButton("Send data");
		btnCancel=new JButton("Cancel");
		btnSearch=new JButton("Search");
	
		
		
		
	}
	
	private void layoutRun() {
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc=new GridBagConstraints();
		
		gc.gridx=0;
		gc.gridy=0;
		
		gc.gridwidth=3;
		gc.gridheight=6;
		gc.insets=new Insets(10, 10, 0, 10);
		gc.weightx=1.0;
		gc.weighty=1.0;
		gc.ipady=250;
		gc.anchor=gc.FIRST_LINE_START;
		gc.fill=gc.BOTH;
		
		add(scroll,gc);
		
		
		gc.gridx=0;
		gc.gridy=6;
		gc.gridwidth=1;
		gc.gridheight=1;
		gc.ipady=1;
		gc.insets=new Insets(0, 10, 10, 10);
		gc.anchor=gc.LAST_LINE_START;
		gc.fill=gc.NONE;
		
		add(btnSend,gc);
		
		gc.gridx=1;
		gc.gridy=6;
		
		add(btnCancel,gc);
		
		gc.gridx=2;
		gc.gridy=6;
		
		add(btnSearch,gc);
		
		
		
		
		
		
	}

}
