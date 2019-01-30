
public class Scalene extends Triangle{

	public Scalene(String color, double side1, double side2, double side3) {
		super(color, side1, side2, side3);
	}

	public double calculateArea() {
		double heron=(getSide1()+getSide2()+getSide3())/2;
		double area=Math.sqrt((heron*(heron-getSide1())* (heron-getSide2())* (heron-getSide3()) ));
		return area;
	}
	
	

}
