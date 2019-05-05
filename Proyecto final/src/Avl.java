import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;

public class Avl<T extends Comparable<T>> {
	private Nodo<T> raiz;

	public Nodo<T> getRaiz() {
		return raiz;
	}
	
	
	public void insertarElemento(T elemento) {
		raiz= insertaRecursivo(elemento,raiz);
	}
	
	
	public Nodo<T> insertaRecursivo(T elemento,Nodo<T> raiz) {
		if(raiz==null) {
			raiz= new Nodo<T>(elemento);
		}else {
			if(elemento.compareTo(raiz.getElemento())>0) {
				raiz.setDerecha(insertaRecursivo(elemento, raiz.getDerecha()));
				if(altura(raiz.getIzquierda())-altura(raiz.getDerecha())==-2) {
					if(elemento.compareTo(raiz.getDerecha().getElemento())>0) {
						raiz= rotaSimpleALaIzquierda(raiz);
					}else {
						raiz= rotarDobleALaIzquierda(raiz);
					}
				}
			}
			if(elemento.compareTo(raiz.getElemento())<0) {
				raiz.setIzquierda(insertaRecursivo(elemento, raiz.getIzquierda()));
				if(altura(raiz.getIzquierda())-altura(raiz.getDerecha())==2) {
					if(elemento.compareTo(raiz.getIzquierda().getElemento())<0) {
						raiz= rotaSimpleALaDerecha(raiz);
					}else {
						raiz= rotarDobleALaDerecha(raiz);
					}
				}	
			}
		}
		
		int altura= max(altura (raiz.getIzquierda()),altura(raiz.getDerecha()));
		System.out.println("Altura nodo: "+raiz.getElemento()+" "+altura);
		raiz.setAltura(altura+1);
		return raiz;
	}
	
	public Nodo<T> rotaSimpleALaIzquierda(Nodo<T> raiz){
		Nodo<T> temp= raiz.getDerecha();
		raiz.setDerecha(temp.getIzquierda());
		temp.setIzquierda(raiz);
		raiz.setAltura(max(altura(raiz.getIzquierda()),altura(raiz.getDerecha()))+1);
		temp.setAltura(max(altura(temp.getDerecha()),altura(raiz))+1);
		return temp;
	}
	public Nodo<T> rotaSimpleALaDerecha(Nodo<T> raiz){
		Nodo<T> temp= raiz.getIzquierda();
		raiz.setIzquierda(temp.getDerecha());
		temp.setDerecha(raiz);
		raiz.setAltura(max(altura(raiz.getIzquierda()),altura(raiz.getDerecha()))+1);
		temp.setAltura(max(altura(temp.getIzquierda()),altura(raiz))+1);
		return temp;
	}	
	
	public Nodo<T> rotarDobleALaIzquierda(Nodo<T> raiz){
		raiz.setDerecha(rotaSimpleALaDerecha(raiz.getDerecha()));
		return rotaSimpleALaIzquierda(raiz);
	}
	public Nodo<T> rotarDobleALaDerecha(Nodo<T> raiz){
		raiz.setIzquierda(rotaSimpleALaIzquierda(raiz.getIzquierda()));
		return rotaSimpleALaDerecha(raiz);
	}
	public int max(int a, int b) {
		if(a>b) {
			return a;
		}else {
			return b;
		}
	}
	
	public int altura(Nodo<T> nodo) {
		if(nodo==null) {
			return -1;
		}else {
			return nodo.getAltura();
		}
	}
	
	public void eliminarElemento(T elemento) {
		raiz= eliminarRecursivo(elemento,raiz);
	}
  
	public Nodo <T> nodoMenor(Nodo <T> node){  
    Nodo <T> nodoActual = node;
    while (nodoActual.getIzquierda() != null) {  
    nodoActual = nodoActual.getIzquierda();  
    }
    return nodoActual;  
	}
  
	public int getBalance(Nodo <T> N){  
	    if (N == null) {
	        return 0;
	    }
    return altura(N.getIzquierda()) - altura(N.getDerecha());  
	}  
  
