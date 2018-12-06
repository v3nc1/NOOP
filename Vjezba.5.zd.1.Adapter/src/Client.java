
public class Client {

	public static void main(String[] args) {
		
		Ploter plot=new Adapter2OldDrv(new OldDriver());
		
		
		plot.ispisGrafike();
		
		Ploter plotNew=new NewPloter();
		
		plotNew.ispisGrafike();
		
		
	
	}

}
