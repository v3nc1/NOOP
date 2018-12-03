
public class Client {

	public static void main(String[] args) {

		RemoteControl remote = new RemoteControl();

		Light light = new Light();
		GarageDoor garageDoor = new GarageDoor();
		Stereo stereo = new Stereo();

		LightOnCommand lghtOnCmd = new LightOnCommand(light);
		LightOffCommand lghtOffCmd = new LightOffCommand(light);

		GarageOpenCommand garageOpenCmd = new GarageOpenCommand(garageDoor);
		GarageCloseCommand garageCloseCmd = new GarageCloseCommand(garageDoor);

		StereoOnCommand stereoOnCmd = new StereoOnCommand(stereo);
		StereoOffCommand stereoOffCmd = new StereoOffCommand(stereo);

		remote.setCommand(0, lghtOnCmd, lghtOffCmd);
		remote.setCommand(1, garageOpenCmd, garageCloseCmd);
		remote.setCommand(2, stereoOnCmd, stereoOffCmd);

		System.out.println(remote.toString());

		for(int i=0;i<7;i++) {
			
			System.out.println("++++ SLOT " +  i + " +++++");
			remote.buttonOnPressed(i);
			remote.buttonOffPressed(i);
		}

		System.out.println("++++ testing undo +++++");

		remote.buttonOnPressed(1);
		
		remote.buttonUndoPressed();

		// remote.buttonOnPressed();

	}

}
