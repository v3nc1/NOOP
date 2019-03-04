package zd03;

import java.io.IOException;
import java.net.UnknownHostException;

public class ClientApp {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Client client_1 = new Client();
		Client client_2 = new Client();
		Client client_3 = new Client();
		client_1.go();
		client_2.go();
		client_3.go();

	}

}