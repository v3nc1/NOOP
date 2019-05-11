package gui;
import java.util.EventListener;

public interface FormListener extends EventListener {
	
	public void leftPanelEventOccured(LeftFormEvent lfe);
	public void rightPanelEventOccured(RightFormEvent rfe);
	

}
