
public class CarStore {
	
	SimpleCarCreator carCreator;

	public CarStore(SimpleCarCreator scc) {
		
		carCreator = scc;
		
	}
	
	Car orderCar(String type, String color) {
		
		
		 Car car = carCreator.createCar(type, color);
			car.manufacture();
			car.paint(color);
			car.deliver();
			System.out.println(car.toString());
			
			return car;

	}
	
	

}
