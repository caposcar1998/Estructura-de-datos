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
		stage0.setTitle("Arbol AVL");
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
			printLog("Canvas Listo");
				try {
				String x=toInsert.getText().toString();
				int y = Integer.parseInt(x);
					if(x!=null) {
						arbol.insertarElemento(y);
						System.out.println(arbol.getRaiz().getElemento());
						print.printNodo(arbol.getRaiz(), canvas);
						toInsert.setText(null);
						printLog("Se ha insertado el elemento '" + x + "'"+" y el balance es '"+arbol.getBalance(arbol.getRaiz())+"' en "+arbol.getRaiz().getElemento());
					}
				}catch(java.lang.NullPointerException jN) {
				}catch(java.lang.NumberFormatException jE) {
				canvas.getChildren().clear();
				print.printNodo(arbol.getRaiz(), canvas);
				}
				canvas.getChildren().clear();
				print.printNodo(arbol.getRaiz(), canvas);

		}}

	  public class deleteNode implements EventHandler<ActionEvent>{
			public void handle(	ActionEvent add){

					canvas.getChildren().clear();
					printLog("Canvas Listo");
					
						try {
						String x=toDelete.getText().toString();
						int y = Integer.parseInt(x);
							if(x!=null) {
								arbol.eliminarElemento(y);
								System.out.println(arbol.getRaiz().getElemento());
								print.printNodo(arbol.getRaiz(), canvas);
								toDelete.setText(null);
								if(arbol.getBalance(arbol.getRaiz())==1) {
									printLog("Se ha eliminado el elemento '" + x + "'"+" y se debe añadir un elemento a la izquierda");
								}
								if(arbol.getBalance(arbol.getRaiz())==-1) {
									printLog("Se ha eliminado el elemento '" + x + "'"+" y se debe añadir un elemento a la derecha");
								}
								else {
									printLog("Se ha eliminado el elemento '" + x + "'"+" y el arbol esta perfectamente equilibrado como todo debe estar");
								}
							}
						}catch(java.lang.NullPointerException jN) {
						}catch(java.lang.NumberFormatException jE) {
						canvas.getChildren().clear();
						print.printNodo(arbol.getRaiz(), canvas);
						}
						canvas.getChildren().clear();
						print.printNodo(arbol.getRaiz(), canvas);

			}}

	  public class findNode implements EventHandler<ActionEvent>{
			public void handle(	ActionEvent add){

				String x;
				try {
				x=toFind.getText().toString();
				int y = Integer.parseInt(x);
				arbol.recorreEnPostOrden(y, canvas);
				printLog("Se ha buscado el elemento '" + x + "'");
				}catch(java.lang.NumberFormatException jN) {
				}catch(java.lang.NullPointerException jN) {

				}

				toFind.clear();

			}}





}
