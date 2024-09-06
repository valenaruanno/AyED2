/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2.ejercicio3;

import java.util.LinkedList;
import java.util.List;
import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author valen aruanno
 */
public class ContadorArbol {
    private BinaryTree<Integer> arbol;

    public ContadorArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    
    public LinkedList<Integer> numerosPares (){
        LinkedList<Integer> lista = new LinkedList<Integer> ();
        postOrder (this.arbol , lista);
        return lista;
    }
    
    private void inOrder (BinaryTree<Integer> arbol, LinkedList<Integer> lista){
        if (arbol.hasLeftChild())
            inOrder (arbol.getLeftChild(), lista);
        if (arbol.getData() % 2 == 0)
            lista.add(arbol.getData());
        if (arbol.hasRightChild())
            inOrder (arbol.getRightChild(), lista);
    }
    
    private void postOrder (BinaryTree<Integer> arbol, LinkedList<Integer> lista){
        if (arbol.hasLeftChild())
            postOrder (arbol.getLeftChild(), lista);
        if (arbol.hasRightChild())
            postOrder (arbol.getRightChild(), lista);
        if (arbol.getData() % 2 == 0)
            lista.add(arbol.getData());
    }
    
    public static void main (String [] args){
        BinaryTree <Integer> hI = new BinaryTree<Integer> (8);
        hI.addLeftChild(new BinaryTree <Integer> (10));
    
        BinaryTree <Integer> arbol = new BinaryTree<Integer> (4);
        arbol.addLeftChild(hI);
        arbol.addRightChild(new BinaryTree<Integer> (6));    
        
        ContadorArbol con = new ContadorArbol (arbol);
        LinkedList<Integer> lista = con.numerosPares();
        
        for (Integer x: lista)
            System.out.println(x);
    }
}
