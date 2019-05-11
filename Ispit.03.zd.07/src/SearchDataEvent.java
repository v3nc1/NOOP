import java.util.ArrayList;
import java.util.EventObject;

public class SearchDataEvent extends EventObject {
	
	private ArrayList<Djelatnik> bazaDj;
	
	public SearchDataEvent(Object ob) {
		
		super(ob);
		
		
	}

	public ArrayList<Djelatnik> getBazaDj() {
		return bazaDj;
	}

	public void setBazaDj(ArrayList<Djelatnik> bazaDj) {
		this.bazaDj = bazaDj;
	}
	
	

}
