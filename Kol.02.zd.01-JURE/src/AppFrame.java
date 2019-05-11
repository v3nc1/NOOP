import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AppFrame extends JFrame {

	private TextPanel txtPanel;
	private FormPanel fPanel;

	public AppFrame() {

		createComponents();
		activateFrame();
		setLayout(new BorderLayout());

		add(txtPanel, BorderLayout.NORTH);
		add(fPanel, BorderLayout.CENTER);
		pack();

	}

	public void createComponents() {

		fPanel = new FormPanel();
		txtPanel = new TextPanel();
		fPanel.setMozePisatiPoSebi(txtPanel);

	}

	public void activateFrame() {

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
