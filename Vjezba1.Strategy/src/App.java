
public class App {

	public static void main(String[] args) {


		RUbberDuck rd=new RUbberDuck();
		DomacaDuck domD=new DomacaDuck();
		DivljaDuck divD=new DivljaDuck();
		
		
		System.out.println("#################");
		rd.display();
		rd.flyProces();
		rd.quackProces();

		
		
		System.out.println("#################");
		domD.display();
		domD.flyProces();
		domD.quackProces();
		

		
		System.out.println("#################");
		divD.display();
		divD.flyProces();
		divD.quackProces();
		divD.setFlyable(new RocketFly());
		divD.flyProces();


	}

}
