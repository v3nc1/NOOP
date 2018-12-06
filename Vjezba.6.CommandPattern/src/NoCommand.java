
public class NoCommand implements ICommand {

	@Override
	public void execute() {
		System.out.println("Empty");

	}

	@Override
	public void undo() {
		System.out.println("Empty");

	}

}
