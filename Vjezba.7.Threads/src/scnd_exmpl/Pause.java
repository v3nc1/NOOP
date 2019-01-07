package scnd_exmpl;

public class Pause {
	

		private boolean isPaused=false;

		public synchronized void pause(){
		isPaused=true;
		System.out.println("paused!!!!!! --> " + isPaused);
		}

		public synchronized void resume(){
		isPaused=false;
		notifyAll();
		}

		public synchronized void look(){
		while(isPaused){
		try {

		System.out.println(Thread.currentThread().getName() + " waiting!!!!");
		wait();

		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		}
		}

		public boolean getState() {

		return isPaused;
		}

		

}
