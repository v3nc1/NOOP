
public class LineThicknessDecorator extends ShapeDecorator {

	protected double lineThickness;

	public LineThicknessDecorator() {

		
	}

	public LineThicknessDecorator(BasicShape bc, double lTh) {

		decoratorShape = bc;
		lineThickness = lTh;

	}

	public void setBasicShape2Dec(BasicShape shape) {

		decoratorShape = shape;
	}

	public void setLineThickness(double lTh) {

		lineThickness = lTh;

	}

	@Override
	public void setShapeName(String name) {

		decoratorShape.setShapeName(name);

	}

	@Override
	public void draw() {
		decoratorShape.draw();
		System.out.println("With lines: " + lineThickness + " thickness");
	}

	@Override
	public void resize(int size) {
		decoratorShape.resize(size);

	}

	@Override
	public String description() {
		String dsc = decoratorShape.description() + " with new line thickness -->" + lineThickness;
		return dsc;
	}

	@Override
	public boolean isHide(int n) {

		return decoratorShape.isHide(n);
	}

}
