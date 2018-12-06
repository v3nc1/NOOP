
public interface AbsWebBrowser {
	
	public void openDocument(AbsDocument absDoc);
	
	public void closeDocument();
	
	public void saveDocument(AbsDocument absDoc);
	
	public AbsDocument fetchDocument(String url);

}
