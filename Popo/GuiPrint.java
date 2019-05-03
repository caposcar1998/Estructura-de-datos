import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class GuiPrint<T extends Comparable<T>> {

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

        GuiPrint.printWhitespaces(firstSpaces);

        List<Nodo<T>> newNodos = new ArrayList<Nodo<T>>();
        for (Nodo<T> Nodo : Nodos) {
            if (Nodo != null) {
                System.out.print(Nodo.getElemento());
                
                if(level==1) {
                	System.out.println(floor+"piso");
                	Circle circle= new Circle();
                	Line cenrtalIz= new Line();
                	Line centralDer= new Line();
                	circle.setRadius(50);
                	circle.setCenterX(500);
                	circle.setCenterY(50);
                	circle.setFill(Color.TRANSPARENT);
                    circle.setStroke(Color.BLACK);
                    String poner=String.valueOf(Nodo.getElemento());
                    Text texto= new Text(poner);
                    texto.setX(circle.getCenterX());
                    texto.setY(circle.getCenterY());
                    cenrtalIz.setStartX(circle.getCenterX());
                    cenrtalIz.setStartY(circle.getCenterY());
                    cenrtalIz.setEndX(floor+200);
                    cenrtalIz.setEndY(level*100);
                    
                    centralDer.setStartX(circle.getCenterX());
                    centralDer.setStartY(circle.getCenterY());
                    centralDer.setEndX(floor+800);
                    centralDer.setEndY(level*100);
                    
                    pane.getChildren().add(centralDer);
                    pane.getChildren().add(cenrtalIz);
                    pane.getChildren().add(texto);
                	pane.getChildren().add(circle);
                	
                }else {
                	if(Nodo.getIzquierda()==null ) {
                		
                    	Circle circle=new Circle();
                    	circle.setRadius(50);
                    	circle.setCenterX(floor+200);
                    	circle.setCenterY(level*100);
                    	circle.setFill(Color.TRANSPARENT);
                        circle.setStroke(Color.BLACK);
                    	pane.getChildren().add(circle);
                    	String poner=String.valueOf(Nodo.getElemento());
                        Text texto= new Text(poner);
                        texto.setX(circle.getCenterX());
                        texto.setY(circle.getCenterY());
                        pane.getChildren().add(texto);
                		
                	}
                	if(Nodo.getDerecha()==null ) {
                		
                    	Circle circle=new Circle();
                    	circle.setRadius(50);
                    	circle.setCenterX(floor+800);
                    	circle.setCenterY(level*100);
                    	circle.setFill(Color.TRANSPARENT);
                        circle.setStroke(Color.BLACK);
                    	pane.getChildren().add(circle);
                	}
                	
                }
                
                newNodos.add(Nodo.getIzquierda());
                newNodos.add(Nodo.getDerecha());
            } else {
                newNodos.add(null);
                newNodos.add(null);
                System.out.print(" ");
            }

            GuiPrint.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < Nodos.size(); j++) {
                GuiPrint.printWhitespaces(firstSpaces - i);
                if (Nodos.get(j) == null) {
                    GuiPrint.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (Nodos.get(j).getIzquierda() != null) {
                    System.out.print("/");
                	Line lineaIz= new Line();
                }else
                    GuiPrint.printWhitespaces(1);

                GuiPrint.printWhitespaces(i + i - 1);

                if (Nodos.get(j).getDerecha() != null)
                    System.out.print("\\");
                else
                    GuiPrint.printWhitespaces(1);

                GuiPrint.printWhitespaces(endgeLines + endgeLines - i);
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
