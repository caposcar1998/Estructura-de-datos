import java.util.Arrays;

public class Hanoi {

	private int anillo;
	private int[] torre1;
	private int[]torre2;
	private int[] torre3;
	private int movimiento;
	private int[]numero1, numero2, numero3;
	
	
	
		
	public int getAnillo() {
		return anillo;
	}
	public void setAnillo(int anillo) {
		this.anillo = anillo;
	}
	public int getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(int movimiento) {
		this.movimiento = movimiento;
	}
	public int[] getTorre1() {
		return torre1;
	}
	public void setTorre1(int[] torre1) {
		this.torre1 = torre1;
	}
	public int[] getTorre3() {
		return torre3;
	}
	public void setTorre3(int[] torre3) {
		this.torre3 = torre3;
	}
	public int[] getTorre2() {
		return torre2;
	}
	public void setTorre2(int[] torre2) {
		this.torre2 = torre2;
	}
	public int[] getNumero2() {
		return numero2;
	}
	public void setNumero2(int[] numero2) {
		this.numero2 = numero2;
	}
	public int[] getNumero1() {
		return numero1;
	}
	public void setNumero1(int[] numero1) {
		this.numero1 = numero1;
	}
	public int[] getNumero3() {
		return numero3;
	}
	public void setNumero3(int[] numero3) {
		this.numero3 = numero3;
	}
	public int numeroMovimientos() {
		movimiento=(int) (Math.pow(2, getAnillo())-1);
		return movimiento;
		
	}

	public void llenarTorre1() {
		int variable=getAnillo();
		for(int i=0;i<getAnillo();i++) {
			getTorre1()[i]=variable;
			variable=variable-1;
		
		}	
		System.out.println("");
	}//fin llenar torre 1
			
	public void llenarTorresVacias() {		
		for(int i=0;i<getTorre2().length;i++) {
			
			getTorre2()[i]=0;
			getTorre3()[i]=0;
			
		}	
		
		}//fin torres vacias
	
	
	
	
	
	
	
	
	
	public void algo(int n, int[]a, int[]b, int[]c) {
	
		if(n==1) {
			//de torre a a torre c
			for(int i=0;i<c.length;i++) {
				if(c[i]==0) {
				c[i]=a[0];
				a[0]=0;
				}
				
			}
			
			
			
			//fin mamada
			System.out.println(Arrays.toString(getTorre1()));
			System.out.println(Arrays.toString(getTorre2()));
			System.out.println(Arrays.toString(getTorre3()));
			System.out.println("");
			
		}else {
			algo(n-1, a, c, b);
			//mamada de torre a a a c
			
			for(int i=0;i<a.length;i++) {
				if(a[i]<n & c[i]==0) {
					c[i]=a[i];
					a[i]=0;
					}
				
				
			}
			
			
				
			//fin mamada
			System.out.println(Arrays.toString(getTorre1()));
			System.out.println(Arrays.toString(getTorre2()));
			System.out.println(Arrays.toString(getTorre3()));
			System.out.println("");
			algo(n-1,b,a,c);
			
			}//fin if
			
		}//fin método
	
	
	
}
	
	
		
	
	
	
	
	