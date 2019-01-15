package zadatak4;

public class Indian implements iRecept, IndianRecipe {

	@Override
	public void generateIndianRecipe() {
		System.out.println("Somethin spicey");

	}

	@Override
	public void provideAdditionalInfo() {
		System.out.println("Need curry");

	}

	@Override
	public void recommendWebSources() {
		System.out.println("Bangladesh coolinarka");

	}

}
