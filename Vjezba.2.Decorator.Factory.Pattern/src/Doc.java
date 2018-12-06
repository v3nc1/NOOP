
public class Doc extends AbsDocument {
	
	
	@Override
	public void open() {
		
		System.out.println("... *.doc document...");
	}

	@Override
	public void save() {
		
		System.out.println("Saving *.doc document...");
	}

}
