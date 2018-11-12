
public class WinGUIFactory implements GUIFactory {


	@Override
	public Button createButton() {
		
		WinBtn wBtn=new WinBtn();
		return wBtn;
	}

	@Override
	public Checkbox createCheckBox() {
		
		WinChckBox wChk=new WinChckBox();
		return wChk;
	}

}
