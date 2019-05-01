
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class ArbolPrinter<T extends Comparable<T>> {
	
	Pane pane;
	Nodo<T> grafico;
	
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
                grafico=Nodo;
                //Poner nodo en canvas
                grafico.getCircle().setFill(Color.TRANSPARENT);
                grafico.getCircle().setStroke(Color.BLACK);
                grafico.getCircle().setRadius(50);
                grafico.getCircle().setCenterX(500);
                grafico.getCircle().setCenterY(50);
                //Poner texto en nodo
                String poner=String.valueOf(Nodo.getElemento());
                Text texto= new Text(poner);
        		Nodo.setTexto(texto);
        		grafico.getTexto().setX(Nodo.getCircle().getCenterX());
        		grafico.getTexto().setY(Nodo.getCircle().getCenterY());
        		grafico.getLineaIzquierda().setStartX(grafico.getCircle().getCenterX());
                grafico.getLineaIzquierda().setStartY(grafico.getCircle().getCenterY());
                grafico.getLineaIzquierda().setEndX(100);
                grafico.getLineaIzquierda().setEndY(100);
        		grafico.getLineaDerecha().setStartX(grafico.getCircle().getCenterX());
        		grafico.getLineaDerecha().setStartY(grafico.getCircle().getCenterY());
                grafico.getLineaDerecha().setEndX(800);
                grafico.getLineaDerecha().setEndY(100);
                pane.getChildren().add(grafico.getLineaDerecha());
        		pane.getChildren().add(grafico.getLineaIzquierda());
                pane.getChildren().add(grafico.getCircle());
                pane.getChildren().add(grafico.getTexto());
                
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
                    grafico.getLineaIzquierda().setStartX(grafico.getCircle().getCenterX());
                    grafico.getLineaIzquierda().setStartY(grafico.getCircle().getCenterY());
                    grafico.getLineaIzquierda().setEndX(110);
                    grafico.getLineaIzquierda().setEndY(110);
                    System.out.println(grafico.getLineaIzquierda());
                	pane.getChildren().add(grafico.getLineaIzquierda());
                
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
