import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {

		//Informations.start();
		
		int[] gset= {23,4,11,5,35,21,2};
		Set<Integer> guessList=new HashSet<>();
		Robot rb=new Robot("T2000", 39);
		AI_Assistant ai=new AI_Assistant("Hal", 10);
		Person co=new Person("Ðuro", 1);
		
		guessList=Arrays.stream(gset).boxed().collect(Collectors.toSet());
		
		/*do  {		
			guessList.add(ThreadLocalRandom.current().nextInt(1,39));
		}while(guessList.size()!=8);
		*/
		
		
		rb.playGuess(guessList);
		ai.playGuess(guessList);
		co.playGuess(guessList);
		
		
		//Informations.stop();

	}

}
