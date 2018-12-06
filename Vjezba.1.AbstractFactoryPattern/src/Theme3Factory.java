
public class Theme3Factory implements AbsFactoryTheme {
	
	

	public Theme3Factory() {
		
		createWindow();
		createMenuBar();
		createStatusBar();
		createToolBar();
		createScrollBar();
	}

	@Override
	public ScrollBar createScrollBar() {
		
		DarkThemeScrollBar scBar=new DarkThemeScrollBar();
		
		return scBar;
	}

	@Override
	public MenuBar createMenuBar() {
		
		DarkThemeMenuBar mnBar=new DarkThemeMenuBar();
		return mnBar;
	}

	@Override
	public StatusBar createStatusBar() {
		
		DarkThemeStatusBar stBar=new DarkThemeStatusBar();
		
		return stBar;
	}

	@Override
	public Window createWindow() {
		
		DarkThemeWindow win=new DarkThemeWindow();
		return win;
	}

	@Override
	public ToolBar createToolBar() {
		
		DarkThemeToolBar toolBar=new DarkThemeToolBar();
		
		return toolBar;
	}

}
