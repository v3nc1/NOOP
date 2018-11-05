
public class FillColorDecorator extends ShapeDecorator {

	Color fillColor;

	public FillColorDecorator() {

		
	}

	public FillColorDecorator(BasicShape bs, Color clr) {

		decoratorShape = bs;
		fillColor = clr;

	}

	public void setBasicShape2Dec(BasicShape shape) {

		decoratorShape = shape;
	}

	public void setFillColor(Color clr) {

		fillColor = clr;

	}

	@Override
	public void setShapeName(String name) {
		String newName = "Filled with color: ";
		name += newName;
		decoratorShape.setShapeName(name);

	}

	@Override
	public void draw() {
		decoratorShape.draw();
		System.out.println("Filled with color --> " + fillColor);

	}

	@Override
	public void resize(int size) {
		decoratorShape.resize(size);

	}

	@Override
	public String description() {
		
		String desc = decoratorShape.description() + " filled with: " + fillColor + " color";

		return desc;
	}

	@Override
	public boolean isHide(int n) {

		return decoratorShape.isHide(n);
	}

}
