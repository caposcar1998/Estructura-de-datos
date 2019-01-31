import java.util.Scanner;

public class Main {
private static Scanner sc;

public static void main(String []main) {
	
	Hanoi hanoi=new Hanoi();
	sc = new Scanner(System.in);
	System.out.println("¿Cuantos anillos tiene tu torre?");
	hanoi.setAnillo(sc.nextInt() );
	hanoi.numeroMovimientos();
	System.out.println("Los movimientos necesarios para esta torre son "+ hanoi.getMovimientos());
	hanoi.setTorre1(null );
	hanoi.setTorre2(null);
	hanoi.setTorre3(null);
}
}
