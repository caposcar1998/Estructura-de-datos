
public class HanoiRecursivo {
	private int anillo, torre1, torre2, torre3, movimientos=0;

	public int getTorre1() {
		return torre1;
	}

	public void setTorre1(int torre1) {
		this.torre1 = torre1;
	}

	public int getAnillo() {
		return anillo;
	}

	public void setAnillo(int anillo) {
		this.anillo = anillo;
	}

	public int getTorre2() {
		return torre2;
	}

	public void setTorre2(int torre2) {
		this.torre2 = torre2;
	}

	public int getTorre3() {
		return torre3;
	}

	public void setTorre3(int torre3) {
		this.torre3 = torre3;
	}
	public int getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(int movimientos) {
		this.movimientos = movimientos;
	}
	
	public void secuencia(int anillo, int torre1, int torre2, int torre3) {
		if(getAnillo()>0) {
			secuencia((getAnillo()-1), torre1, torre2, torre3);
			setMovimientos(getMovimientos() + 1);
			secuencia((getAnillo()-1),torre2 ,torre3 ,torre1);
		}
		
	}


}