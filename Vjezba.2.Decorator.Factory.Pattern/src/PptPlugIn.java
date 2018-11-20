
public class PptPlugIn extends WebBrowser {
	
	AbsDocument absDoc;

	public PptPlugIn() {
		
		absDoc = new Ppt();
	}

	@Override
	public void saveDocument() {
		
		absDoc.save();
		
	}

	public AbsDocument getAbsDoc() {
		return absDoc;
	}
	

}
