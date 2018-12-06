package knight_game_1.ver;

public class Client {

	public static void main(String[] args) {
		
		SimpleKnight knight=new SimpleKnight("Antonio");
		
		knight.attack();
		knight.movement(3);
		knight.strength(2);
		knight.goAway();
		
		
		
		KnightFirstLvl knightLvl1=new KnightFirstLvl(knight);
		
		knightLvl1.attack();
		knightLvl1.movement(3);
		knightLvl1.strength(4);
		knightLvl1.goAway();
	}

}
