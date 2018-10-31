
public interface ObservedInt {
	
	public void add(ObserverWth ob);
	
	public void remove(ObserverWth ob);
	
	public void notifyObs(float temp,float hum,float press);

}
