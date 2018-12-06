package Writer;

public class AdapterNovel implements Writer {

	SFNovelWriter sfNovel;

	public AdapterNovel(SFNovelWriter sfNovel) {

		this.sfNovel = sfNovel;
	}

	@Override
	public void writeNovel(int type) {

		sfNovel.writeSFNovel();

	}

}
