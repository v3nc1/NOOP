import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Reader {
	
	public static int br=0;
	
	public static String[][] lista;
	
	
	
	
	public static void ReadCSV() throws IOException {
		
		try {
		
		int mark=0;
		String[][] ls=new String[10][1];
			
		File input=new File("C:\\Users\\vivos\\Documents\\CODE\\Eclipse\\Kol.01zd.01\\studenti.csv");
		
		BufferedReader bRead=new BufferedReader(new FileReader(input));
		
		String temp;
		int tempLength=(int)input.length();
		
		
		for(int i=0;i<10;i++) {
			
			ls[i][0]=bRead.readLine();
			
			if(ls[i][0]!=null) {
				
				br++;
			}
		}
		
		
		
		for(String[] var:ls) {
			
			System.out.println(Arrays.toString(var));
		}
		
		lista=new String[br][1];
		
		for(int i=0;i<lista.length;i++) {
			
			lista[i][0]=ls[i][0];
			
		}
		System.out.println("\n");
		
		
		}catch(FileNotFoundException e) {
			
			System.out.println("Nema tražene datoteke");
		}
		
		
		
	}
	
	public static String[][] gen2DArr() throws IOException{
		
		return lista;
	
	}
}
