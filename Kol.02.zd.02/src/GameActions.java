import java.awt.color.CMMException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GameActions  implements ActionListener {
	
	
	FormPanel gPanel;
	public JComboBox playerCombo=new JComboBox<>();
	private JTextArea txtA=new JTextArea();
	int nr=0;
	int guess;
	private ArrayList<Integer> guessNr=new ArrayList<>();
	private String player;
	
	public GameActions(FormPanel gx) {
		
		gPanel = gx;
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		boolean flag=true;
		JButton jBtt=(JButton) e.getSource();
		
		
		if (jBtt.getText()=="Create profile") {
			
			gPanel.addPlayer(gPanel.getUser()) ;
			
		
			playerCombo.setSelectedIndex(gPanel.getPlayer(gPanel.getUser()));
			gPanel.clearUser();
			
			game("New User");
			flag=false;
			
		}
		
		
		if (jBtt.getText()=="New Game") {
			
			int playerOption=JOptionPane.showConfirmDialog(null, "You are new player?","Player info", JOptionPane.YES_NO_OPTION);
			
			if(playerOption==JOptionPane.NO_OPTION) {
				
				game("Player");
				gPanel.focus();
			
				
			}else {
				gPanel.userFocus();
			}
			
			
		}
		
			if (jBtt.getText()=="play") {
		
		try {
			
			
			guess=Integer.parseInt(gPanel.getTxt());
			
			if (guess>42 || guess<0) {
				
				JOptionPane.showMessageDialog(null, "Niste unjeli broj u pravom rasponu ", "Game info", JOptionPane.ERROR_MESSAGE);
				gPanel.setTxt("");
				gPanel.focus();
			
			}else if (guess==nr) {
				
				JOptionPane.showMessageDialog(null, "Toèno, pogodili ste broj "+nr, "Game info", JOptionPane.INFORMATION_MESSAGE);
				guessNr.add(guess);
				gPanel.gTxt.append("\nPlayer: "+player );
				gPanel.gTxt.append("\n"+guessNr.toString());
				gPanel.gTxt.append("\nTarget: "+ nr );
//				flag=true;
				playerCombo.setEnabled(true);
				
			}else {
				
				JOptionPane.showMessageDialog(null, "Niste pogodili broj ", "Game info", JOptionPane.ERROR_MESSAGE);
				gPanel.setTxt("");
				guessNr.add(guess);
				gPanel.focus();
			}
			
		}catch(Exception ev) {
			
			JOptionPane.showMessageDialog(null, "Wrong input", "Niste unjeli broj", JOptionPane.ERROR_MESSAGE);
			gPanel.setTxt("");
			gPanel.focus();
		}
		
		
			
		}
		
	}
	
	public void game(String name){
		
		playerCombo.setEnabled(false);
		gPanel.gTxt.append("\n//////////"+name+"//////////\n");
	
		player=gPanel.getName();


		nr=ThreadLocalRandom.current().nextInt(1,42);

		JOptionPane.showMessageDialog(null, "Random number [1,42] is generated ", "Game info", JOptionPane.INFORMATION_MESSAGE);
		gPanel.setTxt("");
		//gPanel.gTxt.append("\nTraženi broj je "+nr+"\n");
		guessNr.clear();
		

	}
	
	
	
}	
