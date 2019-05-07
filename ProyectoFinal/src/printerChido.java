import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class printerChido<T extends Comparable<T>> {

	double distanceY = 65;

	private int maxLevel(Nodo<T> Nodo) {
			if (Nodo == null) {
					return 0;
			}
			return Math.max(maxLevel(Nodo.getIzquierda()), maxLevel(Nodo.getDerecha())) + 1;
	}

	public void printNodo(Nodo<T> nodo, Pane pane) {

		int maxLevel = maxLevel(nodo);
			trazarLinea(nodo, pane, pane.getWidth()/2, distanceY, pane.getWidth()/5, 1, maxLevel);

	}

	private void trazarLinea(Nodo<T>root, Pane pane, double pointX, double pointY, double distanceX, int level, int maxLevel) {

			int floor = maxLevel - level; //nivel actual del arbol
			distanceX = 7*Math.pow(2, (floor + 1)) - 1; // multiplicador de la distancia en x dependiendo del nivel o altura
		if(root!=null) {//pinta los nodos
			root.getCircle().setFill(Color.BLACK);
		    root.getCircle().setStroke(Color.BLACK);
		    root.getCircle().setStrokeWidth(5);
		    root.getCircle().setRadius(25);
		    //se le dan las coordenadas originales "nodo/raiz"
		    root.getCircle().setCenterX(pointX);
		    root.getCircle().setCenterY(pointY);
		    root.getCircle().setId("circles");
		
		    String poner=String.valueOf(root.getElemento());
		    Text texto= new Text(poner);
		    texto.setFill(Color.ANTIQUEWHITE);
		    texto.setId("circleText");
			root.setTexto(texto);
			root.getTexto().setX(root.getCircle().getCenterX());
			root.getTexto().setY(root.getCircle().getCenterY());
		
		
			pane.getChildren().add(root.getCircle());
		    pane.getChildren().add(root.getTexto());
		}
		//se checa si el nodo tiene hijos izq o derechos
		try {
			if(root.getDerecha()!=null) {
				double difX = pointX+distanceX; //que tanto se cambia la distancia con respecto al nodo padre en el eje x
				double difY = pointY+distanceY; //que tanto se cambia la distancia con respecto al nodo padre en el eje y
				trazarLinea(root.getDerecha(), pane, difX, difY, distanceX/2, level+1, maxLevel); //se divide sobre 2 pues hay 2 nodos
				//La linea se traza del nodo hijo al padre
				root.getLineaDerecha().setStartX(difX);
			    root.getLineaDerecha().setStartY(difY);
			    root.getLineaDerecha().setEndX(pointX);
			    root.getLineaDerecha().setEndY(pointY);
			    pane.getChildren().add(root.getLineaDerecha());
			}

			if(root.getIzquierda()!=null) {
				double difX = pointX-distanceX;//que tanto se cambia la distancia con respecto al nodo padre en el eje x, se resta porque va a la izquierda
				double difY = pointY+distanceY; // distanceY es estatico pues no varia en ese eje, (no cambia la diferencial, solo la coordenada)
				//Se le suma un nivel hasta llegar al nivel maximo para determinar la distancia entre los nodos
				trazarLinea(root.getIzquierda(), pane, difX, difY, distanceX/2, level+1, maxLevel);
				root.getLineaIzquierda().setStartX(difX);
				root.getLineaIzquierda().setStartY(difY);
				root.getLineaIzquierda().setEndX(pointX);
				root.getLineaIzquierda().setEndY(pointY);
				pane.getChildren().add(root.getLineaIzquierda());
			}
		}catch(java.lang.NullPointerException jN) {

		}
    }
}
