
public class PdfPlugIn extends WebBrowser {
	
	
	AbsDocument absDoc;

	public PdfPlugIn() {
		
		absDoc = new Pdf();
	}

	

	public AbsDocument getAbsDoc() {
		return absDoc;
	}
	
	
}
