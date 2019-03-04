package zd03;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ClientFrame extends JFrame {

	private JPanel panel;
	private JPanel msgPanel;
	private JTextField msgField;
	private JButton sndBtn;
	private JTextArea txtArea;
	private JScrollPane scp;
	private String msg;
	private PrintWriter pwr;
	private static int clNum = 0;

	public ClientFrame() {

		initComps();
		layoutAll();
		activateChat();
		clNum++;
		this.setTitle("Client_" + clNum);
		setSize(550, 750);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	private void initComps() {

		panel = new JPanel(new BorderLayout());
		msgPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		msgField = new JTextField(35);
		sndBtn = new JButton("Send");
		txtArea = new JTextArea();
		txtArea.setEditable(false);
		txtArea.setLineWrap(true);
		scp = new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// Borders for panels
		Border mainBorder = BorderFactory.createEtchedBorder();
		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border inner = BorderFactory.createTitledBorder("Message");

		panel.setBorder(mainBorder);
		msgPanel.setBorder(BorderFactory.createCompoundBorder(outer, inner));
	}

	private void layoutAll() {

		msgPanel.add(msgField);
		msgPanel.add(sndBtn);
		panel.add(scp, BorderLayout.CENTER);
		panel.add(msgPanel, BorderLayout.SOUTH);
		this.setLayout(new BorderLayout());
		this.add(panel);
	}

	public void writeReceivedMessage(String msg) {
		txtArea.append(msg);
		txtArea.append("\n");
	}

	public void activateChat() {

		sndBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				msg = msgField.getText();
				pwr.println(msg);
				pwr.flush();
				msgField.setText("");
				msgField.requestFocus();

			}
		});

	}

	public String getMessage() {

		return msg;
	}

	public void setPrintWriter(PrintWriter writer) {
		this.pwr = writer;
	}

	public void writeTxt(String string) {
		txtArea.append("******************************************\n");
		txtArea.append(string);
		txtArea.append("\n");
		txtArea.append("******************************************\n");
	}

}