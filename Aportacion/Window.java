

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.event.*;


public class Window extends Application {
	
	
	private Scene scene;
	private Pane base;
	public  Pane canvas;
	private VBox everything;
	private HBox menu;
	private Button insert, delete, find;
	private Label lbl, title;
	private TextField toInsert, toDelete, toFind;
	protected Avl <Integer> arbol = new Avl<>();
	protected printerChido print= new printerChido<>();
	
	
	@Override
	public void start(Stage stage0) throws Exception {
		stage0.setTitle("Figuras");
		stage0.setResizable(true);
		stage0.show();
		
		
		initComponents(stage0);
		
		
	}
	
	public void initComponents(Stage stage0) {
		//paneles
		menu= new HBox(6);
		menu.setId("menu");
		everything= new VBox(2);
		canvas= new Pane();
		base= new Pane(everything);
		scene= new Scene(base,1000,500);
		base.setId("total");
		scene.getStylesheets().add("styles.css");
		
	
		//objetos dentro del menu
		
		insert= new Button("Insert");
		insert.setOnAction(new createNode());
		insert.setId("insert");
		toInsert= new TextField(     );
		delete= new Button("Delete");
		delete.setOnAction(new deleteNode());
		delete.setId("delete");
		toDelete= new TextField(     );
		find= new Button("Find");
		find.setOnAction(new findNode());
		find.setId("find");
		toFind= new TextField(       );
		lbl = new Label("");
		lbl.setId("label");
		title = new Label("ARBOL AVL");
		title.setId("title");
		
		
		menu.getChildren().add(insert);
		menu.getChildren().add(toInsert);
		menu.getChildren().add(delete);
		menu.getChildren().add(toDelete);
		menu.getChildren().add(find);
		menu.getChildren().add(toFind);
		menu.getChildren().add(lbl);
		menu.getChildren().add(title);
		
		everything.getChildren().addAll(menu,canvas);
		printLog("Canvas Listo");
		
		stage0.setScene(scene);
	}
	

	//* Listener
	public void printLog(String texto) {
		lbl.setText(texto);
	}
	
	public class createNode implements EventHandler<ActionEvent>{
		public void handle(	ActionEvent add){
			canvas.getChildren().clear();
				int x=0;
				try {
				x=Integer.parseInt(toInsert.getText().toString());
					arbol.insertarElemento(x);
					printLog("Se agrego el elemento '" + x+ "'");
					System.out.println(arbol.getRaiz().getElemento());
					print.printNodo(arbol.getRaiz(), canvas);
					toInsert.setText(null);
				}catch(java.lang.NullPointerException jN) {
				}catch(java.lang.NumberFormatException jE) {
					int count=0;
					for(int i = 0; i < toInsert.getText().length(); i++) {    
			            if(toInsert.getText().charAt(i) != ' ')    
			                count++;    
			        }
					arbol.insertarElemento(count);
				}
				canvas.getChildren().clear();
				print.printNodo(arbol.getRaiz(), canvas);

		}}
	  
	  public class deleteNode implements EventHandler<ActionEvent>{
			public void handle(	ActionEvent add){
				canvas.getChildren().clear();
					try {
					int x=Integer.parseInt(toDelete.getText().toString());
						arbol.eliminarElemento(x);
						printLog("Se elimino el elemento '" + x+ "'");
						print.printNodo(arbol.getRaiz(), canvas);
						toDelete.setText(null);
						
					}catch(java.lang.NullPointerException jNn){
						canvas.getChildren().clear();
						print.printNodo(arbol.getRaiz(), canvas);
						
						toDelete.setText(null);
					}
					catch(java.lang.NumberFormatException muero) {
						arbol.eliminarElemento(0);
					}
			}}
	  
	  public class findNode implements EventHandler<ActionEvent>{
			public void handle(	ActionEvent add){
				int x;
				try {
				x=Integer.parseInt(toFind.getText().toString());
				printLog("Se localizo el elemento '" + x+ "'");
				arbol.recorreEnPostOrden(x, canvas);
				}catch( java.lang.NumberFormatException jN) {
					}
				
				toFind.clear();
			}}
	  
	  
	  
	  

}

	
	
	


