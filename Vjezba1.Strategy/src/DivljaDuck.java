
public class DivljaDuck extends Duck{
	
	public DivljaDuck() {
		
		qu=new Quacking();
		fl=new WingFly();
	}

	@Override
	protected void display() {
		System.out.println("DivljaDuck");
	}

	@Override
	protected void setFlyable(Flyable fl) {
		
		this.fl=fl;
	}
	
	
	

}
