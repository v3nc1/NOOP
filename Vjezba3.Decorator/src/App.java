
public class App {

	public static void main(String[] args) {
		
		BasicShape cir1=new Circle();
		cir1.setShapeName("Triangle");
		System.out.println(cir1.description());
		cir1.draw();
		
		System.out.println("Create decorating circle with:");
		System.out.println("1. - line color with purple color");
		System.out.println("2. - line thicknes of 3.45");
		System.out.println("3. - line style --> Double Dash");
		System.out.println("4. - fill with color yellow");
		System.out.println("++++++++++ Start decoration ++++++++++");
		
		LineColorDecorator lcd=new LineColorDecorator();
		lcd.setBasicShape2Dec(cir1);
		lcd.setLineColor(Color.PURPLE);
//		lcd.setShapeName("LineColName: ");
//		lcd.description();
//		lcd.draw();
		
		System.out.println("++++++++++++++ step 2 ++++++++++++++++");
		
		LineThicknessDecorator ltd=new LineThicknessDecorator();
		ltd.setBasicShape2Dec(lcd);
		ltd.setLineThickness(3.45);
//		ltd.description();
//		ltd.draw();
		
		System.out.println("++++++++++++++ step 3 ++++++++++++++++");
		
		LineStyleDecorator lsd=new LineStyleDecorator();
		lsd.setBasicShape2Dec(ltd);
		lsd.setLineStyle(LineStyle.DOUBLE_DASH);
//		lsd.description();
//		lsd.draw();
		
		System.out.println("++++++++++++++ step 4 ++++++++++++++++");
		
		FillColorDecorator fcd= new FillColorDecorator();
		fcd.setBasicShape2Dec(lsd);
		fcd.setFillColor(Color.YELLOW);
		fcd.description();
		fcd.draw();
		
		System.out.println("++++++++++ Start decoration v.2 ++++++++++");
		
		FillColorDecorator fcd2=new FillColorDecorator(
				new LineStyleDecorator(
						new LineThicknessDecorator(
								new LineColorDecorator(
										new Triangle(),Color.GRAY), 1.5), LineStyle.DASH_DOT_DASH),Color.Color.GREEN);
		
		System.out.println(fcd2.description());
		fcd2.draw();
	}

}
