
public class Square extends Shape{
	
	private double side;
	public Square(String color,double side) {
		super(color);
		this.side=side;
	}
	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}
	
	public double calculatePerimeter() {
		return 4*side;
	}
	
	public double calculateArea() {
		return side*side;
	}
	
}
