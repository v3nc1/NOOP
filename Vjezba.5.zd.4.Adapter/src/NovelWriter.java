
public class NovelWriter implements Writer {

	@Override
	public void writeNovel(int type) {

		switch (type) {

		case 1:
			System.out.println("Historic novel...");
			break;
		case 2:
			System.out.println("Romantic novel...");
			break;
		case 3:
			System.out.println("Triller novel...");
			break;
		case 4:
			System.out.println("Unknown novel type...");
			break;
		default:
			System.out.println("No type...");
		}

	}

}
