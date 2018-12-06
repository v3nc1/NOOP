import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		
		String ui;
		
		Scanner sc=new Scanner(System.in);
		Application app;
		
		System.out.println("Unesi WIN za Windows ili MAC za Mac GUI: \n ");
		
		
		
		ui=sc.nextLine();
		
		if(ui.equals("WIN")) {
			
			app=new Application(new WinGUIFactory());
			app.createUI();
			app.paint();
			
		}else if(ui.equals("MAC")) {
			
			app=new Application(new MacGUIFactory());
			app.createUI();
			app.paint();
		}

	}

}
