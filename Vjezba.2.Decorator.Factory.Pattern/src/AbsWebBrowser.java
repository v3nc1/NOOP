
public interface AbsWebBrowser {
	
	public void openDocument();
	
	public void closeDocument();
	
	public void saveDocument();
	
	public AbsDocument fetchDocument(String url);

}
