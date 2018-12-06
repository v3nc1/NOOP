
public class Theme1Factory implements AbsFactoryTheme {
	
	
	
	

	public Theme1Factory() {
		
		createWindow();
		createMenuBar();
		createStatusBar();
		createToolBar();
		createScrollBar();
		
		
	}

	@Override
	public ScrollBar createScrollBar() {
		
		SolarizedDarkThemeScrollBar scBar=new SolarizedDarkThemeScrollBar();
		
		
		
		return scBar;
	}

	@Override
	public MenuBar createMenuBar() {
		
		SolarizedDarkThemeMenuBar mnBar=new SolarizedDarkThemeMenuBar();
		
		
		return mnBar;
	}

	@Override
	public StatusBar createStatusBar() {
		
		SolarizedDarkThemeStatusBar stBar=new SolarizedDarkThemeStatusBar();
		
		
		return stBar;
	}

	@Override
	public Window createWindow() {
		SolarizedDarkThemeWindow win=new SolarizedDarkThemeWindow();
		
		
		return win;
	}

	@Override
	public ToolBar createToolBar() {
		
		SolarizedDarkThemeToolBar toolBar=new SolarizedDarkThemeToolBar();
		
		
		
		return toolBar;
	}

}
