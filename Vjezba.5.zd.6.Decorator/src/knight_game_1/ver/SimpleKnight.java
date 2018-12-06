package knight_game_1.ver;

public class SimpleKnight implements Knight {
	
	private String name;
	
	public SimpleKnight(String name) {
		
		this.name=name;
	}

	@Override
	public void attack() {

		System.out.println("Simple knight "+name+ " attacks with bare hands");

	}

	@Override
	public void movement(int mov) {
		
		System.out.println("Simple knight "+name+ " moves with bare feet " + mov + " steps");

	}

	@Override
	public void strength(int str) {
		
		
		System.out.println("Simple knight "+ name + " has strength " + 10);

	}

	@Override
	public void goAway() {
		System.out.println("Simple knight "+name+ " run's away");

	}

	public String getName() {
		return name;
	}
	
	

}
