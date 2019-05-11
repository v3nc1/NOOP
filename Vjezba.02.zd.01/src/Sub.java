
public class Sub implements ObserversSubscribers {

	String name;

	public Sub(String name) {

		this.name = name;
	}

	@Override
	public void update(String name) {

		System.out.println("Novi broj:" + name + " za " + this.name);

	}

}
