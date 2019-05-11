
public class Solution {
		
		private static int cnt;
		private double a;
		private double b;
		private double c;
		private double d;
		private double x1;
		private double x2;
		
		
	public Solution(double a,double b,double c) {
		
		cnt++;
		this.a=a;
		this.b=b;
		this.c=c;
		d=diskriminanta(a, b, c);
		
		
			
		x1=rjX1(a, b, c);
		x2=rjX2(a, b, c);
		
		
	}
	
	private double diskriminanta(double a, double b, double c) {
		
		double d=(Math.pow(b, 2))-(4*a*c);
		
		return d;
		
	}
	
	private double rjX1(double a, double b, double c) {
		
		double x1=(-b+Math.sqrt((Math.pow(b, 2)-(4*a*c))))/(2*a);
		
		return x1;
	}
	
	private double rjX2(double a, double b, double c) {

		double x1=(-b-Math.sqrt((Math.pow(b, 2)-(4*a*c))))/(2*a);

		return x1;
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public double getC() {
		return c;
	}

	public double getD() {
		return d;
	}

	public double getX1() {
		return x1;
	}

	public double getX2() {
		return x2;
	}

	public int getCnt() {
		return cnt;
	}
	
	
	
}
