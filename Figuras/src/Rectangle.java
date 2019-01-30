
public class Rectangle extends Shape{

	private double side1, side2;
	public Rectangle(String color, double side1, double side2) {
		super(color);
		this.side1=side1;
		this.side2=side2;
	}
	public double getSide1() {
		return side1;
	}
	public void setSide1(double side1) {
		this.side1 = side1;
	}
	public double getSide2() {
		return side2;
	}
	public void setSide2(double side2) {
		this.side2 = side2;
	}
	
	public double calculatePerimeter() {
		return ((side1*2)+(side2*2));
	}
	
	public double calculateArea() {
		return (side1*side2);
	}
}
