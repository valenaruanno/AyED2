/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2.ejercicio9;

import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author valen aruanno
 */
public class ParcialArboles {
    public BinaryTree<SyD> sumAndDif (BinaryTree<Integer> arbol){
        BinaryTree<SyD> nuevo = new BinaryTree<SyD> ();
        if (!arbol.isEmpty())
            nuevo = armar (arbol, 0,0);
        return nuevo;
    }
    
    private BinaryTree<SyD> armar (BinaryTree<Integer> a, int suma, int padre){
        BinaryTree<SyD> nue = new BinaryTree<SyD> (new SyD (suma + a.getData(), a.getData() - padre));
        if (a.hasLeftChild())
            nue.addLeftChild(armar (a.getLeftChild(), suma + a.getData(), a.getData()));
        if (a.hasRightChild())
            nue.addRightChild(armar (a.getRightChild(), suma + a.getData(), a.getData()));
        return nue;
    }
    
    public void preOrden (BinaryTree <SyD> ab){
        System.out.println(ab.getData().toString());
        if (ab.hasLeftChild())
            preOrden (ab.getLeftChild());
        if (ab.hasRightChild())
            preOrden(ab.getRightChild());
    }
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryTree <Integer> hIzq = new BinaryTree <Integer> (10);
        hIzq.addLeftChild(new BinaryTree <Integer> (11));
        hIzq.addRightChild(new BinaryTree <Integer> (12));
        BinaryTree <Integer> hDer = new BinaryTree <Integer> (15);
        hDer.addLeftChild (new BinaryTree <Integer> (12));
        hDer.addRightChild(new BinaryTree <Integer> (13));
        BinaryTree <Integer> arbol = new BinaryTree <Integer> (9);
        arbol.addLeftChild(hIzq);
        arbol.addRightChild(hDer);
        
        ParcialArboles ej = new ParcialArboles ();
        BinaryTree <SyD> nuevo = new BinaryTree <SyD> ();
        System.out.println("--------------------------------");
        nuevo = ej.sumAndDif(arbol);
        ej.preOrden(nuevo);
    }
}
