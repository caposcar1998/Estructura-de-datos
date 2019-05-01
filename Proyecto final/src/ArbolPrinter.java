
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class ArbolPrinter<T extends Comparable<T>> {
	Nodo<T> temp;
	Pane pane;
	
    public void printNodo(Nodo<T> root, Pane pane) {
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
                System.out.print(Nodo.getElemento());
                
                //Poner nodo en canvas
                Nodo.getCircle().setFill(Color.TRANSPARENT);
                Nodo.getCircle().setStroke(Color.BLACK);
                Nodo.getCircle().setRadius(50);
                Nodo.getCircle().setCenterX(500);
                Nodo.getCircle().setCenterY(50);
                //Poner texto en nodo
                String poner=String.valueOf(Nodo.getElemento());
                Text texto= new Text(poner);
        		Nodo.setTexto(texto);
        		Nodo.getTexto().setX(Nodo.getCircle().getCenterX());
        		Nodo.getTexto().setY(Nodo.getCircle().getCenterY());
                pane.getChildren().add(Nodo.getCircle());
                pane.getChildren().add(Nodo.getTexto());
                
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
                    //No hace nada
                	temp.getLineaIzquierda().setStartX(temp.getCircle().getCenterX());
            		temp.getLineaIzquierda().setStartY(temp.getCircle().getCenterY());
                	temp.getLineaIzquierda().setEndX(0);
                	temp.getLineaIzquierda().setEndY(0);
                
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
