package zd03;
import java.io.IOException;
import java.util.Set;

public class AppServer {

	public static void main(String[] args) throws IOException {

		ChatServer server = new ChatServer();
		server.go();

	}
}