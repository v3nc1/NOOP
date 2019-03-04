package zd01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static ServerSocket serSocket;

	public static void main(String[] args) throws IOException {

		String msg;

		serSocket = new ServerSocket();
		// Bind it with desired IP address and port
		serSocket.bind(new InetSocketAddress("127.0.0.1", 53000));
		// Check if server is running
		System.out.println("Server is running --> port: " + serSocket.getLocalPort());

		// Create object for accepting client request
		Socket clientReq = serSocket.accept();
		// Check client connection  
		String hostAddress = clientReq.getInetAddress().getHostAddress();
		System.out.println("New connection from the host" + hostAddress);

		// Create i/o streams
		InputStreamReader inStrRdr = new InputStreamReader(clientReq.getInputStream());
		// Buffering all from client side
		BufferedReader bfrInpt = new BufferedReader(inStrRdr);
		PrintWriter writerOut = new PrintWriter(clientReq.getOutputStream());
		while ((msg = bfrInpt.readLine()) != null) {
			System.out.println("\r\nMessage from -> " + clientReq.getInetAddress() + " : " + msg);
			// Echoing that message to the client
			writerOut.println(msg);
			writerOut.flush();
		}

	}

}