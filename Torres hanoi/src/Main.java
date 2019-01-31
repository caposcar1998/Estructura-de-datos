import java.util.Scanner;

public class Main {
private static Scanner sc;

public static void main(String []main) {
	
	int movimientos;
	Hanoi hanoi=new Hanoi();
	HanoiRecursivo hanoiR = new HanoiRecursivo();
	sc = new Scanner(System.in);
	
	System.out.println("¿Cuantos anillos tiene tu torre?");
	hanoi.setAnillo(sc.nextInt() );
	hanoiR.setAnillo(sc.nextInt());
	hanoiR.setTorre1(1);
	hanoiR.setTorre2(2);
	hanoiR.setTorre3(3);
	
	hanoi.numeroMovimientos();
	hanoiR.secuencia(hanoiR.getAnillo(), hanoiR.getTorre1(), hanoiR.getTorre2(), hanoiR.getTorre3());
	movimientos = hanoiR.getMovimientos();
	System.out.println("Los movimientos necesarios para esta torre son "+ hanoi.getMovimientos()+"O estos: "+movimientos);
	hanoi.setTorre1(null);
	hanoi.setTorre2(null);
	hanoi.setTorre3(null);
}
}
