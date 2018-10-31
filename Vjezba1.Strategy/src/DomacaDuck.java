
public class DomacaDuck extends Duck {
	
	public DomacaDuck() {
		
		qu=new Quacking();
		fl=new WingFly();
	}

	@Override
	protected void display() {
		System.out.println("DomacaDuck");
	}
	
	@Override
	protected void setFlyable(Flyable fl) {
		
		this.fl=fl;
	}
	
	

}
