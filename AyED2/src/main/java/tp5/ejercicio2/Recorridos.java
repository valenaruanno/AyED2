/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp5.ejercicio2;

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
public class Recorridos {
    public List<Vertex<T>> dfs (Graph<T> grafo){
        List<Vertex<T>> lista = new LinkedList<>();
        boolean [] marca = new boolean [grafo.getSize()];
        for (int i = 0; i < grafo.getSize(); i++){
            if (!marca[i])
                dfs (i, grafo, marca, lista);
        }
        return lista;
    }
    
    private void dfs (int i, Graph<T> grafo, boolean [] marca, List<Vertex<T>> lista){
        marca[i] = true;
        Vertex<T> v = grafo.getVertex(i);
        lista.add(v);
        List<Edge<T>> adyacentes = grafo.getEdges(v);
        for (Edge<T> e : adyacentes){
            int j = e.getTarget().getPosition();
            if (!marca[j])
                dfs (j, grafo, marca, lista);
        }
    }
    
    public List<Vertex<T>> bfs (Graph<T> grafo){
        List<Vertex<T>> lista = new LinkedList<> ();
        boolean [] marca = new boolean [grafo.getSize()];
        for (int i = 0; i < grafo.getSize(); i++){
            if (!marca[i])
                bfs (i, grafo, marca, lista);
        }
        return lista;
    }
    public void bfs (int i, Graph<T> grafo, boolean [] marca, List<Vertex<T>> lista){
        Queue<Vertex<T>> cola = new Queue <Vertex<T>> ();
        marca[i]=true;
        cola.enQueue(grafo.getVertex(i));
        int j=0;
        while (!cola.isEmpty()){
            Vertex<T> aux = cola.deQueue();
            if (aux != null){
                lista.add(aux);
                List<Edge<T>> adyacentes = grafo.getEdges(aux);
                for (Edge<T> e: adyacentes){
                    j= e.getTarget().getPosition();
                    if (!marca[j])
                        bfs (j, grafo, marca, lista);
                }
            }
        }
    }
}
