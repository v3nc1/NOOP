package zd02;

import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {
		
		DailyQuotesServer quoteServer=new DailyQuotesServer();
		quoteServer.go();
		
		
	}

}
