/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2.ejercicio8;

import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author valen aruanno
 */
public class ParcialArboles {
    public boolean esPrefijo (BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
        boolean es = true;
        if (!arbol1.getData().equals(arbol2.getData()))
            es = false;
        else {
            if (arbol1.hasLeftChild()){
                if (!arbol2.hasLeftChild())
                    es = false;
                else 
                    es = esPrefijo (arbol1.getLeftChild(), arbol2.getLeftChild());
            }
            if ((es) && (arbol1.hasRightChild())){
                if (!arbol2.hasRightChild())
                    es = false;
                else 
                    es = esPrefijo (arbol1.getRightChild(), arbol2.getRightChild());
            }
        }
        return es;
    }
    
    public static void main (String [] args){
        BinaryTree<Integer> a1hI = new BinaryTree<Integer> (3);
        a1hI.addRightChild(new BinaryTree<Integer> (5));
        
        BinaryTree<Integer> a1hD = new BinaryTree<Integer> (6);
        a1hD.addRightChild(new BinaryTree<Integer> (3));
        
        
        BinaryTree<Integer> arbol1 = new BinaryTree<Integer> (2);
        arbol1.addLeftChild(a1hI);
        arbol1.addRightChild(a1hD);
        
        
        BinaryTree<Integer> a2hI = new BinaryTree<Integer> (3);
        a2hI.addLeftChild(new BinaryTree<Integer> (4));
        a2hI.addRightChild(new BinaryTree<Integer> (5));
        
        BinaryTree<Integer> a2hD = new BinaryTree<Integer> (6);
        a2hD.addRightChild(new BinaryTree<Integer> (3));
        
        
        BinaryTree<Integer> arbol2 = new BinaryTree<Integer> (2);
        arbol2.addLeftChild(a2hI);
        arbol2.addRightChild(a2hD);
        
        ParcialArboles par = new ParcialArboles();
        
        System.out.println("Es prefijo? " + par.esPrefijo(arbol1, arbol2));
    }
}
