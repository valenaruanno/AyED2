/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialesArboles.parcial1;

import java.util.logging.Logger;
import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author valen aruanno
 */
public class ParcialArboles {
    private BinaryTree<Integer> arbol;

    public ParcialArboles(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public boolean isTwoTree (int num){
        boolean es = false;
        if (!arbol.isEmpty()){
            BinaryTree <Integer> aNum = new BinaryTree<Integer> ();
            buscar (this.arbol, num, aNum);
            if (aNum != null)
                es = chequear(aNum);
        }
        return es;
    }
    
    private void buscar (BinaryTree<Integer> arbol, int num, BinaryTree<Integer> aNum){
        if (arbol.getData() == num)
            aNum = arbol;
        else {
            if (arbol.hasLeftChild())
                buscar (arbol.getLeftChild(), num, aNum);
            if ((aNum == null) && (arbol.hasRightChild()))
                buscar (arbol.getRightChild(), num, aNum);
        }
    }
    
    private boolean chequear (BinaryTree<Integer> a){
        int cantI = -1;
        int cantD = -1;
        if (a.hasLeftChild())
            cantI += contar (a.getLeftChild());
        if (a.hasRightChild())
            cantD += contar (a.getRightChild());
        System.out.println("CantD: " + cantD + " y cantI: " + cantI);
        return cantI == cantD;
    }
    
    private int contar (BinaryTree<Integer> a){
        int cant = 0;
        if ((a.hasLeftChild()) && (a.hasRightChild()))
            cant++;
        if (a.hasLeftChild())
            cant += contar (a.getLeftChild());
        if (a.hasRightChild())
            cant += contar (a.getRightChild());
        return cant;
    }
    
    public static void main (String[] args) { 
        
        BinaryTree<Integer> ab = new BinaryTree<Integer>(2);
        ab.addLeftChild(new BinaryTree<Integer>(7));
        ab.addRightChild(new BinaryTree<Integer>(-5));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(23));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(-3));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(55));
        ab.getLeftChild().getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(9));
        ab.getLeftChild().getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(16));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(19));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(4));
        ab.getRightChild().getRightChild().addRightChild(new BinaryTree<Integer>(18));
        ab.getRightChild().getRightChild().getRightChild().addLeftChild(new BinaryTree<Integer>(8));
        ab.getRightChild().getRightChild().getRightChild().addRightChild(new BinaryTree<Integer>(24));
        
        ParcialArboles parcialArb = new ParcialArboles(ab);
        //System.out.println("Resultado=" + parcialArb.isTwoTree(2));
        System.out.println("Resultado=" + parcialArb.isTwoTree(7));
        //System.out.println("Resultado=" + parcialArb.isTwoTree(-3));
        System.out.println("Resultado=" + parcialArb.isTwoTree(4));
        //System.out.println("Resultado=" + parcialArb.isTwoTree(55));
    }
}
