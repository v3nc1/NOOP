package zadatak3;

public class Apprentice {
	
	String name;
	String description;
	
	public Apprentice(String name) {
		this.name = name;
		if(description==null) {
			this.description = "Apprentice";
		}

	}

	
	public void askforAdvice() {

		System.out.println(description + " ask for an advice...");

	}

	
	public void giveAdvice() {
		System.out.println("Can't give an advice!!!");

	}

	
	public void bringTools() {

		System.out.println("Every repairman can and should bring a tool bag ...");

	}

	
	public void performRepair(){

		System.out.println("Still can not perform repairs!!!");

	}


	public void performMaintance() {

		System.out.println("Not able to do maintance jobs...");

	}


}
