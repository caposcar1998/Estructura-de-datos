import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class GuiPrint<T extends Comparable<T>> {

   public void printNodo(Nodo <T> nodo, Pane pane) {
	  int nivelMax=nivelMax(nodo);
	   
   		}
	   
		   private int nivelMax(Nodo<T> nodo) {
	// TODO Auto-generated method stub
	return 0;
}

		Circle circle= new Circle();
		   Line lineIz= new Line();
		   Line linedEr= new Line();
		   circle.setRadius(50);
		   circle.setCenterX(500);
		   circle.setCenterY(50);
		   lineIz.setStartX(circle.getCenterX());
		   lineIz.setStartY(circle.getCenterY());
		   lineIz.setEndX(300);
		   lineIz.setEndY(30);
		   linedEr.setStartX(circle.getCenterX());
		   linedEr.setStartY(circle.getCenterY());
		   
		   pane.getChildren().add(circle);
		   pane.getChildren().add(lineIz);
		   pane.getChildren().add(linedEr);
		   
		   printNodo();
		   
	   
	   
   }
    
    

