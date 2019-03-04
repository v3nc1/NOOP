package zd02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client_app{

	

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		ClientFrame client=new ClientFrame("ClientApp");
		client.runConnection();
		

		
	}
	
	

	

}