/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialGrafos.segundaFecha2024;

import java.util.Iterator;
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
public class ParcialGrafos {
    public List<Perfil> invitacionMasterClass (Graph<String> red, String usuario, int distancia, int limite){
        List<Perfil> lista = new LinkedList<Perfil> ();
        if (!red.isEmpty()){
            Vertex<String> inicio = red.search(usuario);
            if (inicio != null){
                boolean [] marca = new boolean [red.getSize()];
                procesar (red, inicio, distancia, limite, lista, marca);
            }
        }
        return lista;
    }
    
    private void procesar (Graph<String> red, Vertex<String> inicio, int distancia, int limite, List<Perfil> lista, boolean [] marca){
        Queue<Vertex<String>> cola = new Queue<Vertex<String>> ();
        int dist = 1;
        List<Edge<String>> adyacentes = red.getEdges(inicio);
        for (Edge<String> e: adyacentes){
            if (!marca[e.getTarget().getPosition()]){
                marca[e.getTarget().getPosition()] = true;
                cola.enQueue(e.getTarget());
            }
        }
        cola.enQueue(null);
        Vertex<String> aux;
        while (!cola.isEmpty() && (dist <= distancia) && (lista.size() <= limite)){
            aux = cola.deQueue();
            if (aux != null){
                lista.add(new Perfil(aux.getData(), dist));
                List<Edge<String>> adya = red.getEdges(aux);
                for (Edge<String> e: adya){
                    if (!marca[e.getTarget().getPosition()]){
                        marca[e.getTarget().getPosition()] = true;
                        cola.enQueue(e.getTarget());
                    }
                }
            } else {
                if (!cola.isEmpty()){
                    dist++;
                    cola.enQueue(null);
                }
            }
        }
    } 
}
