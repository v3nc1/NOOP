package zd01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client_app {

	private static Scanner sc;
	

	public static void main(String[] args) throws UnknownHostException, IOException {

		
		sc = new Scanner(System.in);
		String input;
		boolean flag = true;
		int cnt = 1;

		// make a object for client requests to the particular server
		Socket client = new Socket("127.0.0.1", 53000);

		// Create i/o streams
		InputStreamReader inStrRdr = new InputStreamReader(client.getInputStream());
		BufferedReader bfrInpRdr = new BufferedReader(inStrRdr);
		PrintWriter out = new PrintWriter(client.getOutputStream(), true);

		// Check connection to the server
		System.out.println("Connection established -->> " + client.isConnected());

		while (flag) {
			
			
			System.out.println("Please enter your message...");
			input = sc.nextLine();
			out.println(input);
			String echo = bfrInpRdr.readLine();
			System.out.println("Received echo from the server: " + echo);
			System.out.println("----------------------------------------------\n");
			out.flush();

			// Counting for disconnection
			cnt += 1;
			if (cnt > 5) {
				flag = false;
			} else {
				flag = true;
			}

		}

		client.close();
		System.out.println("Client closed connection....");
		System.out.println("Client is closed? -->> " + client.isClosed());

	}

}