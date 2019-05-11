import java.util.ArrayList;

public class Calculation {
	
	
	private double pay;
	private float kreda;
	private float kamata;
	private int nacin;
	private int godina;
	
	//public static ArrayList<Calculation> lista = new ArrayList<>();
	
	
	public Calculation(float kr,float km, int nac, int gdn) {

		//lista.add(this);
		
		kreda=kr;
		kamata=km;
		nacin=nac;
		godina=gdn;
		
		pay = calculate(kr, km, nac, gdn);
		
		
	}
	

	
	public static double calculate(float kr,float km, int nac, int gdn) {
		
		double pay;
		float intr = km/nac;
		int n = gdn*12;
		double D = (Math.pow((1+intr), n)-1) / (intr*Math.pow((1+intr),n));
		pay = kr / D;
		return pay;
		
	}


	public double getPay() {
		return pay;
	}


	public void setPay(double pay) {
		this.pay = pay;
	}


	public float getKreda() {
		return kreda;
	}


	

	public float getKamata() {
		return kamata;
	}



	public int getNacin() {
		return nacin;
	}



	public int getGodina() {
		return godina;
	}

	
	

}
