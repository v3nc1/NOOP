package gui;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanel extends JPanel {

	private JTextArea tArea;

	public TextPanel() {

		tArea = new JTextArea();

		setLayout(new BorderLayout());

		add(new JScrollPane(tArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),
				BorderLayout.CENTER);
	}

	public void writeText(String str) {

		tArea.append(str + "\n");
	}
	
	public void clearTextArea() {
		
		tArea.selectAll();
		tArea.replaceSelection("");
	}
	
	

}
