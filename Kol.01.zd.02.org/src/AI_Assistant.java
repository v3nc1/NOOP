import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class AI_Assistant extends TopEntity implements Cognitive {
	
	private Set<Integer> st2;
	private Set<Integer> guess;
	

	public AI_Assistant(String name, int id) {
		super(name, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int playGuess(Set<Integer> nr) {


		Set<Integer> guessSet=new HashSet<>();
		Set<Integer> razlika=new HashSet<>();
		boolean ima;
		
		int brRazlika=0;
		
		do  {
			guessSet.add(ThreadLocalRandom.current().nextInt(1,40));
		
		}while(guessSet.size()!=8);
		
		razlika.addAll(guessSet);
		
		System.out.println("************AI_Assistant*************");
		System.out.println("ulazni: "+nr);
		System.out.println("sluèajni: "+guessSet);
		for(int aiList:guessSet) {
			ima=false;
			
			for(int inList:nr) {
				
				if(aiList==inList) {
					
					ima=true;
				}
				
			}
			if(ima) {
				
				razlika.remove(aiList);
			}
			
			
		}
		System.out.println("unique : "+razlika);
		System.out.println("unique: "+razlika.size());
		think(nr);
		
		return 0;
	}

	@Override
	public void think(Set<Integer> nr) {

		TreeSet<Integer> sortiran=new TreeSet<>();
		//TreeSet<Integer> reverse=new TreeSet<>();
		
		for(int inList:nr) {

			sortiran.add(inList);
			
			}
		//reverse=(TreeSet)sortiran.descendingSet(); 
		
		System.out.println("Uzlazno sortiran: "+sortiran.descendingSet());

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
