import java.io.IOException;
import java.util.Arrays;

public class App {

	public static void main(String[] args) throws IOException {
		
		
		int br=0;
		
		Reader.ReadCSV();
		String[][] grades=Reader.gen2DArr();
		System.out.println("\n \n");
		for (String[] sta:grades) {
			
			System.out.println(Arrays.toString(sta));
		}
		
		Calculation.avgSems(grades);
		
		
		
		
		
		
		
		
	}

}
