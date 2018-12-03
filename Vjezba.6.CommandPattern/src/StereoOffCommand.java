
public class StereoOffCommand implements ICommand {
	
	Stereo stereo;

	public StereoOffCommand(Stereo stereo) {
		
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		
		stereo.off();
		stereo.cdEject();
		stereo.volumeOff();

	}

	@Override
	public void undo() {
		
		stereo.on();
		stereo.cdIn();
		stereo.volume();

	}

}
