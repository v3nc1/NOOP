
public class DocPlugIn extends WebBrowser {
	
	AbsDocument absDoc;

	public DocPlugIn() {
		
		absDoc = new Doc();
	}

	@Override
	public void saveDocument() {
		
		absDoc.save();
		
	}

	public AbsDocument getAbsDoc() {
		return absDoc;
	}
	
	
	
	

}
