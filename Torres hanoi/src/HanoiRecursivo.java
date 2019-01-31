
public class HanoiRecursivo {
	private int anillo, movimientos=0;
	public int getAnillo() {
		return anillo;
	}

	public void setAnillo(int anillo) {
		this.anillo = anillo;
	}

	public int getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(int movimientos) {
		this.movimientos = movimientos;
	}
	

	public void recursividad(int n, int torre1,  int torre2, int torre3){
		  if(n>=1) {
		      recursividad(n-1, torre1, torre3, torre2);
		      System.out.println("Pasar disco "+n+" de torre "+ torre1 + " a torre " + torre3);
		      sumatoria();
		      recursividad(n-1, torre2, torre1, torre3);
		  }
		  if(n==0) {

		  }
	}
	public void sumatoria() {
		setMovimientos(getMovimientos()+1);
		
	}
}