
public abstract class ShapeDecorator implements BasicShape {
	
	protected BasicShape decoratorShape;
	
	public void setShape2Decorator(BasicShape shape) {
		
		decoratorShape=shape;
		
	}

}
