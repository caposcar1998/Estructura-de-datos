import java.util.*;



public class Main {

	public static void main(String[] args) {
		Scanner taco=new Scanner(System.in);
		
		Hanoi hanoi=new Hanoi();
		System.out.println("Cuantos anillos usaras?");
		hanoi.setAnillo(taco.nextInt());
		hanoi.numeroMovimientos();
		System.out.println("El numero de movimientos es de "+hanoi.getMovimiento());
		hanoi.setNumero1(new int[hanoi.getAnillo()] );
		hanoi.setNumero2(new int[hanoi.getAnillo()] );
		hanoi.setNumero3(new int[hanoi.getAnillo()] );
		hanoi.setTorre1(hanoi.getNumero1());
		hanoi.setTorre2(hanoi.getNumero2());
		hanoi.setTorre3(hanoi.getNumero3());
		
		hanoi.llenarTorre1();
		hanoi.llenarTorresVacias();
		
		hanoi.algo(hanoi.getAnillo(), hanoi.getTorre1(), hanoi.getTorre2(), hanoi.getTorre3());
		
		
		
		
	
		taco.close();
	
	}

}
