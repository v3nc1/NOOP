import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Person extends TopEntity implements Cognitive {
	
	private int num;
	private ArrayList<Integer> lst;

	public Person(String name, int id) {
		super(name, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int playGuess(Set<Integer> nr) {
		
		ArrayList<Integer> tryGuess=new ArrayList<>();
		int guess;
		int wanted=nr.iterator().next();
		
		System.out.println("***********Person***********");
		
		
		do {
			guess=ThreadLocalRandom.current().nextInt(1,40);
			
			tryGuess.add(guess);
		
		
		}while(wanted!=guess);
		
		System.out.println("Svi generirani do pogotka: "+tryGuess);
		System.out.println("Broj pokušaja: "+ tryGuess.size());
		think(nr);
		
		
		return 0;
	}

	@Override
	public void think(Set<Integer> nr) {
		
		int max=0;
		
		for(int br:nr) {
			
			if(br>max) {
				max=br;
			}
			
		}
		System.out.println(nr);
		System.out.println("Max is: "+max);
		// TODO Auto-generated method stub

	}

	@Override
	public LocalDate genDOB() {

		LocalDate startDate = LocalDate.of(1980, 1, 1); // start date
		long start = startDate.toEpochDay();
		LocalDate endDate = LocalDate.now();
		long end = endDate.toEpochDay();

		long randomEpochDay = ThreadLocalRandom.current().longs(start,end).findAny().getAsLong();
		DOB = LocalDate.ofEpochDay(randomEpochDay); // random date between start and end

		return DOB;
		
	}

}
