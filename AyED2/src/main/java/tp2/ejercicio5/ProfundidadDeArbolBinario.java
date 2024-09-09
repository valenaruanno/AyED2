/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2.ejercicio5;

import java.util.LinkedList;
import tp1.ejercicio8.Queue;
import tp2.ejercicio1.BinaryTree;

/**
 *
 * @author valen aruanno
 */
public class ProfundidadDeArbolBinario {
    private BinaryTree<Integer> arbol;

    public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    
    public int sumaElementosProfundidad (int p){
        int suma = 0;
        Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>> ();
        cola.enQueue(this.arbol);
        cola.enQueue(null);
        int nivel = 0;
        BinaryTree<Integer> aux = new BinaryTree<Integer> ();
        while ((!cola.isEmpty()) && (nivel < p)){
            aux = cola.deQueue();
            if (aux != null){
                if (aux.hasLeftChild())
                    cola.enQueue(aux.getLeftChild());
                if (aux.hasRightChild())
                    cola.enQueue(aux.getRightChild());
            } else {
                if (!cola.isEmpty()){
                    cola.enQueue(null);
                    nivel++;
                }
            }
        }
        if (nivel == p){
            aux = cola.deQueue();
            while (aux != null){
                suma += aux.getData();
                aux = cola.deQueue();
            }
        }
        return suma;
    }
    
    public static void main (String [] args){
        BinaryTree <Integer> hI = new BinaryTree<Integer> (8);
        hI.addLeftChild(new BinaryTree <Integer> (10));
    
        BinaryTree <Integer> arbol = new BinaryTree<Integer> (4);
        arbol.addLeftChild(hI);
        arbol.addRightChild(new BinaryTree<Integer> (7));    
        
        ProfundidadDeArbolBinario con = new ProfundidadDeArbolBinario (arbol);
        System.out.println(con.sumaElementosProfundidad(3));
    }
}
