
public class Duck {
	
	Flyable fl;
	Quackable qu;
	
	
	
	protected void display() {
			
	}
	
	protected void setFlyable(Flyable fl) {
		
		this.fl=fl;
	}


	public void quackProces() {
		qu.quackMethod();
		
	}

	
	public void flyProces() {
		fl.flyMethod();
		
	}

	

	
	

}
