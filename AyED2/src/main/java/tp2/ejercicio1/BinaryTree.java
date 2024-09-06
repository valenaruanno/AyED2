package tp2.ejercicio1;

import tp1.ejercicio8.Queue;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	public BinaryTree() {
            
	}

    public BinaryTree(T data) {
        this.data = data;
    }

        
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
            int cant = 0;
            cant = contar (this);
            return cant;
	}
        
        private int contar (BinaryTree <T> arbol){
            int cant = 0;
            if (arbol.isLeaf())
                cant++;
            else{
                if (arbol.hasLeftChild())
                    cant += contar (arbol.getLeftChild());
                if (arbol.hasRightChild())
                    cant += contar (arbol.getRightChild());
            }
            return cant;
        }
		
    	 
    public BinaryTree<T> espejo(){
        BinaryTree <T> a = new BinaryTree <T> ();
        a.setData(this.getData());
        espejar (this, a);
        return a;
    }
    
    private void espejar (BinaryTree<T> arbol, BinaryTree<T> nuevo){
        if (arbol.hasLeftChild()){
            nuevo.addRightChild(new BinaryTree<T> (arbol.getLeftChild().getData()));
            espejar (arbol.getLeftChild(), nuevo.getRightChild());
        }
        if (arbol.hasRightChild()){
            nuevo.addLeftChild(new BinaryTree<T> (arbol.getRightChild().getData()));
            espejar (arbol.getRightChild(), nuevo.getLeftChild());
        }
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
            Queue<T> cola = new Queue<T> ();
            cola.enQueue((T) this);
            cola.enQueue(null);
            int nivel = 0;
            BinaryTree<T> aux = new BinaryTree<T> ();
            while (!cola.isEmpty() && (nivel <= m)){
                aux = (BinaryTree<T>) cola.deQueue();
                if (aux == null){
                    nivel++;
                    if (!cola.isEmpty())
                        cola.enQueue(null);
                }
                else {
                    if (nivel >= n)
                        System.out.println(aux.getData());
                    if (aux.hasLeftChild())
                        cola.enQueue((T) aux.getLeftChild());
                    if (aux.hasRightChild())
                        cola.enQueue((T) aux.getRightChild());
                }
            }
        }
        
        public void inOrden (){
            if (this.hasLeftChild())
                this.getLeftChild().inOrden();
            if (!this.isEmpty())
                System.out.println(this.getData() + " ~ ");
            if (this.hasRightChild())
                this.getRightChild().inOrden();
        }

public static void main(String [] args){
    BinaryTree <Integer> hI = new BinaryTree<Integer> (8);
    hI.addLeftChild(new BinaryTree <Integer> (10));
    
    BinaryTree <Integer> arbol = new BinaryTree<Integer> (4);
    arbol.addLeftChild(hI);
    arbol.addRightChild(new BinaryTree<Integer> (7));
    
    System.out.println("La cantidad de hojas del arrbol es : " + arbol.contarHojas());
    
    BinaryTree <Integer> nue = arbol.espejo();
    nue.inOrden();
    System.out.println("//////////////////////////////////////Entre niveles////////////////////////////////////////");
    arbol.entreNiveles(0, 1);
}
}


