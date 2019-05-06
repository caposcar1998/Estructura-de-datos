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
	protected Avl <String> arbol = new Avl<>();
	protected printerChido print= new printerChido<>();
	protected PrinterChafa printF = new PrinterChafa<>();
	
	

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
				if(x!=null) {
					arbol.insertarElemento(x);
					System.out.println(arbol.getRaiz().getElemento());
					print.printNodo(arbol.getRaiz(), canvas);
					toInsert.setText(null);
					printF.printNodo(arbol.getRaiz());
				
				}
				
		       
	        }catch(java.lang.NullPointerException jN) {
				canvas.getChildren().clear();
				print.printNodo(arbol.getRaiz(), canvas);
				printF.printNodo(arbol.getRaiz());

        }
			
		}}
	  
	  public class deleteNode implements EventHandler<ActionEvent>{
			public void handle(	ActionEvent add){
				canvas.getChildren().clear();
				try {
					

					String x=toDelete.getText().toString();
					if(x!=null) {
						arbol.eliminarElemento(x);
						System.out.println(arbol.getRaiz().getElemento());
						print.printNodo(arbol.getRaiz(), canvas);
						printF.printNodo(arbol.getRaiz());
						toDelete.setText(null);
					
					}
					
			       
		        }catch(java.lang.NullPointerException jN) {
					canvas.getChildren().clear();
					print.printNodo(arbol.getRaiz(), canvas);
					printF.printNodo(arbol.getRaiz());
					toDelete.setText(null);
	        }
				
				
			}}
	  
	  public class findNode implements EventHandler<ActionEvent>{
			public void handle(	ActionEvent add){
				String x;
				try {
				x=toFind.getText().toString();
				arbol.recorreEnPostOrden(x, canvas);
				}catch( java.lang.NumberFormatException jN) {
					}
				
				toFind.clear();
			}}
	  
	  
	  
	  

}

	
	
	


