
public class Triangle implements BasicShape {
	
	public static final String NAME="Triangle";
	private String name;
	
	
	public Triangle() {
		
	}
	
	
	public String getShName() {
		return NAME;
	}

	

	@Override
	public void draw() {
		System.out.println("Drawing --> "+NAME);

	}

	@Override
	public void resize(int size) {
		
		System.out.println("Basic shape resized --> "+ size);

	}

	@Override
	public String description() {
		String desc="Drawing "+ NAME+" ";
		
		return desc;
	}

	@Override
	public boolean isHide(int n) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setShapeName(String name) {
		
		System.out.println("You can't change object name");
		this.name = name;
		
	}
}
