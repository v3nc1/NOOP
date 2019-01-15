package zadatak1;

public class Apartment {
	
	private String location;
	private String category;
	private Categorize categorize;
	
	
	public Apartment(String loc,String cat) {
		
		categorize=new Categorize();
		location=loc;
		category=cat;
		
	}
	
	public void description() {
		
		System.out.println(location);
		
	}
	
	public void categorize(String cat) {
		
		categorize.categorize(cat);
		
	}

}
