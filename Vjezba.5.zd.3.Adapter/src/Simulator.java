
public class Simulator {

	public static void main(String[] args) {
		
		Raketa fxr=new NewModelFXR();
		Raketa rpg=new RaketniAdapter(new RuskiPonosGorbachov());
		
		System.out.println("#############");
		
		fxr.zagrijavanjeMotora();
		fxr.startMotora();
		fxr.odvojiModul();
		
		System.out.println("#############");
		
		
		rpg.zagrijavanjeMotora();
		rpg.startMotora();
		rpg.odvojiModul();
		
		

	}

}
