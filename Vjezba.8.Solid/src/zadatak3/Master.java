package zadatak3;

public abstract class Master {
	
	protected String name;
	protected String description;




	public void askforAdvice() {
		System.out.println(description + " ask for an advice...");
	}
	public void giveAdvice() {
		System.out.println(description + " provide useful advice ...");
	}
	public void bringTools() {
		System.out.println("Every repairman can and should bring a tool bag ...");
	}
	
	public void performRepair() {
		System.out.println(description + " performing a repair ... ");
	}
	public void performMaintance() {
		System.out.println(description + "provide a good maintenance ...");
	}
	protected String description() {

		String desc = getClass().getSimpleName();
		return desc;
	}

}
