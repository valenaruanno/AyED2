/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp5.ejercicio4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

/**
 *
 * @author valen aruanno
 */
public class VisitaOslo {
    public List<String> paseoEnBici (Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos){
        List<String> camino = new LinkedList<String> ();
        Vertex<String> origen = lugares.search("Ayuntamiento");
        if ((!lugares.isEmpty()) && (origen != null)){
            boolean esta;
            boolean [] marca = new boolean [lugares.getSize()];
            esta = buscarCamino (lugares, origen, destino, maxTiempo, lugaresRestringidos, camino, marca);
        }
        return camino;
    } 
    
    private boolean buscarCamino (Graph<String> lugares, Vertex<String> origen, String destino, int tiempoMax, List<String> lugaresRestringidos, List<String> camino, boolean [] marca){
        camino.add(origen.getData());
        marca[origen.getPosition()] = true;
        boolean encontre = false;
        if (origen.getData().equals(destino))
            encontre = true;
        else {
            List<Edge<String>> adyacentes = lugares.getEdges(origen);
            Iterator<Edge<String>> it = adyacentes.iterator();
            while ((it.hasNext()) && (!encontre)){
                Edge<String> e = it.next();
                Vertex<String> v = e.getTarget();
                if ((!lugaresRestringidos.contains(v.getData())) && (!marca[v.getPosition()]) && (tiempoMax - e.getWeight() >= 0))
                    encontre = buscarCamino (lugares, v, destino, tiempoMax - e.getWeight(), lugaresRestringidos, camino, marca);
            }
            if (!encontre)
                camino.remove(camino.size() - 1);
        }
        return encontre;
    }
}
