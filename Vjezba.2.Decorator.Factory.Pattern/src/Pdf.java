
public class Pdf extends AbsDocument {

	@Override
	public void open() {
		
		System.out.println("... *.pdf document...");
	}

	@Override
	public void save() {
		
		System.out.println("Saving *.pdf document...");
	}

}
