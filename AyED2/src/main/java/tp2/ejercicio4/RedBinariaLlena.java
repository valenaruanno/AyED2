/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2.ejercicio4;

import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author valen aruanno
 */
public class RedBinariaLlena {
    private BinaryTree<Integer> arbol;

    public RedBinariaLlena(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public int retardoReenvio (){
        int retardoMax = 0;
        int retardo = 0;
        retardoMax = calcularRetardo (this.arbol, retardoMax, retardo);
        return retardoMax;
    }
    
    private int calcularRetardo (BinaryTree<Integer> arbol, int retardoMax, int retardo){
        retardo += arbol.getData();
        if (arbol.isLeaf()){
            System.out.println("El retardo calculado es " + retardo);
            if (retardo > retardoMax)
                retardoMax = retardo;
        } else {
            if (arbol.hasLeftChild())
                retardoMax = calcularRetardo (arbol.getLeftChild(), retardoMax, retardo);
            if (arbol.hasRightChild())
                retardoMax = calcularRetardo (arbol.getRightChild(), retardoMax, retardo);
        }
        return retardoMax;
    }
    
    public static void main(String []args){
        BinaryTree <Integer> hII = new BinaryTree<Integer> (5);
        hII.addLeftChild(new BinaryTree<Integer> (7));
        hII.addRightChild(new BinaryTree<Integer> (8));
        
        BinaryTree <Integer> hID = new BinaryTree<Integer> (4);
        hII.addLeftChild(new BinaryTree<Integer> (5));
        hII.addRightChild(new BinaryTree<Integer> (6));
        
        BinaryTree <Integer> hI = new BinaryTree<Integer> (2);
        hI.addLeftChild(hII);
        hI.addRightChild(hID);
        
        
        BinaryTree <Integer> hDI = new BinaryTree<Integer> (9);
        hDI.addLeftChild(new BinaryTree<Integer> (12));
        hDI.addRightChild(new BinaryTree<Integer> (8));
        
        BinaryTree <Integer> hDD = new BinaryTree<Integer> (8);
        hDD.addLeftChild(new BinaryTree<Integer> (2));
        hDD.addRightChild(new BinaryTree<Integer> (1));
        
        BinaryTree <Integer> hD = new BinaryTree<Integer> (3);
        hD.addLeftChild(hDI);
        hD.addRightChild(hDD);
        
        BinaryTree <Integer> arbol = new BinaryTree<Integer> (10);
        arbol.addLeftChild(hI);
        arbol.addRightChild(hD);
        
        RedBinariaLlena red = new RedBinariaLlena (arbol);
        System.out.println(red.retardoReenvio());
    }
}
