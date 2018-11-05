
public class LineColorDecorator extends ShapeDecorator {

	Color lineColor;

	public LineColorDecorator() {

	}

	public LineColorDecorator(BasicShape shape,Color lc) {
		
		decoratorShape=shape;
		lineColor=lc;

	}

	public void setBasicShape2Dec(BasicShape shape) {

		decoratorShape = shape;
	}

	public void setLineColor(Color clr) {

		lineColor = clr;
	}

	@Override
	public void setShapeName(String name) {

		decoratorShape.setShapeName(name + "Line color: " + lineColor);

	}

	@Override
	public void draw() {
		decoratorShape.draw();
		System.out.println("Lines with color: " + lineColor);

	}

	@Override
	public String description() {

		return decoratorShape.description() + "with colored lines: " + lineColor;
	}

	@Override
	public boolean isHide(int n) {

		return decoratorShape.isHide(n);
	}

	@Override
	public void resize(int size) {
		decoratorShape.resize(size);

	}

}
