import java.util.Scanner;

public class Client {

	
	private static ToolBar toolBar;
	private static ScrollBar scBar;
	private static Window win;
	private static MenuBar menuBar;
	private static StatusBar stBar;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int br;
		boolean flag=false;
		
		Client client;
		
		while(flag!=true) {
		System.out.println("**************************");
		System.out.println("Choose theme:");
		System.out.println("1 - Solarized dark theme");
		System.out.println("2 - Light visual theme");
		System.out.println("3 - Dark theme");
		System.out.println("**************************");

		br = sc.nextInt();

		switch (br) {
		case 1:
			createTheme(new Theme1Factory());

			break;
		case 2:
			createTheme(new Theme2Factory());

			break;
		case 3:
			createTheme(new Theme3Factory());

			break;

		default:
			flag=true;
			break;
		}
		}
	}

	
	//
	// }

	public static void createTheme(AbsFactoryTheme factoryTheme) {
		
		
		
		 
		 toolBar=factoryTheme.createToolBar();
		 scBar=factoryTheme.createScrollBar();
		 win=factoryTheme.createWindow();
		 menuBar=factoryTheme.createMenuBar();
		 stBar=factoryTheme.createStatusBar();
		 paint();

	}

	
	public static void paint() {

		menuBar.paint();
		scBar.paint();
		stBar.paint();
		toolBar.paint();
		win.paint();

	}

}
