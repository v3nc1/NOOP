import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Book {
	
	private String title;
	private int id;
	private float price;
	private Author aut;
	

	public Book(String title) {
		this.title=title;
		id=ThreadLocalRandom.current().nextInt(1,1001);
		price=new Random().nextFloat()*(1000-80)+80;
		
		
		
	}
	
	public void setAuthor(HashSet<Author> lista) {
		
		int i=0;
		int x=ThreadLocalRandom.current().nextInt(1,lista.size());
		
		for(Author a:lista) {
			
			i++;
			if(i==x) {
				aut=a;
				
			}
			
			
		}
		
	}
	
	public Author getAuthor() {
		
		return aut;
		
	}
	
	public float getPrice() {
		
		return price;
	}
	
	public String getTitle() {
		
		return title;
	}

}
