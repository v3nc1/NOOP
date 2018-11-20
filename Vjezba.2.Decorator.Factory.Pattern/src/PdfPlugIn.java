
public class PdfPlugIn extends WebBrowser {
	
	
	AbsDocument absDoc;

	public PdfPlugIn() {
		
		absDoc = new Pdf();
	}

	@Override
	public void saveDocument() {
		
		absDoc.save();
		
	}

	public AbsDocument getAbsDoc() {
		return absDoc;
	}
	
	
}
