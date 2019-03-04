package zd03;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;

public class ChatServer {

	private Vector<ClientHandler> clList;
	private MainFrame mnFrame;
	private int cnt = 1;
	private ServerSocket serSckt;

	// Constructor
	public ChatServer() {

		mnFrame = new MainFrame();
		clList = new Vector<>();

	}

	// method for starting the server
	public void go() throws IOException {
		setUpNtwrk();
	}

	// networking and socket communication
	private void setUpNtwrk() throws IOException {

		serSckt = new ServerSocket(25000);
		mnFrame.writeServerState("Server is running ...");

		// Ensure socket for clients' requests
		Socket clSckt;

		// server is waiting for a new client request - infinite loop
		while (true) {

			// Accept the incoming request from the client
			clSckt = serSckt.accept();

			System.out.println(" --------------------------------------------------------------------- ");
			System.out.println("New client request received: " + clSckt);

			// i/o streams for socket communication
			InputStreamReader dtInptStr = new InputStreamReader(clSckt.getInputStream());
			PrintWriter writer = new PrintWriter(clSckt.getOutputStream());

			System.out.println("Creating a new handler for this client...");
			// Create a new object for clients handling
			String name = "Client_" + cnt;
			ClientHandler clHndl = new ClientHandler(name, dtInptStr, writer);
			System.out.println(clHndl);

			System.out.println("Add this client to the active clients list...");

			// adding to the vector
			clList.add(clHndl);

			// Create the thread for the client
			Thread thr = new Thread(clHndl);

			// start the thread
			thr.start();

			// increment counter for the next client
			cnt++;
			}

		}

	

	// Inner class for handling clients
	public class ClientHandler implements Runnable {

		private BufferedReader bfrInptRdr;
		private PrintWriter writer;
		private String name;

		// constructor
		public ClientHandler(String name, InputStreamReader isr, PrintWriter wrt) {
			bfrInptRdr = new BufferedReader(isr);
			writer = wrt;
			this.name = name;
			System.out.println("Input stream: " + bfrInptRdr);
			System.out.println("Output stream: " + writer);
			System.out.println("Name: " + name);
		}

		@Override
		public void run() {
			String msg;
			// Check if msg is send from client to the server
			try {
				while ((msg = bfrInptRdr.readLine()) != null) {
					mnFrame.write2TxtAr(msg, name);
					send2All(msg, name);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		private PrintWriter getOutputWriter() {
			return writer;
		}

		private String getName() {
			return name;
		}
	}

	public void send2All(String msg, String name) {
		// send message to the all clients
		Iterator<ClientHandler> it = clList.iterator();
		while (it.hasNext()) {
			ClientHandler clh = it.next();
			PrintWriter prw = clh.getOutputWriter();
			prw.println(name + ": " + msg);
			prw.flush();
		}
	}
}
