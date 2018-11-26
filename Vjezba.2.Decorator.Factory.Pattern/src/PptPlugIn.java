
public class PptPlugIn extends WebBrowser {
	
	AbsDocument absDoc;

	public PptPlugIn() {
		
		absDoc = new Ppt();
	}

	

	public AbsDocument getAbsDoc() {
		return absDoc;
	}
	

}
