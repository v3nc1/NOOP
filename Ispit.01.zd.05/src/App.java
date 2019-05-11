import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class App {

	public App() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		ArrayList<Book> bookList=new ArrayList<>();
		HashSet<Author> authSet=new HashSet<>();
		
		//Dodavanje autora
		for(int i=0;i<5;i++) {
			
			Author aut=new Author("Author "+(i+1));	
			authSet.add(aut);
		}
		//Dodavanje knjiga
		for(int i=0;i<10;i++) {
			
			Book bk=new Book("Title "+(i+1));
			bk.setAuthor(authSet);
			bookList.add(bk);
		}
		
		DBS baza=new DBS();
		
		baza.addAllAuthors(authSet);
		baza.addAllBooks(bookList);
		
		for(Author a:authSet) {
			
			if(a.getName().equals("Author 3")) {
				baza.searchBooksAuthor(a);
			}
		}
		
		/*
		
		for(Author a: authSet) {
			
			System.out.println(a.getName());
		}
		
		for(Book b:bookList) {
			
			System.out.println(b.getTitle());
			System.out.println(b.getAuthor().getName());
			System.out.println("__________________________");
		}*/
	}

}
