import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Client {

	public static void main(String[] args) {
		
		
		WebBrowser web=new WebBrowser();
		//AbsDocument file;
		
		String[] ext= {"pdf","doc","ppt"};
		
		
		for(int i=0;i<4;i++) {
			
			System.out.println("*******************");
			
			//file=web.fetchDocument(ext[ThreadLocalRandom.current().nextInt(0,3)]);
			web.runBrowser(web.fetchDocument(ext[ThreadLocalRandom.current().nextInt(0,3)]));
		}
		
		

	}

}