	public Nodo<T> eliminarRecursivo(T elemento, Nodo<T> raiz)  {
        if (raiz == null) {
            return raiz;  
        }
        if (elemento.compareTo(raiz.getElemento())<0) {
            raiz.setIzquierda(eliminarRecursivo(elemento, raiz.getIzquierda()));
            } 
        else if (elemento.compareTo(raiz.getElemento())>0) {
            raiz.setDerecha(eliminarRecursivo(elemento,raiz.getDerecha()));
        } 
        else{
            if ((raiz.getIzquierda() == null) || (raiz.getDerecha() == null)){  
                Nodo<T> temp = null;  
                if (temp == raiz.getIzquierda()) { 
                    temp = raiz.getDerecha();  
                }else {
                    temp = raiz.getIzquierda();  
                }if (temp == null){  
                    temp = raiz;  
                    raiz = null;  
                }  
                else { 
                    raiz = temp; 
                }
            }  
            else
            {  
                Nodo<T> temp = nodoMenor(raiz.getDerecha());  
                raiz.setElemento(temp.getElemento());  
                raiz.setDerecha(eliminarRecursivo(temp.getElemento(),raiz.getDerecha()));  
            }  
        }
        if (raiz == null) { 
            return raiz;
        }
        raiz.setAltura(max(altura(raiz.getIzquierda()),altura(raiz.getDerecha()))+1);
        int balance = getBalance(raiz);
        
        // Rotacion simple derecha (en linea 3 nodos izquierda)
        if (balance > 1 && getBalance(raiz.getIzquierda()) >= 0){
            return rotaSimpleALaDerecha(raiz);  
        }
        // Rotación doble a la derecha (2 izquierda 1 derecha)
        if (balance > 1 && getBalance(raiz.getIzquierda()) < 0){  
          return rotarDobleALaDerecha(raiz);
        }  
        // Rotación simple a la izquierda (en linea 3 nodos derecha)
        if (balance < -1 && getBalance(raiz.getDerecha()) <= 0) { 
            return rotaSimpleALaIzquierda(raiz);
        }
        // Rotación doble a la izquierda  (2 derecha 1 izquierda)
        if (balance < -1 && getBalance(raiz.getDerecha()) > 0){  
            return rotarDobleALaIzquierda(raiz);
        }
        return raiz;  
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
	public void recorreEnInOrden() {
		recorreEnInOrdenRec(raiz);
	}
	
	private void recorreEnInOrdenRec(Nodo<T> nodo) {
		if(nodo!=null) {
			recorreEnInOrdenRec(nodo.getIzquierda());
			System.out.print(nodo.getElemento().toString()+", ");
			recorreEnInOrdenRec(nodo.getDerecha());
		}
	}
	public void recorreEnPostOrden(T x, Pane pane) {
		recorreEnPostOrdenRec(raiz, x, pane);
	
	}
	
	private void recorreEnPostOrdenRec(Nodo<T> nodo, T x, Pane pane) {
		if(nodo!=null) {
			recorreEnPostOrdenRec(nodo.getIzquierda(),x, pane);
			recorreEnPostOrdenRec(nodo.getDerecha(),x, pane);

			System.out.print(nodo.getElemento().toString()+", ");
			if(nodo.getElemento()==x) {
				nodo.getCircle().setStroke(Color.DARKRED);
				
				new java.util.Timer().schedule( 
				        new java.util.TimerTask() {
				            @Override
				            public void run() {
				               nodo.getCircle().setStroke(Color.BLACK);
				            }
				        }, 
				        5000 
				);
				
				
			}
			
		}
			
		
	}	
	
	
	/*
	public T printPostorder(Nodo<T> node) 
    { 
        if (node == null) 
            return node.getElemento(); 
  
        // first recur on left subtree 
        printPostorder(node.getIzquierda()); 
  
        // then recur on right subtree 
        printPostorder(node.getDerecha()); 
  
        // now deal with the node 
        System.out.print(node.getElemento() + " ");
		return node.getElemento(); 
    } 
	*/
	
	


	
}