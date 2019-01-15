package zadatak3;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		List<Master> list = new ArrayList<>();
		Apprentice apr=new Apprentice("Antonio");
		
		list.add(new NoviceMaster("Marko"));
		list.add(new ExperincedMaster("Josipa"));
		list.add(new SupremeMaster("Vedrana"));
		

		list.forEach(mst -> mst.askforAdvice());
		list.forEach(mst -> mst.giveAdvice());
		list.forEach(mst -> mst.bringTools());
		list.forEach(mst -> mst.performRepair());
		list.forEach(mst -> mst.performMaintance());
		
		apr.askforAdvice();
		apr.giveAdvice();
		apr.performMaintance();
		apr.performRepair();
		apr.bringTools();

	}

	

}
