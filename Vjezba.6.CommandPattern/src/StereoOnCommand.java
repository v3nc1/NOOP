
public class StereoOnCommand implements ICommand {
	
	Stereo stereo;
	
	

	public StereoOnCommand(Stereo stereo) {
		
		this.stereo = stereo;
	}
	
	

	@Override
	public void execute() {
		
		stereo.on();
		stereo.cdIn();
		stereo.volume();
		

	}

	@Override
	public void undo() {
		
		stereo.off();
		stereo.cdEject();
		stereo.volumeOff();

	}

}
