
public class Client {

	public static void main(String[] args) {

		SubSystem_1 ss1 = new SubSystem_1();
		SubSystem_2 ss2 = new SubSystem_2();
		SubSystem_3 ss3 = new SubSystem_3();
		SubSystemEnergy ssE = new SubSystemEnergy();
		SubSystemTimer ssT = new SubSystemTimer();

		AirCondSysFacade sys = new AirCondSysFacade(ss1,ss2,ss3,ssE,ssT);

		System.out.println("\n###########################");

		sys.startAirconditioningSystem();

		System.out.println("\n########################");

		sys.stopAirconditioningSystem();

	}

}
