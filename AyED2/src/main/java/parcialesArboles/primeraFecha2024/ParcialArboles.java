/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialesArboles.primeraFecha2024;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen aruanno
 */
public class ParcialArboles {
    private GeneralTree<Integer> arbol;

    public ParcialArboles(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }
    
    public List<Integer> camino (int num){
        List<Integer> camino = new LinkedList<Integer> ();
        if (!this.arbol.isEmpty()){
            boolean encontre = false;
            encontre = buscarCamino (this.arbol, camino, num);
        }
        return camino;
    }
    
    private boolean buscarCamino (GeneralTree<Integer> a, List<Integer> camino, int num){
        boolean encontre = false;
        if (a.isLeaf()){
            camino.add(a.getData());
            encontre = true;
        } else {
            List<GeneralTree<Integer>> children = a.getChildren();
            if (children.size() >= num){
                camino.add(a.getData());
                Iterator<GeneralTree<Integer>> it = children.iterator();
                while (it.hasNext() && !encontre){
                    GeneralTree<Integer> aux = it.next();
                    encontre = buscarCamino (aux, camino, num);
                }
            }
        }
        return encontre;
    }
    
    public static void main(String args[]) {
        GeneralTree<Integer> arbol = new GeneralTree<Integer>(10);
        
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(5);
        subAb1.addChild(new GeneralTree<Integer>(-6));
        GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(22);
        subAb2.addChild(new GeneralTree<Integer>(28));
        subAb2.addChild(new GeneralTree<Integer>(55));
        subAb2.addChild(new GeneralTree<Integer>(18));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(8);
        a1.addChild(subAb1);
        a1.addChild(subAb2);
        
        arbol.addChild(a1);
        arbol.addChild(new GeneralTree<Integer>(42));
        
        GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(19);
        subAb3.addChild(new GeneralTree<Integer>(4));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(-5);
        a2.addChild(subAb3);
        a2.addChild(new GeneralTree<Integer>(-9));
        
        arbol.addChild(a2);
        
        ParcialArboles p = new ParcialArboles(arbol);
        
        System.out.println(p.camino(2));
        System.out.println(p.camino(3));
    }
}
