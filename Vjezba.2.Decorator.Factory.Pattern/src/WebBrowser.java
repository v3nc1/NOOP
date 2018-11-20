
public class WebBrowser implements AbsWebBrowser {

	private static AbsDocument absDoc;
	

	@Override
	public void openDocument() {

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
		absDoc.close();

	}

	@Override
	public void saveDocument() {
		absDoc.save();

	}

	@Override
	public AbsDocument fetchDocument(String url) {

		System.out.println("Fetching document from a web server ...");

		switch (url) {
		case "doc":

			DocPlugIn doc = new DocPlugIn();
			
			absDoc=doc.getAbsDoc();
			
			break;
		case "pdf":

			PdfPlugIn pdf = new PdfPlugIn();
			absDoc=pdf.getAbsDoc();
			
			break;
		case "ppt":

			PptPlugIn ppt = new PptPlugIn();
			absDoc=ppt.getAbsDoc();
			
			break;
		default:
			break;
		}

		return absDoc;
	}

}
