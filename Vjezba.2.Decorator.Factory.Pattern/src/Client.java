
public class Client {

	public static void main(String[] args) {
		
		
		WebBrowser web=new WebBrowser();
		String[] ext= {"pdf","doc","ppt"};
		
		
		for(int i=0;i<4;i++) {
			
			System.out.println("*******************");
			
			web.fetchDocument(ext[ThreadLocalRandom.current().nextInt(0,3)]);
			web.openDocument();
			web.saveDocument();
			web.closeDocument();
		}
		
		
	}

}
