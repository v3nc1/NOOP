package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ViewDataPanel extends JPanel {
	
	private JTextArea txtArea;
	private JScrollPane scrPane;
	
	
	public ViewDataPanel() {
		
		setLayout(new BorderLayout());
		Dimension dim=getPreferredSize();
		dim.width=340;
		setPreferredSize(dim);
		runCreate();
		runLayout();
	}
	
	public void showFormData(String txt) {
		
		txtArea.append(txt + "\n");
		
	}
	
	
	private void runCreate() {
		
		txtArea=new JTextArea();
		txtArea.setEditable(false);
		
		scrPane=new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	}
	
	private void runLayout() {
		
		
		add(scrPane,BorderLayout.CENTER);
	}

}
