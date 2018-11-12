
public class MacGUIFactory implements GUIFactory {
	
	

	@Override
	public Button createButton() {
		
		MacBtn mBtn=new MacBtn();
		
		return mBtn;
	}

	@Override
	public Checkbox createCheckBox() {
		
		MacChckBox mChk=new MacChckBox();
		return mChk;
	}

}
