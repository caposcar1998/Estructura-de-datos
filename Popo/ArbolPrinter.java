
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;


public class ArbolPrinter<T extends Comparable<T>> {

	Pane pane;
	Avl usar;

    public void printNodo(Nodo<T> root, Pane pane) {
    	System.out.println("Aqui entra");
        int maxLevel = maxLevel(root);


		printNodoInternal(Collections.singletonList(root), 1, maxLevel, pane);
    }

    private void printNodoInternal(List<Nodo<T>> Nodos, int level, int maxLevel, Pane pane) {
        if (Nodos.isEmpty() || isAllElementsNull(Nodos))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        ArbolPrinter.printWhitespaces(firstSpaces);

        List<Nodo<T>> newNodos = new ArrayList<Nodo<T>>();
        for (Nodo<T> Nodo : Nodos) {
            if (Nodo != null) {
            	System.out.println(maxLevel);
            	if(maxLevel==1) {
            		
            		String poner=String.valueOf(Nodo.getElemento());
                    Text text= new Text(poner);
                    Circle circle= new Circle();
                    Line izquierda= new Line();
                    Line derecha= new Line();
                    circle.setRadius(50);
                    circle.setCenterX(50);
                    circle.setCenterY(250);
                    circle.setFill(Color.TRANSPARENT);
                    circle.setStroke(Color.BLACK);
                    text.setX(circle.getCenterX());
                    text.setY(circle.getCenterY());
                    
                    izquierda.setStartX(circle.getCenterX());
                    izquierda.setStartY(circle.getCenterY());
                    izquierda.setEndX(50);
                    izquierda.setEndY(100);
                    derecha.setStartX(circle.getCenterX());
                    derecha.setStartY(circle.getCenterY());
                    derecha.setEndX(800);
                    derecha.setEndY(100);
                    
                    pane.getChildren().add(derecha);
                    pane.getChildren().add(izquierda);
                    pane.getChildren().add(text);
                    pane.getChildren().add(circle);
                    
            		
            	}	else {
            		String poner=String.valueOf(Nodo.getElemento());
                    Text text= new Text(poner);
                    Circle circle= new Circle();
                    Line izquierda= new Line();
                    Line derecha= new Line();
                    circle.setRadius(50);
                    circle.setCenterX(50);
                    circle.setCenterY(250);
                    circle.setFill(Color.TRANSPARENT);
                    circle.setStroke(Color.BLACK);
                    text.setX(circle.getCenterX());
                    text.setY(circle.getCenterY());
                    
                    izquierda.setStartX(circle.getCenterX());
                    izquierda.setStartY(circle.getCenterY());
                    izquierda.setEndX(50);
                    izquierda.setEndY(100);
                    derecha.setStartX(circle.getCenterX());
                    derecha.setStartY(circle.getCenterY());
                    derecha.setEndX(800);
                    derecha.setEndY(100);
                    
                    pane.getChildren().add(derecha);
                    pane.getChildren().add(izquierda);
                    pane.getChildren().add(text);
                    pane.getChildren().add(circle);
            	}
            	
                System.out.print(Nodo.getElemento());
                
                

                newNodos.add(Nodo.getIzquierda());
                newNodos.add(Nodo.getDerecha());
            } else {
                newNodos.add(null);
                newNodos.add(null);
                System.out.print(" ");
            }

            ArbolPrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < Nodos.size(); j++) {
                ArbolPrinter.printWhitespaces(firstSpaces - i);
                if (Nodos.get(j) == null) {
                    ArbolPrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (Nodos.get(j).getIzquierda() != null) {
                    System.out.print("/");
                    
					
                  

                }else
                    ArbolPrinter.printWhitespaces(1);

                ArbolPrinter.printWhitespaces(i + i - 1);

                if (Nodos.get(j).getDerecha() != null) {
                    System.out.print("\\");

                }else
                    ArbolPrinter.printWhitespaces(1);

                ArbolPrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodoInternal(newNodos, level + 1, maxLevel, pane);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private int maxLevel(Nodo<T> Nodo) {
        if (Nodo == null)
            return 0;

        return Math.max(maxLevel(Nodo.getIzquierda()), maxLevel(Nodo.getDerecha())) + 1;
    }

    private boolean isAllElementsNull(List<Nodo<T>> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
}
