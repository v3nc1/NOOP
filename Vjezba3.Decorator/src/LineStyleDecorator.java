
public class LineStyleDecorator extends ShapeDecorator {
	
	LineStyle lineStyle;
	
	public LineStyleDecorator() {
		
	}
	
	
	public LineStyleDecorator(BasicShape bs, LineStyle ls) {
		decoratorShape= bs;
		lineStyle=ls;
	}
	
	public void setBasicShape2Dec(BasicShape shape) {

		decoratorShape = shape;
	}
	
	public void setLineStyle(LineStyle lSt) {

		lineStyle = lSt;
		
	}
	
	
	@Override
	public void setShapeName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw() {
		decoratorShape.draw();
		System.out.println("With line style: "+lineStyle+" style");

	}

	@Override
	public void resize(int size) {
		
		decoratorShape.resize(size);

	}

	@Override
	public String description() {
		String dsc=decoratorShape.description()+ " with line style -->"+ lineStyle;
		return dsc;
	}

	@Override
	public boolean isHide(int n) {
		
		return decoratorShape.isHide(n);
	}

}
