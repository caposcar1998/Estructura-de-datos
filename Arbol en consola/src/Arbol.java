
public class Arbol <T extends Comparable<T>> {
	
private Nodo<T> raiz;
	
	
	public void insertarElemento(T elemento) {
		Nodo<T> nodo= new Nodo<>(elemento);
		if(raiz==null) {
			raiz=nodo;
		}else {
			insertarElementoRec(raiz,nodo);
		}
	}
	
	public Nodo<T> insertarElementoRec(Nodo<T> raiz, Nodo<T> nodoAInsertar) {
		if(raiz==null) {
			return nodoAInsertar;
		}else {
			if(nodoAInsertar.getElemento().compareTo(raiz.getElemento())>0) {
				raiz.setDerecha(insertarElementoRec(raiz.getDerecha(),nodoAInsertar));
			}else {
				raiz.setIzquierda(insertarElementoRec(raiz.getIzquierda(),nodoAInsertar));

			}
			return raiz;
		}
	}
	
	public void recorreEnPreOrden() {
		recorreEnPreOrdenRec(raiz);
	}
	
	private void recorreEnPreOrdenRec(Nodo<T> nodo) {
		if(nodo!=null) {
			System.out.print(nodo.getElemento().toString()+", ");
			recorreEnPreOrdenRec(nodo.getIzquierda());
			recorreEnPreOrdenRec(nodo.getDerecha());
		}
	}
	
	
	
	//Arbol que imprima en consola
	
	public void insertarElementoM(T elemento) {
		Nodo<T> nodo= new Nodo<>(elemento);
		if(raiz==null) {
			raiz=nodo;
		}else {
			insertarElementoRecM(raiz,nodo);
		}
	}
	
	public Nodo<T> insertarElementoRecM(Nodo<T> raiz, Nodo<T> nodoAInsertar) {
		if(raiz==null) {
			return nodoAInsertar;
		}else {
			if(nodoAInsertar.getElemento().compareTo(raiz.getElemento())>0) {
				raiz.setDerecha(insertarElementoRecM(raiz.getDerecha(),nodoAInsertar));
			}else {
				raiz.setIzquierda(insertarElementoRecM(raiz.getIzquierda(),nodoAInsertar));

			}
			return raiz;
		}
	}
	
	public void recorreEnPreOrdenM() {
		recorreEnPreOrdenRecM(raiz);
		
	}
	
	private void recorreEnPreOrdenRecM(Nodo<T> nodo) {
		
		if(nodo!=null) {
			try {
			System.out.print("               "+nodo.getElemento().toString());
			System.out.println();
			System.out.println("             /   \\");
			System.out.print("            "+nodo.getIzquierda().getElemento()+"    "+nodo.getDerecha().getElemento());
			
			System.out.println();
			recorreEnPreOrdenRecM(nodo.getIzquierda());
			
			recorreEnPreOrdenRecM(nodo.getDerecha());
			}catch(java.lang.NullPointerException ultimoDigito) {
				if(nodo.getIzquierda()!=null) {
				System.out.println("            "+nodo.getIzquierda().getElemento());
			}
				if(nodo.getDerecha()!=null) {
					System.out.println("            "+nodo.getDerecha().getElemento());	
				}
				}
		
			
		}
		
		
			
	}
	

	
	
	

}
