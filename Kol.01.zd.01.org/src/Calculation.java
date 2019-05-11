
public class Calculation {
	
	public static void calcTotalArt () {

		
		
		ReadCSV.createCompList().forEach(x->{
			int ukupno=0;
			
			for(int uk:ReadCSV.getCompArray(x)) {
				
				ukupno+=uk;
			}
			
			System.out.println(x+" : ukupno: "+ukupno+" artikala");
			
		});
		
		
	}
	
	public static void priceCalc() {
		
		ReadCSV.createCompList().forEach(x->{
			int ukupno=0;
			int br=1;
			for(int uk:ReadCSV.getCompArray(x)) {
				
				
				if (br==1) {
					
					ukupno+=uk*5;
					br++;
					
				}else if(br==2) {
					
					ukupno+=uk*10;
					br++;
				}else {
					ukupno+=uk*15;
					
					br=1;
				}
				
				
			}
			
			System.out.println(x+" : ukupno: "+ukupno+" $");
			
		});
		
		
	}

}
