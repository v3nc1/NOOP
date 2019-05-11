package Venci_Ivos_Zad_3;

public class University {
	
	private String univerName;
	private static int cnt;
	private int uniID;
	
	
	public University(String univerName) {
		
		cnt++;
		this.univerName = univerName;
		this.uniID = cnt;
	}
	
	public String toString() {
		
		return (univerName+" --> "+"ID: "+uniID);
	}
	

}
