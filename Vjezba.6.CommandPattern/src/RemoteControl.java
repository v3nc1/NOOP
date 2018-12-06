
public class RemoteControl {

	ICommand[] cmdOn;
	ICommand[] cmdOff;
	ICommand nc=new NoCommand();
	ICommand undo;
	int slot;
	boolean[] flag;
	
	
	
	

	public RemoteControl() {
		
		cmdOn = new ICommand[7];
		
		cmdOff =new ICommand[7];
		
		flag=new boolean[7];
		
		undo=nc;
		
		for(int i=0; i<cmdOn.length ;i++) {
			
			cmdOn[i]=nc;
			cmdOff[i]=nc;
			flag[i]=false;
			
		}
	}

	public void setCommand(int slot,ICommand cmdOn, ICommand cmdOff) {

		this.cmdOn[slot]=cmdOn;
		this.cmdOff[slot]=cmdOff;
		

	}

	public void buttonOnPressed(int slot) {

		cmdOn[slot].execute();
		undo=cmdOn[slot];
		flag[slot]=true;

	}

	public void buttonOffPressed(int slot) {

		cmdOff[slot].execute();
		undo=cmdOff[slot];
		flag[slot]=false;

	}
	
	public void buttonUndoPressed() {
		
		undo.undo();
		
	}
	
	
	@Override
	public String toString() {
		
		StringBuffer sBuff=new StringBuffer();
		
		sBuff.append("\n +++++++++ Remote controller +++++++++\n");
		for (int i=0; i<cmdOn.length;i++) {
			
			sBuff.append("[slot "+ i + " ]" + cmdOn[i].getClass().getName() + "\t\t"+ cmdOff[i].getClass().getName() + "\n");
			
		}
		
		
		return sBuff.toString();
	}
	
	

}
