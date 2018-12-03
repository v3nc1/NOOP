
public class Client {

	public static void main(String[] args) {
		
		//Invoker
		RemoteControl remote = new RemoteControl();
		
		//Recivers
		Light light = new Light();
		GarageDoor garageDoor = new GarageDoor();
		Stereo stereo = new Stereo();
		
		//Command objects On--> for On buttons
		LightOnCommand lghtOnCmd = new LightOnCommand(light);
		GarageOpenCommand garageOpenCmd = new GarageOpenCommand(garageDoor);
		StereoOnCommand stereoOnCmd = new StereoOnCommand(stereo);

		//Command objects Off--> for Off buttons
		LightOffCommand lghtOffCmd = new LightOffCommand(light);
		GarageCloseCommand garageCloseCmd = new GarageCloseCommand(garageDoor);
		StereoOffCommand stereoOffCmd = new StereoOffCommand(stereo);

		//Programing buttons
		remote.setCommand(0, lghtOnCmd, lghtOffCmd);
		remote.setCommand(1, garageOpenCmd, garageCloseCmd);
		remote.setCommand(2, stereoOnCmd, stereoOffCmd);
		
		//Listing programed buttons
		System.out.println(remote.toString());
		
		//Button pressed simulation
		for(int i=0;i<7;i++) {
			
			System.out.println("++++ SLOT " +  i + " +++++");
			remote.buttonOnPressed(i);
			remote.buttonOffPressed(i);
		}
		
		//Testing undo button
		System.out.println("++++ testing undo +++++");

		remote.buttonOnPressed(1);
		
		remote.buttonUndoPressed();

		// remote.buttonOnPressed();

	}

}
