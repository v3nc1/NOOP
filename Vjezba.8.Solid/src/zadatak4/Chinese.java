package zadatak4;

public class Chinese implements iRecept, ChineseRecipe {

	@Override
	public void generateChineseRecipe() {
		System.out.println("Shangay duck");

	}

	@Override
	public void provideAdditionalInfo() {
		System.out.println("Need duck");

	}

	@Override
	public void recommendWebSources() {
		System.out.println("Shangy cook house");

	}

}
