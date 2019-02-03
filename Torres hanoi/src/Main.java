import java.util.Scanner;

public class Main {
private static Scanner sc;

public static void main(String []main) {
	
	HanoiRecursivo hanoiR = new HanoiRecursivo();
	sc = new Scanner(System.in);
	
	System.out.println("¿Cuantos anillos tiene tu torre?");

	hanoiR.setAnillo(sc.nextInt());
	
	hanoiR.recursividad(hanoiR.getAnillo(), 1, 2, 3);
	
	System.out.println("Los movimientos necesarios para esta torre son "+hanoiR.getMovimientos());
}
}
