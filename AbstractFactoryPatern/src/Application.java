
public class Application {
	
	private GUIFactory guiF;
	private Checkbox chk;
	private Button btn;
	
	
	public Application(GUIFactory guiF) {
		
		
		this.guiF=guiF;
		
	}
	
	public void createUI() {
		
		btn=guiF.createButton();
		chk=guiF.createCheckBox();
			
			
		
	}
	
	public void paint() {
		
		
		chk.paint();
		btn.paint();
		
		
		
	}
	
	

}
