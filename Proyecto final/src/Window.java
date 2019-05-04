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
		everything= new VBox(2);
		canvas= new Pane();
		base= new Pane(everything);
		scene= new Scene(base,1000,500);
		
	
		//objetos dentro del menu
		
		insert= new Button("Insert");
		insert.setOnAction(new createNode());
		toInsert= new TextField(     );
		delete= new Button("Delete");
		delete.setOnAction(new deleteNode());
		toDelete= new TextField(     );
		find= new Button("Find");
		find.setOnAction(new findNode());
		toFind= new TextField(       );
		
		
		menu.getChildren().add(insert);
		menu.getChildren().add(toInsert);
		menu.getChildren().add(delete);
		menu.getChildren().add(toDelete);
		menu.getChildren().add(find);
		menu.getChildren().add(toFind);
		
		everything.getChildren().addAll(menu,canvas);
		
		stage0.setScene(scene);
	}
	

	//* Listener
	   
	


	public class createNode implements EventHandler<ActionEvent>{
		public void handle(	ActionEvent add){
			canvas.getChildren().clear();
			int x=0;
			try {
			x=Integer.parseInt(toInsert.getText());
			arbol.insertarElemento(x);
			}catch(java.lang.NumberFormatException nf) {
				String palabra=toInsert.getText();
				int count=0;
			    for(int i = 0; i < palabra.length(); i++) {    
		            if(palabra.charAt(i) != ' ')    
		                count++;    
		        }
			    arbol.insertarElemento(count);
			}
			//Método que pone objetos dentro del panel
			// este metodo tiene que recibir el nodo a insertar, no la raíz
			//arbol.ponerNodo(arbol.getRaiz(), canvas);
			System.out.println(arbol.getRaiz().getElemento());
			print.pintarArbol(arbol.getRaiz(), canvas, 500, 100);
			toInsert.setText(null);
			
		}}
	  
	  public class deleteNode implements EventHandler<ActionEvent>{
			public void handle(	ActionEvent add){
				System.out.println("Huevos");
			}}
	  
	  public class findNode implements EventHandler<ActionEvent>{
			public void handle(	ActionEvent add){
				System.out.println("Huevos");
			}}
	  
	  
	  
	  

}

	
	
	


