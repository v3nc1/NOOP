import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class Robot extends TopEntity implements Cognitive{
	
	private Set<Integer> st2;
	private Set<Integer> guess;
	
	


	public Robot(String name, int id) {
		
		super(name,id);
	
		
		
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

	@Override
	public int playGuess(Set<Integer> nr) {
		
		Set<Integer> guessSet=new HashSet<>();
		Set<Integer> isti=new HashSet<>();
		
		
		do  {
			guessSet.add(ThreadLocalRandom.current().nextInt(1,40));
		
		}while(guessSet.size()!=8);
		System.out.println("************ROBOT*************");
		System.out.println("ulazni: "+nr);
		System.out.println("sluèajni: "+guessSet);
		for(int inList:nr) {
			
			for(int robotList:guessSet) {
				
				if(robotList==inList) {
					
					isti.add(robotList);
				}
				
			}
			
			
		}
		System.out.println("isti : "+isti);
		System.out.println("Broj pogodaka: "+isti.size());
		think(nr);
		
		
		return 0;
	}

	@Override
	public void think(Set<Integer> nr) {
		
		Set<Integer> sortiran=new TreeSet<>();
		
		for(int inList:nr) {

			sortiran.add(inList);
			
			}
		
		System.out.println("Uzlazno sortiran: "+sortiran);
		
	}

}
