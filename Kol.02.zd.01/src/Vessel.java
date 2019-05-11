
public class Vessel {
	
	private String vessType;
	private String vessName;
	private int ageCat;
	
	public Vessel(String vessType, String vessName, int ageCat) {
		
		this.vessType=vessType;
		this.vessName=vessName;
		this.ageCat=ageCat;
		
	}

	public String getVessType() {
		return vessType;
	}

	public String getVessName() {
		return vessName;
	}

	public int getAgeCat() {
		return ageCat;
	}
	
	public String toString() {
		
		return "///////// Vessel //////////\n"+"Name: "+ vessName+" -> type: "+ vessType+" -> age category: "+ ageCat+"\n";
	}
	
	
}
