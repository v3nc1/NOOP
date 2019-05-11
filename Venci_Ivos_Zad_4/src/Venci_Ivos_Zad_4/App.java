package Venci_Ivos_Zad_4;

import java.util.Arrays;

public class App {
	
	static String[][] automobilData=new String[6][];
	static String[][] cijeneData=new String[6][];

	public static void main(String[] args) {


		cijeneData=CSVReader.readCSV(".\\cijeneServis.csv");
		automobilData=CSVReader.readCSV(".\\servis.csv");
		Calculation calc=new Calculation();
		

		
		

		System.out.println("CijenaData");
		for(String[] s:cijeneData) {

			System.out.println(Arrays.toString(s));
			


		}

		System.out.println("automobil data");
		for(String[] s:automobilData) {
			System.out.println(Arrays.toString(s));


		}
		calc.ulazneListe(cijeneData, automobilData);
		calc.calculate();


	}

}
