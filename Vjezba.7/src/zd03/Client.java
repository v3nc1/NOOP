package zd03;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	private final int ServerPort = 25000;
	private ClientFrame clFrame;
	private BufferedReader bfr;
	private InputStreamReader isr;
	private PrintWriter pwr;
	private Socket con;

	public Client() {

		clFrame = new ClientFrame();

	}

	public void go() throws UnknownHostException, IOException {
		setUpNetworking();
	}

	private void setUpNetworking() throws UnknownHostException, IOException {

		// getting ip address of the server --> here localhost
		InetAddress ip = InetAddress.getByName("localhost");

		con = new Socket(ip, ServerPort);

		// i/o streams for communication
		isr = new InputStreamReader(con.getInputStream());
		bfr = new BufferedReader(isr);
		pwr = new PrintWriter(con.getOutputStream());
		clFrame.writeTxt("Connection is established...");
		Thread recMsgThr = new Thread(new ReceiveMsgJob());

		clFrame.setPrintWriter(pwr);
		recMsgThr.start();
	}


	private class ReceiveMsgJob implements Runnable {

		@Override
		public void run() {
			String msg;
			while (true) {
				try {
					
					while ((msg = bfr.readLine()) != null) {
						clFrame.writeReceivedMessage(msg);
					}

				} catch (IOException ex) {
					ex.printStackTrace();
				}

			}

		}

	}
}