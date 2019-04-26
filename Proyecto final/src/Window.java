//import javax.swing.JTable;
import com.sun.glass.events.KeyEvent;
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.Orientation;
import javafx.scene.control.*;


public class Window extends Application {
	
	
	private Circle circle, circle2;
	private Scene scene;
	private Text text;
	private StackPane stack;
	private Pane root, base;
	private Line linea;
	private VBox everything;
	private HBox menu;
	private Button insert, delete, find;
	private TextField toInsert, toDelete, toFind;
	
	
	

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
		base= new Pane(everything);
		scene= new Scene(base,1000,1000);
		root = new Pane();
	
	
		
		
		//objetos dentro de panel root
		circle= new Circle();
		circle.setCenterX(500.0f); 
		circle.setCenterY(500.0f); 
		circle.setRadius(50.0f); 
		circle.setFill(Color.RED);
		circle.setId("circulo");
		
		text= new Text("huevos");
		text.setBoundsType(TextBoundsType.VISUAL); 
		stack = new StackPane();
		stack.getChildren().addAll(circle, text);
		stack.setLayoutX(30);
		stack.setLayoutY(30);
		
		circle2= new Circle();
		circle2.setCenterX(800.0f); 
		circle2.setCenterY(500.0f); 
		circle2.setRadius(50.0f); 
		circle2.setFill(Color.RED);
		circle2.setId("circulo");
		
		linea= new Line(circle.getCenterX(),circle.getCenterY(),circle2.getCenterX(),circle2.getCenterY());
		linea.setId("linea");
		
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
		
		//añadir objetos a bases
		
		root.getChildren().add(linea);
		root.getChildren().add(circle);
		root.getChildren().add(circle2);
		
		menu.getChildren().add(insert);
		menu.getChildren().add(toInsert);
		menu.getChildren().add(delete);
		menu.getChildren().add(toDelete);
		menu.getChildren().add(find);
		menu.getChildren().add(toFind);
		
		everything.getChildren().addAll(menu,root);
		
		stage0.setScene(scene);
	}
	

	//* Listener
	   
	


	public class createNode implements EventHandler<ActionEvent>{
		public void handle(	ActionEvent add){
			System.out.println("Huevos");
			
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

	
	
	


