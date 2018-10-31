
public interface ObservableInt {
	
	public void add(Observer obs);
	
	public void remove(Observer obs);
	
	public void notifyObs();

}
