import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class App {

	public static void main(String[] args) {


		//Informations.start();
	
			
			ReadCSV.csvRead();
			ReadCSV.createCompList();
			
			
			ReadCSV.valExtract(ReadCSV.extractDta());
			
			Calculation.calcTotalArt();
			Calculation.priceCalc();
			
		//Informations.stop();
		

	}

}
