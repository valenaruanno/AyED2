/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialGrafos.enunciado4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

/**
 *
 * @author valen aruanno
 */
public class Parcial {
    public List<String> resolver (Graph<Ciudad> ciudades, String origen, String destino, int maxControles){
        List<String> listaMax = new LinkedList<String>();
        if (!ciudades.isEmpty()){
            Vertex<Ciudad> vOrigen = null;
            Vertex<Ciudad> vDestino = null;
            buscar (ciudades, origen, destino, vOrigen, vDestino);
            if ((vOrigen != null) && (vDestino != null)){
                boolean [] marca = new boolean [ciudades.getSize()];
                int maxTransito = -1;
                List<String> lista = new LinkedList<String>();
                maxTransito = procesar (ciudades, vOrigen, vDestino, maxControles, lista, listaMax, marca, maxTransito, vOrigen.getData().getCantDias());
                System.out.println(maxTransito);
            }
        }
        return listaMax;
    } 
    
    private void buscar (Graph<Ciudad> ciudades, String origen, String destino, Vertex<Ciudad> vOrigen, Vertex<Ciudad> vDestino){
        List<Vertex<Ciudad>> vertices = ciudades.getVertices();
        Iterator<Vertex<Ciudad>> it = vertices.iterator();
        while ((it.hasNext()) && (vOrigen == null || (vDestino == null))){
            Vertex<Ciudad> v = it.next();
            if (v.getData().getNombre().equals(origen))
                vOrigen = v;
            if (v.getData().getNombre().equals(destino))
                vDestino = v;
        }
    }
    
    private int procesar (Graph<Ciudad> ciudades, Vertex<Ciudad> origen, Vertex<Ciudad> destino, int maxControles, List<String> lista, List<String> listaMax, boolean [] marca, int maxTransito, int transito){
        marca [origen.getPosition()] = true;
        lista.add(origen.getData().getNombre());
        if (origen == destino){
            if (transito > maxTransito){
                maxTransito = transito;
                listaMax.clear();
                listaMax.addAll(lista);
            }
        } else {
            List<Edge<Ciudad>> adyacentes = ciudades.getEdges(origen);
            for (Edge<Ciudad> e : adyacentes){
                Vertex<Ciudad> aux = e.getTarget();
                if ((!marca[aux.getPosition()]) && e.getWeight() <= maxControles)
                    maxTransito = procesar (ciudades, aux, destino, maxControles, lista, listaMax, marca, maxTransito, transito + aux.getData().getCantDias());
            }
        }
        lista.remove(lista.size() - 1);
        marca[origen.getPosition()] = false;
        return maxTransito;
    }
    public static void main(String args[]) {
        Graph<Ciudad> grafo = new AdjListGraph<Ciudad>();
        //Descarte Saladillo, Lobos y Pinamar
        Vertex<Ciudad> v1 = grafo.createVertex(new Ciudad("Suipacha", 3));
        Vertex<Ciudad> v2 = grafo.createVertex(new Ciudad("Carlos Keen", 2));
        Vertex<Ciudad> v3 = grafo.createVertex(new Ciudad("Moreno", 2));
        Vertex<Ciudad> v4 = grafo.createVertex(new Ciudad("Quilmes", 3));
        Vertex<Ciudad> v5 = grafo.createVertex(new Ciudad("Navarro", 1));
        Vertex<Ciudad> v6 = grafo.createVertex(new Ciudad("Cañuelas", 2));
        Vertex<Ciudad> v7 = grafo.createVertex(new Ciudad("Abasto", 3));
        Vertex<Ciudad> v8 = grafo.createVertex(new Ciudad("La Plata", 1));
        
        grafo.connect(v1, v2, 2);
        grafo.connect(v2, v1, 2);
        grafo.connect(v2, v3, 2);
        grafo.connect(v3, v2, 2);
        grafo.connect(v3, v4, 2);
        grafo.connect(v4, v3, 2);
        grafo.connect(v1, v5, 2);
        grafo.connect(v5, v1, 2);
        grafo.connect(v5, v6, 2);
        grafo.connect(v6, v5, 2);
        grafo.connect(v6, v7, 2);
        grafo.connect(v7, v6, 2);
        grafo.connect(v7, v3, 3);
        grafo.connect(v3, v7, 3);
        grafo.connect(v7, v8, 2);
        grafo.connect(v8, v7, 2);
        grafo.connect(v8, v4, 2);
        grafo.connect(v4, v8, 2);
        
        Parcial p = new Parcial();
        
        System.out.println(p.resolver(grafo, "La Plata", "Suipacha", 2));
        //System.out.println(p.resolver(grafo, "La Plata", "Carlos Keen", 2));
    }
}
