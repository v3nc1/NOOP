
public class GarageOpenCommand implements ICommand {

	GarageDoor door;
	
	
	public GarageOpenCommand(GarageDoor door) {
		
		this.door = door;
	}

	@Override
	public void execute() {

		door.openDoor();
		door.lightOn();
		door.stop();

	}

	@Override
	public void undo() {
		door.closeDoor();
		door.lightOff();

	}

}
