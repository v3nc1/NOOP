
public class AirCondSysFacade {

	private SubSystem_1 ss1;
	private SubSystem_2 ss2;
	private SubSystem_3 ss3;
	private SubSystemEnergy ssE;
	private SubSystemTimer ssT;
	
	

	public AirCondSysFacade(SubSystem_1 ss1, SubSystem_2 ss2, SubSystem_3 ss3, SubSystemEnergy ssE,
			SubSystemTimer ssT) {
		
		this.ss1 = ss1;
		this.ss2 = ss2;
		this.ss3 = ss3;
		this.ssE = ssE;
		this.ssT = ssT;
	}


	public void startAirconditioningSystem() {

		ss1.setMode("TURBO");
		ss2.setTemperature(24);
		ss2.fanSpeed(4);
		ss3.turnIonizer(true);
		ssE.on();
		ssE.mode("MEDIUM");
		ssE.start();
		ssT.program(2);
		ssT.on(true);

	}

	public void stopAirconditioningSystem() {

		ss1.setMode("OFF");
		ss2.setTemperature(0);
		ss2.fanSpeed(0);
		ss3.turnIonizer(false);
		ssE.off();
		ssE.mode("OFF");
		ssE.stop();
		ssT.program(0);
		ssT.on(false);

	}

	public void setSs1(SubSystem_1 ss1) {
		this.ss1 = ss1;
	}
	
	public void setSs2(SubSystem_2 ss2) {
		this.ss2 = ss2;
	}
	
	public void setSs3(SubSystem_3 ss3) {
		this.ss3 = ss3;
	}
	
	public void setSsE(SubSystemEnergy ssE) {
		this.ssE = ssE;
	}
	
	public void setSsT(SubSystemTimer ssT) {
		this.ssT = ssT;
	}
	
}
