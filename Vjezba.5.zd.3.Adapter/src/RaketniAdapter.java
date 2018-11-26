
public class RaketniAdapter implements Raketa {
	
	RuskiPonosGorbachov rpg;

	public RaketniAdapter(RuskiPonosGorbachov rpg) {
		
		this.rpg=rpg;
		
	}
	
	
	
	@Override
	public void zagrijavanjeMotora() {
		
		rpg.inicMotora();
		rpg.zagrijavanjeMotora();
		rpg.uputaMotora();

	}

	@Override
	public void startMotora() {
		rpg.motor1pali();
		rpg.motor2pali();
		rpg.motor3pali();

	}

	@Override
	public void odvojiModul() {
		rpg.odvajanjeModula1();
		rpg.odvajanjeModula2();
		rpg.paliPomocniSustav();

	}

}
