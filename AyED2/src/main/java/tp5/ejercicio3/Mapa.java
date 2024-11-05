/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp5.ejercicio3;

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
public class Mapa {
    private Graph<String> grafo; 
    
    public Mapa (Graph<String> grafo){
        this.grafo = grafo;
    }
    
    public List<String> devolverCamino(String ciudad1, String ciudad2){
        List<String> lista = new LinkedList<String> ();
        buscarCaminoOrigen(grafo, ciudad1, ciudad2, lista);
        return lista;
    }
    
    private void buscarCaminoOrigen (Graph<String> grafo, String ciudad1, String ciudad2, List<String> lista){
        Vertex<String> v = grafo.search(ciudad1);
        if (v != null){
            boolean ok;
            boolean [] marca = new boolean [grafo.getSize()];
            ok = buscarCamino (grafo, v, ciudad2, lista, marca);
        }
    }
    
    
    private boolean buscarCamino (Graph<String> grafo, Vertex<String> v, String ciudad2, List<String> lista, boolean [] marca){
        boolean es = false;
        marca[v.getPosition()] = true;
        if (v.getData().equals(ciudad2))
            es = true;
        else {
            lista.add(v.getData());
            List<Edge<String>> adyacentes = grafo.getEdges(v);
            Iterator <Edge<String>> it = adyacentes.iterator();
            while ((it.hasNext()) && (!es)){
                Vertex<String> aux = it.next().getTarget();
                if (!marca[aux.getPosition()])
                    es = buscarCamino (grafo, aux, ciudad2, lista, marca);
            }
            if (!es)
                lista.remove(v.getData());
        }
        return es;
    }
    
    
    //------------------------------------------BUSCAR CAMINO EXCEPTUANDO---------------------------------------
    
    public List<String> buscarCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades){
        List<String> camino = new LinkedList<>();
        buscarCaminoOrigenExceptuando (this.grafo, ciudad1, ciudad2, camino, ciudades);
        return camino;
    }
    
    private void buscarCaminoOrigenExceptuando (Graph<String> grafo, String ciudad1, String ciudad2, List<String> camino, List<String> ciudades){
        Vertex<String> v = grafo.search(ciudad1);
        boolean es;
        if (v != null){
            boolean [] marca = new boolean [grafo.getSize()];
            es = buscarCaminoExceptuando (grafo, v, ciudad2, camino, marca, ciudades);
        }
    }
    
    private boolean buscarCaminoExceptuando (Graph<String> grafo, Vertex<String> v, String ciudad2, List<String> camino, boolean [] marca, List<String> ciudades){
        marca [v.getPosition()] = true;
        boolean es = false;
        if (v.getData().equals(ciudad2))
            es = true;
        else{
            camino.add(v.getData());
            List<Edge<String>> adyacentes = grafo.getEdges(v); 
            Iterator<Edge<String>> it = adyacentes.iterator();
            while (it.hasNext() && (!es)){
                Vertex<String> destino = it.next().getTarget();
                int i= 0;
                boolean ok = false;
                while (i < ciudades.size() && (!ok)){
                    if (ciudades.get(i).equals(destino.getData()))
                        ok = false;
                    i++;
                }
                if (!ok)
                    buscarCaminoExceptuando (grafo, destino, ciudad2, camino, marca, ciudades);
            }
            if (!es)
                camino.remove(v.getData());
        }
        return es;
    }
    
    //------------------------------------------CAMINO MAS CORTO-----------------------------------------------
    
    public List<String> caminoMasCorto (String ciudad1, String ciudad2){
        List<String> camino = new LinkedList<>();
        List<String> caminoCorto = new LinkedList<>();
        buscarCiudadOrigenMasCorto (this.grafo, ciudad1, ciudad2, camino, caminoCorto);
        return camino;
    }
    
    private void buscarCiudadOrigenMasCorto (Graph<String> grafo, String ciudad1, String ciudad2, List<String> camino, List<String> caminoCorto){
        Vertex<String> origen = grafo.search(ciudad1);
        if (origen != null){
            boolean [] marca = new boolean [grafo.getSize()];
            dfs3(grafo, origen, ciudad2, camino, caminoCorto, marca);
        }
    }
    
    private void dfs3 (Graph<String> grafo, Vertex<String> v, String ciudad2, List<String> camino, List<String> caminoCorto, boolean [] marca){
        marca [v.getPosition()] = true;
        if (v.getData().equals(ciudad2)){
            if (camino.size() < caminoCorto.size()){
                caminoCorto.clear();
                caminoCorto.addAll(camino);
            }
            else {
                caminoCorto.clear();
                caminoCorto.addAll(camino);
            }
        } else {
            camino.add(v.getData());
            List<Edge<String>> adyacentes = grafo.getEdges(v);
            Iterator<Edge<String>> it = adyacentes.iterator();
            while (it.hasNext()){
                Vertex<String> destino = it.next().getTarget();
                if (!marca[destino.getPosition()])
                    dfs3 (grafo, destino, ciudad2, camino, caminoCorto, marca);
            }
            camino.remove(v.getData());
        }
    }
}
