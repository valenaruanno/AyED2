/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.ejercicio2;

import java.util.LinkedList;
import java.util.List;
import tp1.ejercicio8.Queue;
import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen aruanno
 */
public class RecorridosAG {
    public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree<Integer> arbol, int num){
        List <Integer> lista = new LinkedList<>();
        if (!arbol.isEmpty())
            buscarPreOrden (arbol, num, lista);
        return lista;
    }
    
    private void buscarPreOrden (GeneralTree<Integer> arbol, int num, List<Integer> lista){
        if ((arbol.getData() > num) && (arbol.getData() % 2 != 0))
            lista.add(arbol.getData());
        for (GeneralTree<Integer> children : arbol.getChildren()){
            buscarPreOrden (children, num, lista);
        }
    }
    
    public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree<Integer> arbol, int num){
        List<Integer> lista = new LinkedList<>();
        if (!arbol.isEmpty())
            buscarInOrden (arbol, num, lista);
        return lista;
    }
    
    private void buscarInOrden (GeneralTree<Integer> arbol, int num, List<Integer> lista){
        boolean check = false;
        if (!arbol.isLeaf()){
            for (GeneralTree<Integer> children : arbol.getChildren()){
                buscarInOrden (children, num, lista);
                if ((!check) && (arbol.getData() > num) && (arbol.getData() % 2 != 0))
                    lista.add(arbol.getData());
                    check = true;
            }
        } else {
            if ((arbol.getData() > num) && (arbol.getData() % 2 != 0))
                lista.add(arbol.getData());
        }
    }
    
    
    public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree<Integer> arbol, int num){
        List <Integer> lista = new LinkedList<>();
        if (!arbol.isEmpty())
            buscarPostOrden (arbol, num, lista);
        return lista;
    }
    
    private void buscarPostOrden (GeneralTree<Integer> arbol, int num, List<Integer> lista){
        for (GeneralTree<Integer> children: arbol.getChildren()){
            buscarPostOrden (children, num, lista);
        }
        if ((arbol.getData() > num) && (arbol.getData() % 2 != 0))
            lista.add(arbol.getData());
    }
    
    public List<Integer> numerosImparesMayoresQuePorNivel (GeneralTree<Integer> arbol, int num){
        List <Integer> lista = new LinkedList<>();
        if (!arbol.isEmpty()){
            Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
            cola.enQueue(arbol);
            GeneralTree<Integer> aux;
            while (!cola.isEmpty()){
                aux = cola.deQueue();
                if ((aux.getData() > num) && (aux.getData() % 2 != 0))
                    lista.add(aux.getData());
                for (GeneralTree<Integer> children : aux.getChildren())
                    cola.enQueue(children);
            }
        }
        return lista;
    }
    
    public static void main (String []args){
           // TODO code application logic here
        GeneralTree <Integer> HII = new GeneralTree <Integer> (8);
        GeneralTree <Integer> HID = new GeneralTree <Integer> (23);
        GeneralTree <Integer> HI = new GeneralTree <Integer> (16);
        HI.addChild(HII);
        HI.addChild(HID);
    
        GeneralTree <Integer> HMI = new GeneralTree <Integer> (9);
        GeneralTree <Integer> HM = new GeneralTree <Integer> (7);
        HM.addChild(HMI);
        
        GeneralTree <Integer> HDI = new GeneralTree <Integer> (1);
        GeneralTree <Integer> HDD = new GeneralTree <Integer> (3);
        GeneralTree <Integer> HD = new GeneralTree <Integer> (17);
        HD.addChild(HDI);
        HD.addChild(HDD);
        
        GeneralTree <Integer> arbol = new GeneralTree <Integer> (15);
        arbol.addChild(HI);
        arbol.addChild(HM);
        arbol.addChild(HD);
        
        List <Integer> lista = new LinkedList <Integer> ();
        RecorridosAG reco = new RecorridosAG ();
        lista = reco.numerosImparesMayoresQuePreOrden(arbol, 6);
        System.out.println("-------------PRE-ORDEN--------------------");
        for (Integer l: lista)
            System.out.println(l.toString());
        
        lista = reco.numerosImparesMayoresQueInOrden(arbol, 6);
        System.out.println("-------------IN-ORDEN--------------------");
        for (Integer l: lista)
            System.out.println(l.toString());
        
        lista = reco.numerosImparesMayoresQuePostOrden(arbol, 6);
        System.out.println("-------------POST-ORDEN--------------------");
        for (Integer l: lista)
            System.out.println(l.toString());
        
        lista = reco.numerosImparesMayoresQuePorNivel(arbol, 6);
        System.out.println("-------------POR-NIVEL--------------------");
        for (Integer l: lista)
            System.out.println(l.toString());
    }
}
