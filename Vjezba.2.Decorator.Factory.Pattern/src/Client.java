
public class Client {

	public static void main(String[] args) {
		
		
		WebBrowser web=new WebBrowser();
		
		System.out.println("*******************");
		web.fetchDocument("pdf");
		web.openDocument();
		web.saveDocument();
		web.closeDocument();
		
		System.out.println("*******************");

		web.fetchDocument("doc");
		web.openDocument();
		web.saveDocument();
		web.closeDocument();

	}

}
