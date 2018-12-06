
public class AppClient {

	public static void main(String[] args) {

		NovelWriter novWrt = new NovelWriter();

		novWrt.writeNovel(99);

		Writer oldSchl = new AdapterNovel(new SFNovelWriter());

		oldSchl.writeNovel(3);
	}

}
