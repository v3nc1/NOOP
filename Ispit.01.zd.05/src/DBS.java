import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;

public class DBS {
	
	private ArrayList<Book> books;
	private HashSet<Author> auth;
	

	public DBS() {
		// TODO Auto-generated constructor stub
	}
	
	public void addAllBooks(ArrayList<Book> lista) {
		
		books=lista;
		
	}
	
	public void addAllAuthors(HashSet<Author> lista) {
		
		auth=lista;
		
	}
	
	public void searchBooksAuthor(Author author) {
		
		float price=0;
		
		for (Book b:books) {
			
			if(author.getName()==b.getAuthor().getName()) {
				
				price+=b.getPrice();
				System.out.println("_________________________");
				System.out.println("Author: "+b.getAuthor().getName());
				System.out.println("Book title: "+ b.getTitle());
				
			}
			
			
		}
		System.out.println("Total prices for books collection: "+ price);
		
		
		
		
	}

}
