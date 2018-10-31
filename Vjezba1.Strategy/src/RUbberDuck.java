
public class RUbberDuck extends Duck {
	
	public RUbberDuck() {
		
		qu=new Squik();
		fl=new FlyNoFly();
		
	}
	
	@Override
	protected void display() {
		
		System.out.println("RUbberDuck");
	}

	@Override
	protected void setFlyable(Flyable fl) {
		
		this.fl=fl;
	}


}
