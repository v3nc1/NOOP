import java.io.IOException;
import java.util.Arrays;

public class Calculation {
	
	public static void avgSems(String[][] lista) throws IOException {
		
		int row=1;
		int col=1;
		int len=Reader.br;
		double[][] listaNum=new double[len][len];
		String[] listaString;
		double[] sum=new double[len-1];
		double[] avg=new double[len-1];
		
		
		for (int i=row;i<len;i++) {
			
			
			listaString=lista[i][0].split(",");
			
			
			for(int j=1;j<len+1;j++) {
			
			Double nbr=Double.parseDouble(listaString[j]);
			sum[i-1]+=nbr;
			listaNum[i-1][j-1]=roundN(nbr,2);
			
			
			}
			
			avg[i-1]=roundN((sum[i-1]/5),2);
					
		}
		
		
		
			System.out.println(Arrays.toString(avg));
			
			
		

		System.out.println("\n");
		int point=1;
		for(double var: sum) {
			
			
			
			
			System.out.println("Student: S_"+(point++)+" --> AVG: "+ roundN((var/5),2));
			
			
		}
		
		
	}
	
	private static double roundN(double value,int places) {
		
		
		double scale =Math.pow(10, places);
		
		return Math.round(value*scale)/scale;
		
	}
}
	
	