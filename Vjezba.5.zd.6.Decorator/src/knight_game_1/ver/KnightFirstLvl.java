package knight_game_1.ver;

public class KnightFirstLvl implements Knight {
	
	Knight knight;
	
	int b;
	

	public KnightFirstLvl(Knight knight) {
		
		this.knight = knight;
		
		System.out.println("Knight " + knight.getName()+" leveled up!");
	}

	@Override
	public void attack() {
		
		System.out.println("Knight lvl.1  "+knight.getName() + " attacks with Axe");

	}

	@Override
	public void movement(int mov) {
		System.out.println("Knight lvl.1 "+knight.getName()+ " moves fast " + mov + " steps");

	}

	@Override
	public void strength(int str) {
		System.out.println("Knight lvl.1  "+knight.getName() + " has strength 20");

	}

	@Override
	public void goAway() {
		System.out.println("Knight lvl.1  "+knight.getName() + " run's away");

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
