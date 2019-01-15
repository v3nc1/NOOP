package zadatak2;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {

		Member mb1 = new Member("Niko");
		Member mb2 = new Member("Antonio");
		Member mb3 = new Member("Stipe");
		Member mb4 = new Member("Jure");
		Member mb5 = new Member("Ivo");

		ArrayList<Member> lista = new ArrayList<>();

		lista.add(mb1);
		lista.add(mb2);
		lista.add(mb3);
		lista.add(mb4);
		lista.add(mb5);

		for (Member m : lista) {

			m.showMembership();
		}

		mb1.setMembership(new PlatinumMember());
		mb2.setMembership(new GoldMember());
		mb3.setMembership(new DiamantMember());
		mb5.setMembership(new SilverMember());

		for (Member m : lista) {

			m.showMembership();
		}

	}

}
