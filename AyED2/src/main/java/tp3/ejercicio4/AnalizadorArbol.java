/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ejercicio4;

import java.util.LinkedList;
import tp1.ejercicio8.Queue;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class AnalizadorArbol {
    public double devolverMaximoPromedio (GeneralTree<AreaEmpresa> arbol){
        double prom;
        double promMax = -1;
        int sum = 0;
        int cant = 0;
        Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>> ();
        cola.enQueue(arbol);
        cola.enQueue(null);
        GeneralTree<AreaEmpresa> aux;
        while (!cola.isEmpty()){
            aux = cola.deQueue();
            if (aux != null){
                cant++;
                sum += aux.getData().getTardanza();
                for (GeneralTree<AreaEmpresa> children : aux.getChildren())
                    cola.enQueue(children);
            } else {
                prom = sum / cant;
                if (prom > promMax)
                    promMax = prom;
                if (!cola.isEmpty()){
                    cant = 0;
                    sum = 0;
                    cola.enQueue(null);
                }
            }
        }
        return promMax;
    }
    
    public static void main(String [] args){
        // TODO code application logic here
        AreaEmpresa a = new AreaEmpresa ("marketing", 3);
        AreaEmpresa a1 = new AreaEmpresa ("mar", 1);
        AreaEmpresa a2 = new AreaEmpresa ("ket", 3);
        GeneralTree <AreaEmpresa> HDI = new GeneralTree<AreaEmpresa> (a1);
        GeneralTree <AreaEmpresa> HDD = new GeneralTree<AreaEmpresa> (a2);
        LinkedList <GeneralTree<AreaEmpresa>> hijosHD = new LinkedList <GeneralTree<AreaEmpresa>> ();
        hijosHD.add(HDI);
        hijosHD.add(HDD);
        GeneralTree <AreaEmpresa> HD = new GeneralTree<AreaEmpresa> (a, hijosHD);
        AreaEmpresa a3 = new AreaEmpresa ("negocios", 5);
        GeneralTree <AreaEmpresa> HI = new GeneralTree<AreaEmpresa> (a3);
        
        LinkedList <GeneralTree<AreaEmpresa>> hijos = new LinkedList <GeneralTree<AreaEmpresa>> ();
        hijos.add(HI);
        hijos.add(HD);
        GeneralTree <AreaEmpresa> arbol = new GeneralTree<AreaEmpresa> (a, hijos);
        
        AnalizadorArbol an = new AnalizadorArbol ();
        System.out.println("El promedio maximo es" + an.devolverMaximoPromedio(arbol));
    }
}
