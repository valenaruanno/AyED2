package tp3.ejercicio1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tp1.ejercicio8.Queue;
import tp3.ejercicio2.RecorridosAG;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 
            int alt = -1;
            if (!this.isEmpty()){
                alt = altura (this, 0, 0);
            }
            return alt;
	}
        
        private int altura (GeneralTree<T> arbol, int altura, int alturaMax){
            if (arbol.isLeaf()){
                if (altura > alturaMax)
                    alturaMax = altura;
            } else {
                for (GeneralTree<T> children : arbol.getChildren())
                    alturaMax = altura (children, altura + 1, alturaMax);
            }
            return alturaMax;
        }
	
	public int nivel(T dato){
            int nivel = -1;
            if (!this.isEmpty()){
		nivel = 0;
                boolean encontre = false;
                Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
                cola.enQueue(this);
                cola.enQueue(null);
                GeneralTree<T> aux;
                while ((!cola.isEmpty()) && (!encontre)){
                    aux = cola.deQueue();
                    if (aux != null){
                        if (aux.getData().equals(dato))
                            encontre = true;
                        else {
                            for (GeneralTree<T> children : aux.getChildren())
                                cola.enQueue(children);
                        }
                    } else {
                        if (!cola.isEmpty()){
                            nivel++;
                            cola.enQueue(null);
                        }
                    }
                }
            }
                return nivel;
	  }

	public int ancho(){
            int anchoMax = -1;
            if (!this.isEmpty()){
                Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
                cola.enQueue(this);
                cola.enQueue(null);
                int ancho = 0;
                GeneralTree<T> aux;
                while (!cola.isEmpty()){
                    aux = cola.deQueue();
                    if (aux != null){
                        ancho++;
                        for (GeneralTree<T> children : aux.getChildren())
                            cola.enQueue(children);
                    } else {
                        if (ancho > anchoMax)
                                anchoMax = ancho;
                        if (!cola.isEmpty()){
                            ancho = 0;
                            cola.enQueue(null);
                        }
                    }
                }
            }
            return anchoMax;
	}
        
    public boolean esAncestro (T a, T b){
        boolean es = false;
        if (!this.isEmpty()){
            GeneralTree<T> aNodo = new GeneralTree<T>();
            GeneralTree<T> bNodo = new GeneralTree<T>();
            boolean primeroB = false;
            Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
            cola.enQueue(this);
            GeneralTree<T> aux;
            while ((!cola.isEmpty()) && ((!primeroB) || (bNodo != null))){
                aux = cola.deQueue();
                if (aux.getData().equals(a))
                    aNodo = aux;
                else{
                    if (aux.getData().equals(b)){
                        if (aNodo == null)
                            primeroB = true;
                        else 
                            bNodo = aux;
                    }
                }
                List<GeneralTree<T>> children = aux.getChildren();
                Iterator<GeneralTree<T>> it = children.iterator();
                while ((it.hasNext()) && (!primeroB) && (bNodo == null)){
                    GeneralTree<T> child = it.next();
                    cola.enQueue(child);
                }
            }
            if ((aNodo != null) && (bNodo != null) && (!primeroB)){
                System.out.println("Encontre A? " + aNodo != null);
                System.out.println("Encontre B? " + bNodo != null);
                System.out.println("Encontre primero a B? " + primeroB);
                es = chequear (aNodo, b);    
            }
        }
        return es;
    }
    
    private boolean chequear (GeneralTree<T> arbol, T b){
        boolean encontre = false;
        if (arbol.getData() == b)
            encontre = true;
        else {
            List<GeneralTree<T>> children = arbol.getChildren();
            Iterator <GeneralTree<T>> it = children.iterator();
            while ((it.hasNext()) && (!encontre)){
                GeneralTree<T> child = it.next();
                encontre = chequear (child, b);
            }
        }
        return encontre;
    }
}