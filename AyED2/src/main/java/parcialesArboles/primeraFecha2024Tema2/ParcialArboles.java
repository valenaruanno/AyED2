/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialesArboles.primeraFecha2024Tema2;

import java.util.LinkedList;
import java.util.List;
import tp1.ejercicio8.Queue;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen aruanno
 */
public class ParcialArboles {
    private GeneralTree<Integer> arbol;
    
    public ParcialArboles(GeneralTree<Integer> arbol){
        this.arbol = arbol;
    }
    
    public List<Integer> nivel (int num){
        List<Integer> lista = new LinkedList<Integer>();
        if (!this.arbol.isEmpty()){
            Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>> ();
            boolean es = true;
            boolean encontre = false;
            cola.enQueue(this.arbol);
            cola.enQueue(null);
            GeneralTree<Integer> aux;
            while ((!cola.isEmpty()) && (!encontre)){
                aux = cola.deQueue();
                if (aux != null){
                    List<GeneralTree<Integer>> children = aux.getChildren();
                    lista.add(aux.getData());
                    if(children.size() < num)
                        es = false;
                    for (GeneralTree<Integer> child : children)
                        cola.enQueue(child);
                } else {
                    if (es)
                        encontre = true;
                    else {
                        if (!cola.isEmpty()){
                            cola.enQueue(null);
                            es = true;
                        }
                        lista.clear();
                    }
                }
            }
        }
        return lista;
    }
    
    public static void main(String[] args) {
        List<GeneralTree<Integer>> children1 = new LinkedList<GeneralTree<Integer>>();
        children1.add(new GeneralTree<Integer>(-6));
        children1.add(new GeneralTree<Integer>(2));
        children1.add(new GeneralTree<Integer>(8));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(5, children1);
        
        List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
        children2.add(new GeneralTree<Integer>(28));
        children2.add(new GeneralTree<Integer>(55));
        children2.add(new GeneralTree<Integer>(18));
        GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(22, children2);
        
        List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
        children3.add(new GeneralTree<Integer>(4));
        children3.add(new GeneralTree<Integer>(2));
        children3.add(new GeneralTree<Integer>(8));
        GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(19, children3);
        
        List<GeneralTree<Integer>> children4 = new LinkedList<GeneralTree<Integer>>();
        children4.add(subAb1);
        children4.add(subAb2);
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(8, children4);
        
        List<GeneralTree<Integer>> children5 = new LinkedList<GeneralTree<Integer>>();
        children5.add(subAb3);
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(-5, children5);
        
        List<GeneralTree<Integer>> ab = new LinkedList<GeneralTree<Integer>>();
        ab.add(a1);
        ab.add(a2);
        GeneralTree<Integer> a = new GeneralTree<Integer>(10, ab);
        
        ParcialArboles p = new ParcialArboles(a);
        
        System.out.println(p.nivel(3));
        System.out.println(p.nivel(4));
        
    }
}
