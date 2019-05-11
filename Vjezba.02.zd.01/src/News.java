import java.util.ArrayList;

public class News implements ObservablePublisher {
	
	public ArrayList<ObserversSubscribers> obs= new ArrayList<>();
	private String volName;
	private int volNr;
	

	public News(String name) {
		
		volName=name;
		volNr=1;
		
	}

	@Override
	public void add(ObserversSubscribers obs) {
		
		this.obs.add(obs);

	}

	@Override
	public void remove(ObserversSubscribers obs) {

		this.obs.remove(obs);

	}

	@Override
	public void notifyThem() {
		mainLogic();
		volNr++;

	}

	@Override
	public void mainLogic() {
		
		for(ObserversSubscribers ob:obs) {
			
			ob.update(volName+volNr);
		}

	}

}
