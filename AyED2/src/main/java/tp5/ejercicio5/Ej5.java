/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp5.ejercicio5;

import java.util.LinkedList;
import java.util.List;
import tp1.ejercicio8.Queue;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

/**
 *
 * @author valen aruanno
 */
public class Ej5 {
    public static List<Persona> buscarJubilados (Graph<Persona> grafo, Persona empleado, int grado){
        List<Persona> lista = new LinkedList<Persona> ();
        if (!grafo.isEmpty())
            buscarEmpleado(grafo, empleado, grado, lista);
        return lista;
    }
    
    private static void buscarEmpleado (Graph<Persona> grafo, Persona empleado, int grado, List<Persona> lista){
        Vertex<Persona> aux = grafo.search(empleado);
        if (aux != null){
            boolean[] marca = new boolean [grafo.getSize()];
            procesar (grafo, aux, grado, lista, marca);
        }
    }
    
    private static void procesar (Graph<Persona> grafo, Vertex<Persona> aux, int grado, List<Persona> lista, boolean [] marca){
         int gradoAct = 0;
         Queue<Vertex<Persona>> cola = new Queue<Vertex<Persona>> ();
         cola.enQueue(aux);
         cola.enQueue(null);
         Vertex<Persona> p;
         while ((!cola.isEmpty()) && (gradoAct < grado)){
             p = cola.deQueue();
            if ((p != null) && (!marca[p.getPosition()])){
                System.out.println("Es distinto de null");
                marca [p.getPosition()] = true;
                if ((p.getData().getRol().equals("jubilado")) && (lista.size() < 40)){
                   lista.add(p.getData());
                }
                List<Edge<Persona>> adyacentes = grafo.getEdges(p);
                for (Edge<Persona> e: adyacentes)
                    cola.enQueue(e.getTarget());
            } else {
                if (!cola.isEmpty()){
                    gradoAct++;
                    cola.enQueue(null);
                }
            }
        }
    }
}
