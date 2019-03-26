
public class Student {
	
	

	private String nombre;
	private String calificacion;
	private int matricula;
	
	
	public Student(String nombre, String calificacion, int matricula) {
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
	public double getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public int hashCode() {
		return matricula;
	}
	
	@Override
	public boolean equals(Object o) {
		Student p= (Student)o;
		return p.hashCode()==hashCode();
		
	}
	
	public String toString() {
		return nombre;
	}
	
	
	
	
}
