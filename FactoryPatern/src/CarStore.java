
public abstract class CarStore {
	
	

	public CarStore() {
		
	}
	
	public Car orderCar(String type, String color) {
		
		Car car;
		
		car = createCar(type, color);
			car.manufacture();
			car.paint(color);
			car.deliver();
			System.out.println(car.toString());
			
			return car;

	}
	
	protected abstract Car createCar(String type, String color);
	
	
	

}
