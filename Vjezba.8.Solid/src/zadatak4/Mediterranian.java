package zadatak4;

public class Mediterranian implements Mediteranean, iRecept {
	
	

	@Override
	public void provideAdditionalInfo() {
		System.out.println("Need pasta");

	}

	@Override
	public void recommendWebSources() {
		System.out.println("Coolinarka");

	}

	@Override
	public void generateMeditrraneanRecipe() {
		System.out.println("Pastasuta");

	}

}
