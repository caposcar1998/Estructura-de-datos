import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class printerChido<T extends Comparable<T>> {
	
	Pane pane;
	Nodo<T> nodito;
	
	public void pintarArbol(Nodo<T> root, Pane pane, int x, int y) {
		
		
		root.getCircle().setFill(Color.TRANSPARENT);
        root.getCircle().setStroke(Color.BLACK);
        root.getCircle().setRadius(50);
        root.getCircle().setCenterX(x);
        root.getCircle().setCenterY(y);
        String poner=String.valueOf(root.getElemento());
        Text texto= new Text(poner);
		root.setTexto(texto);
		root.getTexto().setX(root.getCircle().getCenterX());
		root.getTexto().setY(root.getCircle().getCenterY());
		
		pane.getChildren().add(root.getCircle());
        pane.getChildren().add(root.getTexto());
        if(root.getDerecha()!=null) {
        	pintarArbol(root.getDerecha(), pane, x+250, y+100);
        }
        if(root.getIzquierda()!=null) {
        	pintarArbol(root.getIzquierda(), pane, x-150, y+100);
        }
	}
	
}
