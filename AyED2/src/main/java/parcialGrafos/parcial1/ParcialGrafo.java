/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialGrafos.parcial1;

import java.awt.BorderLayout;
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
public class ParcialGrafo {
    public List<Ciudad> resolver (Graph<Ciudad> mapa, String ciudad, int cantDias){
        List<Ciudad> camino = new LinkedList<Ciudad> ();
        List<Ciudad> caminoAct = new LinkedList<Ciudad> ();
        if (!mapa.isEmpty()){
            Vertex<Ciudad> aux = buscarCiudad (mapa, ciudad);
            if (aux != null){
                boolean [] marca = new boolean [mapa.getSize()];
                buscarCamino (mapa, aux, cantDias, camino, caminoAct, marca);
            }
        }
        return camino;
    }
    
    private Vertex<Ciudad> buscarCiudad (Graph<Ciudad> mapa, String ciudad){
        Vertex<Ciudad> aux = null;
        Iterator<Vertex<Ciudad>> it = mapa.getVertices().iterator();
        while (it.hasNext() && aux == null){
            Vertex<Ciudad> v = it.next();
            if (v.getData().getNombre().equals(ciudad))
                aux = v;
        }
        return aux;
    }
    
    private void buscarCamino (Graph<Ciudad> mapa, Vertex<Ciudad> v, int cantDias, List<Ciudad> camino, List<Ciudad> caminoAct, boolean [] marca){
        caminoAct.add(v.getData());
        marca [v.getPosition()] = true;
        cantDias -= v.getData().getCantDias();
        if (cantDias == 0){
            if (caminoAct.size() > camino.size()){
                camino.clear();
                camino.addAll(caminoAct);
            }
        } else {
            List<Edge<Ciudad>> adyacentes = mapa.getEdges(v);
            for (Edge<Ciudad> a: adyacentes){
                Vertex<Ciudad> destino = a.getTarget();
                if (!marca[destino.getPosition()] && cantDias - a.getWeight() >= 0)
                    buscarCamino (mapa, destino, cantDias, camino, caminoAct, marca);
            }
        }
        caminoAct.remove(caminoAct.size() - 1);
        marca[v.getPosition()] = false;
    }
    
    public static void main(String args[]) {
        Graph<Ciudad> mapa = new AdjListGraph<Ciudad>();
        Vertex<Ciudad> MarDelPlata = mapa.createVertex(new Ciudad(7, "Mar Del Plata"));
        Vertex<Ciudad> Pila = mapa.createVertex(new Ciudad(1, "Pila"));
        Vertex<Ciudad> Dolores = mapa.createVertex(new Ciudad(1, "Dolores"));
        Vertex<Ciudad> Chascomus = mapa.createVertex(new Ciudad(1, "Chascomús"));
        Vertex<Ciudad> MarAzul = mapa.createVertex(new Ciudad(3, "Mar Azul"));
        Vertex<Ciudad> Pinamar = mapa.createVertex(new Ciudad(4, "Pinamar"));
        Vertex<Ciudad> Madariaga = mapa.createVertex(new Ciudad(1, "Madariaga"));
        Vertex<Ciudad> LaPlata = mapa.createVertex(new Ciudad(5, "La Plata"));
        Vertex<Ciudad> LasGaviotas = mapa.createVertex(new Ciudad(1, "Las Gaviotas"));
        Vertex<Ciudad> Querandi = mapa.createVertex(new Ciudad(1, "Querandi"));
        Vertex<Ciudad> Hudson = mapa.createVertex(new Ciudad(1, "Hudson"));
        
        mapa.connect(MarDelPlata, Pila);
        mapa.connect(Pila, MarDelPlata);
        mapa.connect(Pila, Dolores);
        mapa.connect(Dolores, Pila);
        mapa.connect(Dolores, Chascomus);
        mapa.connect(Chascomus, Dolores);
        
        mapa.connect(MarDelPlata, MarAzul);
        mapa.connect(MarAzul, MarDelPlata);
        mapa.connect(MarAzul, Pinamar);
        mapa.connect(Pinamar, MarAzul);
        mapa.connect(Pinamar, Madariaga);
        mapa.connect(Madariaga, Pinamar);
        mapa.connect(Dolores, Madariaga);
        mapa.connect(Madariaga, Dolores);
        mapa.connect(Madariaga, LaPlata);
        mapa.connect(LaPlata, Madariaga);
        mapa.connect(Chascomus, LaPlata);
        mapa.connect(LaPlata, Chascomus);
        
        mapa.connect(MarAzul, LasGaviotas);
        mapa.connect(LasGaviotas, MarAzul);
        mapa.connect(MarAzul, Querandi);
        mapa.connect(Querandi, MarAzul);
        mapa.connect(LaPlata, Hudson);
        mapa.connect(Hudson, LaPlata);
        
        ParcialGrafo p = new ParcialGrafo();
        for (Ciudad c: p.resolver(mapa, "Mar Del Plata", 15))
            System.out.println(c.getNombre());
    }
}
