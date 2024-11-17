/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialesArboles.segundaFecha2024;

import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author valen aruanno
 */
public class ParcialArboles {
    private BinaryTree<Integer> arbol;
    
    public ParcialArboles (BinaryTree<Integer> a){
        this.arbol = a;
    }
    
    public BinaryTree<Integer> nuevoTree(){
        BinaryTree<Integer> nuevo = new BinaryTree<Integer> ();
        if (!arbol.isEmpty())
            armarArbol(arbol, nuevo);
        return nuevo;
    }
    
    private void armarArbol (BinaryTree<Integer> arbol, BinaryTree<Integer> nuevo){
        nuevo.setData(arbol.getData());
        if (arbol.hasLeftChild())
            nuevo.addLeftChild(armarLadoIzq (arbol.getLeftChild(), arbol.getData()));
        if (arbol.hasRightChild())
            nuevo.addRightChild(armarLadoDer (arbol.getRightChild()));
    }
    
    private BinaryTree<Integer> armarLadoIzq (BinaryTree<Integer> a, int padre){
        BinaryTree<Integer> nuevo = new BinaryTree (a.getData() + padre);
        if (a.hasLeftChild())
            nuevo.addLeftChild(armarLadoIzq(a.getLeftChild(), a.getData()));
        if (a.hasRightChild())
            nuevo.addRightChild(armarLadoDer (a.getRightChild()));
        return nuevo;
    }
    
    private BinaryTree<Integer> armarLadoDer (BinaryTree<Integer> a){
        BinaryTree<Integer> nuevo = new BinaryTree<Integer> (a.getData());
        if (a.hasLeftChild())
            nuevo.addLeftChild(armarLadoIzq (a.getLeftChild(), a.getData()));
        if (a.hasRightChild())
            nuevo.addRightChild(a.getRightChild());
        return nuevo;
    }
    
    
    public static void main(String args[]) {
        BinaryTree<Integer> ab = new BinaryTree<Integer>(1);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(4));
        ab.addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(6));
        ab.getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(7));
        
        ParcialArboles p = new ParcialArboles(ab);
        
        BinaryTree<Integer> arb = p.nuevoTree();
        
        arb.inOrden();
    }
}
