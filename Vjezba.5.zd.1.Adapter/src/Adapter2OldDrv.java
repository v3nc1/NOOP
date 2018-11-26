
public class Adapter2OldDrv implements Ploter{
	
	private OldDriver old;
	
	

	public Adapter2OldDrv(OldDriver old) {
		
		this.old =  old;
	}

	@Override
	public void ispisGrafike() {
		
		
			old.plotGraphics();
			
	
		
	}
	
	

}
