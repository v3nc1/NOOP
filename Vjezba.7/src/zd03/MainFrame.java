package zd03;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class MainFrame extends JFrame {

	private JPanel panel;
	private JTextArea txtArea;
	private JScrollPane scp;

	public MainFrame() {

		this.setTitle("Chat Server");
		this.setLayout(new BorderLayout());
		initializeComps();
		layoutComps();
		this.add(panel, BorderLayout.CENTER);
		this.setSize(500, 650);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}

	private void initializeComps() {

		panel = new JPanel();
		txtArea = new JTextArea();
		txtArea.setEditable(false);
		scp = new JScrollPane(txtArea);
		scp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border inner = BorderFactory.createTitledBorder("Clients on servers' side");
		Border cmpBrd = BorderFactory.createCompoundBorder(outer, inner);
		panel.setBorder(cmpBrd);

	}

	private void layoutComps() {

		panel.setLayout(new BorderLayout());
		panel.add(scp, BorderLayout.CENTER);
	}

	public void write2TxtAr(String msg, String name) {

		txtArea.append("------------------------------------------------\n");
		txtArea.append("Received message -->> ...\n");
		txtArea.append(name + ":" + msg);
		txtArea.append("\n");

	}

	public void writeServerState(String msg) {

		txtArea.append("*************************************************\n");
		txtArea.append("Server: " + msg);
		txtArea.append("\n");
		txtArea.append("*************************************************\n");
		txtArea.append("\n");

	}

}