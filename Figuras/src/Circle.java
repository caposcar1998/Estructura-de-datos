
public class Circle extends Shape {
	
	private double radio;
	private final double pie= 3.1416;
	
	
	public Circle(String color, double radio) {
		super(color);
		this.radio = radio;
		
	}
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	public double getPie() {
		return pie;
	}
	
	public double calculateArea() {
		double area= pie*(Math.pow(radio, 2));
		return area;
	}
	@Override
	public double calculatePerimeter() {
		
		return (2*pie*radio);
	}

}
