
public class Author {
	
	private static int cnt;
	private String name;
	private int id;
	

	public Author(String name) {
		cnt++;
		this.name=name;
		id=cnt;
	}


	public String getName() {
		return name;
	}

	
	
	
}
