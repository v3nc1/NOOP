import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GameFrame extends JFrame {
	
	private FormAction formA;
	private FormPanel form;
	private JTextArea textArea;
	private JScrollPane scroll;
	GameActions gAction;
	
	
	public GameFrame() {
		
		super("Game app");
		
		setLayout(new BorderLayout());
		setSize(550, 350);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		createComp();
	}
	
	public void createComp() {
		
		formA=new FormAction(this);
		form = new FormPanel();
		textArea = new JTextArea();
		scroll= new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		scroll.setPreferredSize(new Dimension(550,100));	
		
		add(scroll,BorderLayout.NORTH);
		add(form, BorderLayout.CENTER);
		form.gTxt=textArea;
		
		
		addWindowListener(formA);
	}
	
	public void setTxt(String txt) {
		
		
		textArea.append(txt);
	}
	

}
