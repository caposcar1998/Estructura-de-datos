import javafx.scene.shape.Circle;

public class Nodo<T extends Comparable<T>> {
	
	private T elemento; 
	private Nodo<T> izquierda;
	private Nodo<T> derecha;
	private int altura;
	private Circle circle;
	
	public Nodo(T elemento) {
		this.elemento=elemento;
	}
	public T getElemento() {
		return elemento;
	}
	public void setElemento(T elemento) {
		this.elemento = elemento;
	}
	public Nodo<T> getIzquierda() {
		return izquierda;
	}
	public void setIzquierda(Nodo<T> izquierda) {
		this.izquierda = izquierda;
	}
	public Nodo<T> getDerecha() {
		return derecha;
	}
	public void setDerecha(Nodo<T> derecha) {
		this.derecha = derecha;
	}
	
	public int compareTo(T arg0) {
		// ODO Auto-generated method stub
		return 0;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	

}
