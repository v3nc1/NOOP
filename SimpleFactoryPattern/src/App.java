
public class App {

	public static void main(String[] args) {


		CarStore cs=new CarStore(new SimpleCarCreator());
		
		cs.orderCar("SUV","Bilo");
		
		cs.orderCar("Sedan", "Violetno");
		
	

	}

}
