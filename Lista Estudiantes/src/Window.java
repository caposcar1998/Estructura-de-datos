
import javax.swing.JTable;

import com.sun.glass.events.KeyEvent;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Window extends Application {
	
	HashTable <Integer, Student> lista= new HashTable<>();
	private VBox opciones;
	private Scene verOpciones;
	private Label pedirNombre, pedirMatricula, pedirCalificacion, buscarMatriculaEnSistema,  mostrarMatricula;
	private Button anadir, buscar, regresar;
	private TextField nombre, matricula, calificacion, buscarMatricula;
	private GridPane listaFinal;
	
	
	@Override
	public void start(Stage stage0) throws Exception {
		stage0.setTitle("Tecnologico de Monterrey");
		stage0.setResizable(true);
		stage0.show();
		
		initComponents(stage0);
		
		
		
		
	}

	private void initComponents(Stage stage0) {
		printInterfaz();
		opciones= new VBox(12);
		verOpciones= new Scene(opciones,1000,1000);
		pedirNombre= new Label("Introducir nombre");
		opciones.getChildren().add(pedirNombre);
		nombre= new TextField(                         );
		opciones.getChildren().add(nombre);
		pedirMatricula=new Label("Introducir matricula");
		opciones.getChildren().add(pedirMatricula);
		matricula= new TextField(                            );
		opciones.getChildren().add(matricula);
		pedirCalificacion=new Label("Introducir calificacion");
		opciones.getChildren().add(pedirCalificacion);
		calificacion=new TextField(                          );
		opciones.getChildren().add(calificacion);
		anadir= new Button("Anadir");
		opciones.getChildren().add(anadir);
		anadir.setOnAction(new actualizar() );
		buscarMatriculaEnSistema= new Label("Matricula a buscar");
		opciones.getChildren().add(buscarMatriculaEnSistema);
		buscarMatricula= new TextField(                       );
		opciones.getChildren().add(buscarMatricula);
		buscar= new Button("Buscar matricula");
		opciones.getChildren().add(buscar);
		buscar.setOnAction(new buscarMatriculaEnElSiustema() );
		mostrarMatricula= new Label("Resultado");
		opciones.getChildren().add(mostrarMatricula);
		
		
		listaFinal= new GridPane();
		printInterfaz();
		
		
		opciones.getChildren().add(listaFinal);
		stage0.setScene(verOpciones);
		
		
		
		
		
		
	}
	
	
	public void printInterfaz() {
		
		for (int i=0; i<lista.getEntries().length;i++) {
			
			try {
				if(lista.getEntries()[i]!=null) {
					listaFinal.add(new Label(i+""+lista.getEntries()[i].getValue().toString()),1,i);
				}else {
					listaFinal.add(new Label("Nada"), 1, i);
				}
			}catch(NullPointerException e) {
				
			}
		}
	}
	
	
	
	
	
	public class actualizar implements EventHandler<ActionEvent>{
		public void handle(	ActionEvent e){
			try {
			String nombreGene;
			String calif;
			int matr;
			
			Student student=new Student(nombreGene=nombre.getText().toString(), calif=calificacion.getText().toString(), matr=Integer.parseInt(matricula.getText()));
			lista.insert(student.hashCode(), student);
			}catch(NumberFormatException c) {
				
			}
			lista.print();
			nombre.clear();
			matricula.clear();
			calificacion.clear();
			opciones.getChildren().remove(listaFinal);
			printInterfaz();
		}

	}
	
	public class buscarMatriculaEnElSiustema implements EventHandler<ActionEvent>{
		public void handle(	ActionEvent e){
			int x;
			try {
			x=Integer.parseInt(buscarMatricula.getText());
			lista.getValue(x);
			System.out.println(lista.getValue(x).getCalificacion());
			mostrarMatricula.setText(" El estudiante "+ lista.getValue(x).getNombre() +" tiene "+lista.getValue(x).getCalificacion()+" de calificacion");
			buscarMatricula.clear();
			}catch( java.lang.NumberFormatException g) {}
		}
	}
	
	

}
