package first_exmpl;

public class Threadjob implements Runnable {

	@Override
	public void run() {

		run2();
		//System.out.println(Thread.currentThread().getName());

	}

	private void additionalMethod() {

		for (int i = 0; i < 10; i++) {
			System.out.println("Some message from thread "+ Thread.currentThread().getName()+"...");
		}
	}

	private void run2() {

		additionalMethod();
	}

}
