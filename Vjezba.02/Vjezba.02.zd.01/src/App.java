
public class App {

	public static void main(String[] args) {

		News mn = new News("Mjesecni");
		News qn= new News("Kvartalni");
		

		Sub s1 = new Sub("S1");
		Sub s2 = new Sub("S2");
		Sub s3 = new Sub("S3");
		Sub s4 = new Sub("S4");

		mn.add(s1);

		mn.add(s3);

		qn.add(s2);

		qn.add(s4);

		for (int i = 1; i <= 12; i++) {
			System.out.println("++++++Mjesec "+i+"+++++++++");
			if (i % 4 == 0 || i==1) {

				qn.notifyThem();
			}
			if (i == 5) {

				mn.remove(s3);
			}
			mn.notifyThem();

		}

	}

}
