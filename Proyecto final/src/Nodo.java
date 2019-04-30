import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class Nodo<T extends Comparable<T>> {
	
	private T elemento; 
	private Nodo<T> izquierda;
	private Nodo<T> derecha;
	private int altura;
	private Circle circle;
	private Line lineaIzquierda;
	private Line lineaDerecha;
	private Text texto;
	
	
	public Nodo(T elemento) {
		this.circle=new Circle();
		this.lineaIzquierda=new Line();
		this.lineaDerecha= new Line();
		this.texto=new Text();
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
	public Line getLineaIzquierda() {
		return lineaIzquierda;
	}
	public void setLineaIzquierda(Line lineaIzquierda) {
		this.lineaIzquierda = lineaIzquierda;
	}
	public Line getLineaDerecha() {
		return lineaDerecha;
	}
	public void setLineaDerecha(Line lineaDerecha) {
		this.lineaDerecha = lineaDerecha;
	}
	public Text getTexto() {
		return texto;
	}
	public void setTexto(Text texto) {
		this.texto = texto;
	}
	

}
