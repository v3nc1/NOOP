
public class GarageCloseCommand implements ICommand {

	GarageDoor door;
	
	
	public GarageCloseCommand(GarageDoor door) {
		
		this.door = door;
	}

	@Override
	public void execute() {

		door.closeDoor();
		door.lightOff();

	}

	@Override
	public void undo() {

		door.openDoor();
		door.lightOn();
		door.stop();
	}


}
