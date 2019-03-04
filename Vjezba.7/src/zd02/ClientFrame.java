package zd02;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.omg.CORBA.portable.OutputStream;

public class ClientFrame extends JFrame {
	
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JTextArea txtView;
	private JTextField txtMessage;
	private JButton btnSend;
	private Socket client;
	private PrintWriter out;
	private BufferedReader input;
	private QuotesToFile writeQuotes;
	
	
	public ClientFrame(String name) {
		
		setTitle(name);
		runCreate();
		runLayout();
		
		
	}
	
	public void runConnection() throws UnknownHostException, IOException{
		
		runAction();
		setNetwork();
		
	}
	
	
	private void setNetwork() throws UnknownHostException,IOException{
		
		//make object for client request to the wished server
		client=new Socket("127.0.0.1", 53000);
		
		//create I/O streams
		InputStreamReader inStream=new InputStreamReader(client.getInputStream());
		input=new BufferedReader(inStream);
		out=new PrintWriter(client.getOutputStream(),true);
		
		//check connection to the server
		System.out.println("Connection established -->> "+client.isConnected());
		
	}
	private void runAction() {
		
		
		btnSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				out.println(txtMessage.getText());
				out.flush();
				txtView.append(txtMessage.getText()+"\n");
				txtView.append("----------------------------------------------\n");

				String quote=null;
				
				try {
					quote=input.readLine();
					txtView.append(quote);
					txtView.append("\n----------------------------------------------\n");
					writeQuotes.write(quote);
					
				}catch(IOException err) {
					
					err.printStackTrace();
				}
				txtMessage.setText("");
				txtMessage.requestFocus();
			}
		});
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				
				try{
					client.close();
				}catch (Exception el) {
					el.printStackTrace();
				}
				System.out.println("Client closed connection....");
				System.out.println("Client is closed? -->> " + client.isClosed());
				
			}
			
			
			
		});
		
		
		
	}
	
	private void runCreate() {
		
		topPanel=new JPanel();
		bottomPanel=new JPanel();
		txtView=new JTextArea();
		txtMessage=new JTextField(25);
		btnSend=new JButton("Send");
		writeQuotes=new QuotesToFile();
		
		
	}
	
	private void runLayout() {
		
		
		setLayout(new BorderLayout());
		topPanel.setLayout(new BorderLayout());
		bottomPanel.setLayout(new GridBagLayout());
		GridBagConstraints gc=new GridBagConstraints();
		
		topPanel.add(new JScrollPane(txtView,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.CENTER);
		
		gc.gridx=0;
		gc.gridy=0;
		gc.insets=new Insets(10, 10, 10, 10);
		
		bottomPanel.add(txtMessage,gc);
		
		gc.gridx=1;
		
		bottomPanel.add(btnSend, gc);
		
		add(topPanel,BorderLayout.CENTER);
		add(bottomPanel,BorderLayout.SOUTH);
		
		setSize(500, 700);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		
	}
	
	
}
