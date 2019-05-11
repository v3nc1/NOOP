
public class App {

	public static void main(String[] args) {

		GoldenRetriever gr=new GoldenRetriever("Roky", 2);
		LabradorRetriever lr=new LabradorRetriever("Riky", 1);
		PlushElectricDog pe=new PlushElectricDog("Kaky", 4);
		RobotDog rd=new RobotDog("T100", 0);
		
		
		System.out.println("\n>>>>>>>Golden Retriever");
		
		gr.Bark();
		
		System.out.println("\n>>>>>>>Labrador Retriever");
		lr.Bark();
		
		System.out.println("\n>>>>>>>Plush Electric Dog");
		
		pe.Bark();
		pe.training(2);
		pe.charge();
		
		System.out.println("\n>>>>>>>Robot Dog");
		rd.charge();
		rd.Bark();
		rd.training(3);
		rd.intDivision(3, 2);
		
		
	}

}
