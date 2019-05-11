import java.util.Arrays;

public class App {

	public static void main(String[] args) {

		Generator gen=new Generator();
		Answer ans=new Answer();
		
		gen.ispisListe();
		System.out.println("Uzlazno sortirana lista:");
		System.out.println(Arrays.toString(ans.sortAscList(gen.getLista())));
		System.out.println("Silazno sortirana lista:");
		System.out.println(Arrays.toString(ans.sortDescList(gen.getLista())));
		System.out.println("AVG:");
		System.out.println(ans.calcAvgList(gen.getLista()));

	}

}
