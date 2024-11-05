/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ejercicio11;

import tp1.ejercicio8.Queue;
import tp3.ejercicio1.GeneralTree;
import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author valen aruanno
 */
public class ParcialArboles {
    public static boolean resolver (GeneralTree<Integer> arbol){
        boolean es = true;
        if (!arbol.isEmpty()){
            int nivel = 0;
            Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>> ();
            cola.enQueue(arbol);
            cola.enQueue(null);
            int cant = 0;
            GeneralTree<Integer> aux;
            while ((!cola.isEmpty()) && (es)){
                aux = cola.deQueue();
                if (aux != null){
                    cant++;
                    for (GeneralTree<Integer> child : aux.getChildren()){
                        cola.enQueue(child);
                    }
                } else {
                    if (cant != nivel + 1)
                        es = false;
                    if (!cola.isEmpty()){
                        nivel++;
                        cant = 0;
                        cola.enQueue(null);
                    }
                }
            }
        } else 
            es = false;
        return es;
    }
    
    public static void main(String[] args) {
        List <GeneralTree<Integer>> subChildren1 = new LinkedList <GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(83));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(18, subChildren1);
        
        List <GeneralTree<Integer>> subChildren2 = new LinkedList <GeneralTree<Integer>>();
        subChildren2.add(subAb1);
        GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(5, subChildren2);
        
        List <GeneralTree<Integer>> subChildren3 = new LinkedList <GeneralTree<Integer>>();
        //subChildren3.add(new GeneralTree<Integer>(33));
        subChildren3.add(new GeneralTree<Integer>(12));
        subChildren3.add(new GeneralTree<Integer>(17));
        subChildren3.add(new GeneralTree<Integer>(9));
        GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(3, subChildren3);
        
        List <GeneralTree<Integer>> subChildren4 = new LinkedList <GeneralTree<Integer>>();
        subChildren4.add(new GeneralTree<Integer>(7));
        subChildren4.add(new GeneralTree<Integer>(11));
        subChildren4.add(subAb3);
        GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(4, subChildren4);
        
        List <GeneralTree<Integer>> subArbIzq = new LinkedList <GeneralTree<Integer>>();
        subArbIzq.add(subAb2);
        subArbIzq.add(subAb4);
        GeneralTree<Integer> arbIzq = new GeneralTree<Integer>(1, subArbIzq);
        
        List <GeneralTree<Integer>> subArbDer = new LinkedList <GeneralTree<Integer>>();
        subArbDer.add(new GeneralTree<Integer>(13));
        GeneralTree<Integer> arbDer = new GeneralTree<Integer>(25, subArbDer);
        
        List <GeneralTree<Integer>> arbol = new LinkedList <GeneralTree<Integer>>();
        arbol.add(arbIzq);
        arbol.add(arbDer);
        GeneralTree<Integer> a = new GeneralTree<Integer>(2, arbol);
        
        System.out.println("Es creciente el arbol 1: " + resolver(a));
        
        
    }
}
