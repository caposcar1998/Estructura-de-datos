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
		Nodo <T> actual = node;  
		/* loop down to find the leftmost leaf */
		while (actual.getIzquierda() != null)  
			actual = actual.getIzquierda();  

		return actual;  
  }
  	public int getBalance(Nodo <T> N){  
  		if (N == null)  
        return 0;  
  		return altura(N.getIzquierda()) - altura(N.getDerecha());  
  }  
  
	public Nodo<T> eliminarRecursivo(T elemento, Nodo<T> raiz)  {  
        // STEP 1: PERFORM STANDARD BST DELETE  
        if (raiz == null) {
            return raiz;  
        }
        // If the elemento to be deleted is smaller than  
        // the raiz's elemento, then it lies in left subtree  
        if (elemento.compareTo(raiz.getElemento())<0) {
            raiz.setIzquierda(eliminarRecursivo(elemento, raiz.getIzquierda()));
            }
  
        // If the elemento to be deleted is greater than the  
        // raiz's elemento, then it lies in right subtree  
        else if (elemento.compareTo(raiz.getElemento())>0) {
            raiz.setDerecha(eliminarRecursivo(elemento,raiz.getDerecha()));
        }
  
        // if elemento is same as raiz's elemento, then this is the node  
        // to be deleted  
        else{  
  
            // node with only one child or no child  
            if ((raiz.getIzquierda() == null) || (raiz.getDerecha() == null)){  
                Nodo<T> temp = null;  
                if (temp == raiz.getIzquierda()) { 
                    temp = raiz.getDerecha();  
                }else {
                    temp = raiz.getIzquierda();  
  
                // No child case  
                }if (temp == null){  
                    temp = raiz;  
                    raiz = null;  
                }  
                else { // One child case  
                    raiz = temp; // Copy the contents of  
                                // the non-empty child  
                }
            }  
            else
            {  
  
                // node with two children: Get the inorder  
                // successor (smallest in the right subtree)  
                Nodo<T> temp = nodoMenor(raiz.getDerecha());  
  
                // Copy the inorder successor's data to this node  
                raiz.setElemento(temp.getElemento());  
  
                // Delete the inorder successor  
                raiz.setDerecha(eliminarRecursivo(temp.getElemento(),raiz.getDerecha()));  
            }  
        }  
  
        // If the tree had only one node then return  
        if (raiz == null)  
            return raiz;  
  
        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE  
        raiz.setAltura(max(altura(raiz.getIzquierda()),altura(raiz.getDerecha()))+1);
  
        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether  
        // this node became unbalanced)  
        int balance = getBalance(raiz);
  
        // If this node becomes unbalanced, then there are 4 cases  
        // Left Left Case  
        if (balance > 1 && getBalance(raiz.getIzquierda()) >= 0)  
            return rotaSimpleALaDerecha(raiz);  
  
        // Left Right Case  
        if (balance > 1 && getBalance(raiz.getIzquierda()) < 0)  
        {  
          return rotarDobleALaDerecha(raiz);
        }  
  
        // Right Right Case  
        if (balance < -1 && getBalance(raiz.getDerecha()) <= 0)  
            return rotaSimpleALaIzquierda(raiz);  
  
        // Right Left Case  
        if (balance < -1 && getBalance(raiz.getDerecha()) > 0)  
        {  
            return rotarDobleALaIzquierda(raiz);
        }
        return raiz;  
    } 
	
	public void encontrar(Nodo <T> nodo, T elemento) {}
	


	
}