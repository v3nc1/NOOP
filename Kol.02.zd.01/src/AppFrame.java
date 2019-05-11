import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AppFrame extends JFrame{
	
	private JTextArea txtArea;
	FormPanel fPanel;
	
	public AppFrame() {
			
		createComponents();
		activateFrame();		
		setLayout(new BorderLayout());
		
		add(txtArea,BorderLayout.NORTH);
		add(fPanel,BorderLayout.CENTER);
		pack();
		
	}
	
	public void createComponents() {
		
		fPanel=new FormPanel();
		txtArea=new JTextArea(10,10);
		fPanel.txtArea=this.txtArea;
			
	}
		
	public void activateFrame() {
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}
