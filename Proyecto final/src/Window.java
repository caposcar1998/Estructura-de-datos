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
			try {
				

				String x=toInsert.getText().toString();
				int y = Integer.parseInt(x);
				if(x!=null) {
					arbol.insertarElemento(y);
					System.out.println(arbol.getRaiz().getElemento());
					print.printNodo(arbol.getRaiz(), arbol, canvas);
					toInsert.setText(null);
					
				
				}
				
		       
	        }catch(java.lang.NullPointerException jN) {
				canvas.getChildren().clear();
				print.printNodo(arbol.getRaiz(), arbol, canvas);
				

        }
			
		}}
	  
	  public class deleteNode implements EventHandler<ActionEvent>{
			public void handle(	ActionEvent add){
				canvas.getChildren().clear();
				try {
					

					String x=toDelete.getText().toString();
					int y = Integer.parseInt(x);
					if(x!=null) {
						arbol.eliminarElemento(y);
						System.out.println(arbol.getRaiz().getElemento());
						print.printNodo(arbol.getRaiz(), arbol, canvas);
						
						toDelete.setText(null);
					
					}
					
			       
		        }catch(java.lang.NullPointerException jN) {
					canvas.getChildren().clear();
					print.printNodo(arbol.getRaiz(), arbol, canvas);
					
					toDelete.setText(null);
	        }
				
				
			}}
	  
	  public class findNode implements EventHandler<ActionEvent>{
			public void handle(	ActionEvent add){
				String x;
				Nodo<Integer> nodo;
				try {
				x=toFind.getText().toString();
				int y = Integer.parseInt(x);
				nodo = arbol.recorreEnPostOrden(y, canvas);
				}catch(java.lang.NumberFormatException jN) {
					}
				
				toFind.clear();
			}}
	  
	  
	  
	  

}

	
	
	


