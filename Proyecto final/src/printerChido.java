import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class printerChido<T extends Comparable<T>> {
	
	
	
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
        	 root.getLineaDerecha().setStartX(x);
             root.getLineaDerecha().setStartY(y);
             root.getLineaDerecha().setEndX(root.getDerecha().getCircle().getCenterX());
             root.getLineaDerecha().setEndY(root.getDerecha().getCircle().getCenterY());
             pane.getChildren().add(root.getLineaDerecha());
        	
        }
        if(root.getIzquierda()!=null) {
        	pintarArbol(root.getIzquierda(), pane, x-250, y+100);
        	 root.getLineaIzquierda().setStartX(x);
             root.getLineaIzquierda().setStartY(y);
             root.getLineaIzquierda().setEndX(root.getIzquierda().getCircle().getCenterX());
             root.getLineaIzquierda().setEndY(root.getIzquierda().getCircle().getCenterY());
             pane.getChildren().add(root.getLineaIzquierda());
        }
	}
	
}
