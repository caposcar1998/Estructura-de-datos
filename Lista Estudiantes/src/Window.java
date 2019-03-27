
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
	private Label pedirNombre, pedirMatricula, pedirCalificacion, buscarMatriculaEnSistema, listaFinal, mostrarMatricula;
	private Button anadir, buscar, regresar;
	private TextField nombre, matricula, calificacion, buscarMatricula;
	
	
	@Override
	public void start(Stage stage0) throws Exception {
		stage0.setTitle("Tecnologico de Monterrey");
		stage0.setResizable(true);
		stage0.show();
		
		initComponents(stage0);
		
		
		
		
	}

	private void initComponents(Stage stage0) {
		
		opciones= new VBox(12);
		verOpciones= new Scene(opciones,1000,1000);
		pedirNombre= new Label("Introducir nombre");
		opciones.getChildren().add(pedirNombre);
		nombre= new TextField("                  ");
		opciones.getChildren().add(nombre);
		pedirMatricula=new Label("Introducir matricula");
		opciones.getChildren().add(pedirMatricula);
		matricula= new TextField("                    ");
		opciones.getChildren().add(matricula);
		pedirCalificacion=new Label("Introducir calificacion");
		opciones.getChildren().add(pedirCalificacion);
		calificacion=new TextField("                    ");
		opciones.getChildren().add(calificacion);
		anadir= new Button("Anadir");
		opciones.getChildren().add(anadir);
		anadir.setOnAction(new actualizar() );
		buscarMatriculaEnSistema= new Label("Matricula a buscar");
		opciones.getChildren().add(buscarMatriculaEnSistema);
		buscarMatricula= new TextField("             ");
		opciones.getChildren().add(buscarMatricula);
		buscar= new Button("Buscar matricula");
		opciones.getChildren().add(buscar);
		buscar.setOnAction(new buscarMatriculaEnElSiustema() );
		mostrarMatricula= new Label("Resultado");
		opciones.getChildren().add(mostrarMatricula);
		listaFinal= new Label();
		//poner en la lsita
		stage0.setScene(verOpciones);
		
		
		
		
		
		
	}
	
	public class actualizar implements EventHandler<ActionEvent>{
		public void handle(	ActionEvent e){
			String nombreGene;
			String calif;
			int matr;
			
			Student student=new Student(nombreGene=nombre.getText().toString(), calif=calificacion.getText().toString(), matr=Integer.parseInt(matricula.getText()));
			lista.insert(student.hashCode(), student);
			lista.print();
			nombre.clear();
			matricula.clear();
			calificacion.clear();
		}

	}
	
	public class buscarMatriculaEnElSiustema implements EventHandler<ActionEvent>{
		public void handle(	ActionEvent e){
			
			
		}
	}
	
	

}
