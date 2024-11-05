/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ejercicio9;

import tp1.ejercicio8.Queue;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen aruanno
 */
public class ParcialArboles {
    public static boolean esDeSeleccion (GeneralTree<Integer> arbol){
        boolean es = true;
        if (arbol.isEmpty())
            es = false;
        else {
            Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>> ();
            cola.enQueue(arbol);
            GeneralTree<Integer> aux;
            int min;
            while ((!cola.isEmpty()) && (es)){
                aux = cola.deQueue();
                if (!aux.isLeaf()){
                    min = 9999;
                    for (GeneralTree<Integer> child : aux.getChildren()){
                        cola.enQueue(child);
                        if (child.getData() < min)
                            min = child.getData();
                    }
                    if (min != aux.getData())
                        es = false;
                }
            }
        }
        return es;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here

        GeneralTree <Integer> HI= new GeneralTree <Integer> (5);
        HI.addChild(new GeneralTree <Integer> (5));
        HI.addChild(new GeneralTree <Integer> (8));
        
        GeneralTree<Integer> HD = new GeneralTree<Integer> (7);
        HD.addChild(new GeneralTree <Integer> (9));
        HD.addChild(new GeneralTree <Integer> (7));
        
        GeneralTree <Integer> arbol = new GeneralTree <Integer> (2);
        arbol.addChild(HI);
        arbol.addChild(HD);
        arbol.addChild(new GeneralTree <Integer> (2));
        
        System.out.println (ParcialArboles.esDeSeleccion(arbol));
    }
}
