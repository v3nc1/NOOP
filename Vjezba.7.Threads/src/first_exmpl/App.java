package first_exmpl;

public class App {

	public static void main(String[] args) {

		Robot robi = new Robot("T2000");
		Runnable job = new Threadjob();
		Thread thr1 = new Thread(job);
		Thread thr2=new Thread(job);
		thr1.setName("First thread");
		thr2.setName("Second thread");


		

			System.out.println("++++++++++++++++ " +  " ++++++++++++++++");
			System.out.println("++++++++++++++++ BEFORE IN MAIN ++++++++++++++++");
			System.out.println("Message in main thread before our thread...");

			robi.description();
			thr1.start();
			try {
				Thread.currentThread().sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			thr2.start();
			try {
				Thread.currentThread().sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());

			System.out.println("++++++++++++++++ AFTER IN MAIN ++++++++++++++++");
			System.out.println("Message - finall in main...");
			System.out.println("\n\n\n");
			
		

	}

}
