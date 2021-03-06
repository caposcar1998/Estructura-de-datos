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
	
    public void printNodo(Nodo<T> nodo, Avl<T>arbol, Pane pane) {
        
    	int maxLevel = maxLevel(nodo);
        trazarLinea(nodo, arbol, pane, pane.getWidth()/2, distanceY, pane.getWidth()/5, 1, maxLevel);
        
    }
    
    private void trazarLinea(Nodo<T>root, Avl<T>arbol, Pane pane, double pointX, double pointY, double distanceX, int level, int maxLevel) {
    	
        int floor = maxLevel - level;
        distanceX = 7*Math.pow(2, (floor + 1)) - 1;
        
		if(root!=null) {
		root.getCircle().setFill(Color.BLACK);
        root.getCircle().setStroke(Color.BLACK);
        root.getCircle().setStrokeWidth(5);
        root.getCircle().setRadius(25);
        root.getCircle().setCenterX(pointX);
        root.getCircle().setCenterY(pointY);
       
        String poner=String.valueOf(root.getElemento());
        Text texto= new Text(poner);
        texto.setFill(Color.ANTIQUEWHITE);
		root.setTexto(texto);
		root.getTexto().setX(root.getCircle().getCenterX());
		root.getTexto().setY(root.getCircle().getCenterY());
		
		String balance=String.valueOf(arbol.getBalance(root));
		Text balanceGrafico= new Text(balance);
		balanceGrafico.setFill(Color.BLACK);
		balanceGrafico.setId("circleText");
		root.setBalanceVentana(balanceGrafico);
		root.getBalanceVentana().setX(root.getCircle().getCenterX()+30);
		root.getBalanceVentana().setY(root.getCircle().getCenterY());
		
		pane.getChildren().add(root.getCircle());
        pane.getChildren().add(root.getTexto());
		}
		
		try {
			if(root.getDerecha()!=null) {
				double difX = pointX+distanceX;
				double difY = pointY+distanceY;
				trazarLinea(root.getDerecha(), arbol, pane, difX, difY, distanceX/2, level+1, maxLevel);
				root.getLineaDerecha().setStartX(difX);
			    root.getLineaDerecha().setStartY(difY);
			    root.getLineaDerecha().setEndX(pointX);
			    root.getLineaDerecha().setEndY(pointY);
			    pane.getChildren().add(root.getLineaDerecha());
			}
			
			if(root.getIzquierda()!=null) {
				double difX = pointX-distanceX;
				double difY = pointY+distanceY;
				trazarLinea(root.getIzquierda(), arbol, pane, difX, difY, distanceX/2, level+1, maxLevel);
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
