package Venci_Ivos_Zad_4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVReader {
	
	
	ArrayList<String> servisi=new ArrayList<>();
	ArrayList<String> klase=new ArrayList<>();
	
	
	public static String[][] readCSV(String source) {
		
		String[][] readFile=new String[6][];
		String temp;
		
		//Ucitavenj cijena
		try(BufferedReader buff=new BufferedReader(
				new InputStreamReader(
						new FileInputStream(source)))){
			
			
			int br=0;
			
			while((temp=buff.readLine())!=null) {
				
				readFile[br]=temp.split(",");
				br++;
			}
			
		}catch(IOException e) {
			
			e.getMessage();
			
		}
		
		

		
		return readFile;
	}
	
	

}
