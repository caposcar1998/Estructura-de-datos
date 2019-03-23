
public class Student {
	
	

	private String nombre;
	private String calificacion;
	private String matricula;
	
	
	public Student(String nombre, String calificacion, String matricula) {
		this.nombre=nombre;
		this.calificacion=calificacion;
		this.matricula=matricula;
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
}
