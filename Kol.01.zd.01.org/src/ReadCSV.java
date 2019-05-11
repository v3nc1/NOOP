import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class ReadCSV {
	
	static String[][] coData = new String[16][];
	
	
	
		public static void csvRead() {
			String buff;
			int br=0;
			
			try (FileInputStream fIn=new FileInputStream("C:\\Users\\vivos\\Documents\\CODE\\Eclipse\\Kol.01.zd.01.org\\prodaja.csv");
					InputStreamReader inStream = new InputStreamReader(fIn);
					BufferedReader buffRead=new BufferedReader(inStream);){
				
				while((buff=buffRead.readLine())!=null) {
					
					coData[br]=buff.split(",");
					
					br++;
					
				}
				
				/*for(String[] line:coData) {
					
					System.out.println(Arrays.toString(line));
				}*/
				
				
				
				
				
			}catch(IOException  e) {
				
				e.getMessage();
			}
			
			//valExtract(coData);
			
		}
		
		public static ArrayList<String> createCompList(){
			
			Set<String> compName=new TreeSet<>();
			ArrayList<String> co = new ArrayList<>();
			
			for(int i=1; i<coData.length;i++) {
				
				compName.add(coData[i][0]);
			}
			
			co.addAll(compName);
			
			return co;
			
		}
		
		public static String[][] extractDta(){
			
			
			String[][] extData=new String[createCompList().size()][];
			
			
			int br=0;
			
			
			
			for(String name:createCompList()) {


				int br2=0;
				
				//extData[br][br2]=name;	
				
				for (int i=0; i<coData.length;i++) {


					if(coData[i][0].equals(name)) {
						
						
						for(String st2:coData[i]) {
							if(!(st2.equals(name))) {
								br2++;
								
								extData[br]=new String[br2];
								
								
								
								
								//extData[br][br2]=st2;
								
							
								
							}
						}
					
					}	
					
				}
				br++;
			}
			br=0;
			for(String name:createCompList()) {


				int br2=0;
				
				//extData[br][br2]=name;	
				
				for (int i=0; i<coData.length;i++) {


					if(coData[i][0].equals(name)) {
						
						
						for(String st2:coData[i]) {
							if(!(st2.equals(name))) {
								
								
								extData[br][br2]=st2;
								
								br2++;
								
							}
						}
					
					}	
					
				}
				br++;
			}
			/*for(String[] dat:extData) {
				

				System.out.println(Arrays.toString(dat));
				
			}*/
			
		
			return extData;
		}
		
		public static int[][] valExtract(String[][] ext){
			
			int intArray[][]=new int[ext.length][];
			int row=0;
			
			
			
			
					
				
				
				for (String[] sts:ext) {
					int col=0;
					for(String st:sts) {
					col++;
					intArray[row]=new int[col];
					
					}
					row++;
				}
		
			row=0;
			//Punjenje liste
			


				for (int i=0;i<ext.length;i++) {
					
					int col=0;
					for(int j=0;j<ext[i].length;j++) {
						
						intArray[i][j]=Integer.parseInt(ext[i][j]);
						
						col++;
						
					}
				
				row++;
			}
			
			/*
			 * for (int i=0;i<ext.length;i++) {
			
				
				intArray[i]=Arrays.stream(ext[i]).map(Integer::parseInt).toArray();
				
			}
			 */
			
			
			return intArray;
			
		}
		
		public static int[] getCompArray(String name) {
			
			int[] lista=null;
			int br=0;
			
			for (String co:createCompList()) {
			
				if(name.equals(co)) {
					lista=valExtract(extractDta())[br];
				}
				br++;
			
			}
			return lista;
		}
	

}
