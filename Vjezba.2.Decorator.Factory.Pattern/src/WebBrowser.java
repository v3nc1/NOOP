
public class WebBrowser implements AbsWebBrowser {

	public void runBrowser(AbsDocument absDoc) {
		
		openDocument(absDoc);
		saveDocument(absDoc);
		closeDocument();
	}
	

	@Override
	public void openDocument(AbsDocument absDoc) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		System.out.println("Opening document ...");
		absDoc.open();
	}

	@Override
	public void closeDocument() {
		System.out.println("Closing document ...");
		//absDoc.close();

	}

	@Override
	public void saveDocument(AbsDocument absDoc) {
		absDoc.save();

	}

	@Override
	public AbsDocument fetchDocument(String url) {

		System.out.println("Fetching document from a web server ...");

		switch (url) {
		case "doc":

			DocPlugIn doc = new DocPlugIn();
			
			return doc.getAbsDoc();
			
			//break;
		case "pdf":

			PdfPlugIn pdf = new PdfPlugIn();
			return pdf.getAbsDoc();
			
			//break;
		case "ppt":

			PptPlugIn ppt = new PptPlugIn();
			return ppt.getAbsDoc();
			
			//break;
		default:
			break;
		}

		return null;
	}

}
