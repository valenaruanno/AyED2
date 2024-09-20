package tp3.ejercicio1;

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
            int ancho = -1;
            if (!this.isEmpty()){
                ancho = buscar (this, -1);
            }
            return ancho;
	}
        
        private int buscar (GeneralTree<T> arbol, int ancho){
            int anchoMax = ancho;
            if (arbol.getChildren().size() > anchoMax){
                anchoMax = arbol.getChildren().size();
            }
            for (GeneralTree<T> children : arbol.getChildren())
                anchoMax = buscar (children, anchoMax);
            return anchoMax;
        }
        
        public static void main (String []args){
           // TODO code application logic here
        GeneralTree <Integer> HII = new GeneralTree <Integer> (8);
        GeneralTree <Integer> HID = new GeneralTree <Integer> (23);
        GeneralTree <Integer> HI = new GeneralTree <Integer> (16);
        HI.addChild(HII);
        HI.addChild(HID);
    
        GeneralTree <Integer> HMI = new GeneralTree <Integer> (9);
        GeneralTree <Integer> HM = new GeneralTree <Integer> (7);
        HM.addChild(HMI);
        
        GeneralTree <Integer> HDI = new GeneralTree <Integer> (1);
        GeneralTree <Integer> HDD = new GeneralTree <Integer> (3);
        GeneralTree <Integer> HD = new GeneralTree <Integer> (17);
        HD.addChild(HDI);
        HD.addChild(HDD);
        
        GeneralTree <Integer> arbol = new GeneralTree <Integer> (15);
        arbol.addChild(HI);
        arbol.addChild(HM);
        arbol.addChild(HD);
        
            System.out.println("La altura del arbol es: " + arbol.altura());
            System.out.println("El nivel del 7 es: " + arbol.nivel(7));
            System.out.println("El ancho maximo es: " + arbol.ancho());

    }
}