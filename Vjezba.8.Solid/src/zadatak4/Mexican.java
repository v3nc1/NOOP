package zadatak4;

public class Mexican implements iRecept, MexicanRecipe {

	@Override
	public void generateMexicanRecipe() {
		System.out.println("Tortilia with chicken");

	}

	@Override
	public void provideAdditionalInfo() {
		System.out.println("Need chicken");

	}

	@Override
	public void recommendWebSources() {
		System.out.println("Ask Trump");

	}

}
