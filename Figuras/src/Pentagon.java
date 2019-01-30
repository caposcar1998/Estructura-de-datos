import java.lang.Math;

public class Pentagon extends Shape {
	
	private double side;
	private double apotem;
	
	
	public Pentagon(String color,double side) {
		super(color);
		this.side = side;
		
	}
	public double getSide() {
		return side;
	}
	public void setSide(double side) {
		this.side = side;
	}
	
	

	
	public double calculatePerimeter() {
		double perimeter=(side*5);
		return perimeter ;
	}
	
	public double calculateArea() {
		double angle=(360/side);
		apotem=(side/2*Math.tan(angle/2));
		double area=(calculatePerimeter()*apotem)/2;
		return area;
	}

}
