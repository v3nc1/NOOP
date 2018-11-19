
public class Theme2Factory implements AbsFactoryTheme {
	
	

	public Theme2Factory() {
		
		createWindow();
		createMenuBar();
		createStatusBar();
		createToolBar();
		createScrollBar();
	}

	@Override
	public ScrollBar createScrollBar() {
		
		LightVisualThemeScrollBar scBar=new LightVisualThemeScrollBar();
		
		return scBar;
	}

	@Override
	public MenuBar createMenuBar() {
		
		LightVisualThemeMenuBar mnBar=new LightVisualThemeMenuBar();
		return mnBar;
	}

	@Override
	public StatusBar createStatusBar() {
		
		LightVisualThemeStatusBar stBar=new LightVisualThemeStatusBar();
		
		return stBar;
	}

	@Override
	public Window createWindow() {
		
		LightVisualWindow win=new LightVisualWindow();
		return win;
	}

	@Override
	public ToolBar createToolBar() {
		
		LightVisualThemeToolBar toolBar=new LightVisualThemeToolBar();
		
		return toolBar;
	}

}
