import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Selecciona la forma: 1)Cuadrado, 2) Triángulo Equilatero 3)Triángulo Isósceles+"
				+ "4) Tri�ngulo escaleno "+"5) Rectangulo"+ "6) Pentagono "+ "7) Circulo ");
		int seleccionFigura= sc.nextInt();
		Shape s=null;
		sc.nextLine();
		System.out.println("El color de tu figura es: ");
		String color= sc.nextLine();
		switch(seleccionFigura) {
			case 1:
				System.out.println("Cuál es el lado de tu cuadrado?");
				s= new Square(color,sc.nextDouble());
				break;
			case 2: 
				System.out.println("Cuál es el lado de tu triángulo equilatero?");
				s= new Equilateral(color, sc.nextDouble());
				break;
			case 3: 
				System.out.println("Dame el lado grande:");
				double longSide= sc.nextDouble();
				System.out.println("Dame el lado pequeño:");
				double shortSide= sc.nextDouble();
				s= new Isosceles(color, longSide,shortSide);
				break;
				
			case 4:
				System.out.println("Valor lado peque�o");
				longSide=sc.nextDouble();
				System.out.println("Valor  lado grande");
				double mediumSide=sc.nextDouble();
				System.out.println("Valor hipotenusa");
				shortSide=sc.nextDouble();
				s=new Scalene(color, longSide, mediumSide, shortSide);
				break;
				
			case 5:
				System.out.println("Valor lado grande");
				longSide=sc.nextDouble();
				System.out.println("Valor  lado peque�o");
				shortSide=sc.nextDouble();
				s=new Rectangle(color, longSide, shortSide);
				break;
				
			case 6:
				System.out.println("Valor lado ");
				longSide=sc.nextDouble();
				s=new Pentagon(color,longSide);
				break;
				
			case 7:
				
				System.out.println("Valor del radio de tu circulo");
				double radio=sc.nextDouble();
				s=new Circle(color, radio);
				break;
			
		}
		
		System.out.println("El perímetro de tu figura es: "+s.calculatePerimeter());
		System.out.println("El área de tu figura es: "+s.calculateArea());
		sc.close();
	}

}
