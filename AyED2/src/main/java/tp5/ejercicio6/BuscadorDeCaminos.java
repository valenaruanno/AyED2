/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp5.ejercicio6;

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
public class BuscadorDeCaminos {
    private Graph<String> bosque;
    
    public BuscadorDeCaminos (Graph<String> bosque){
        this.bosque = bosque;
    }
    public List<List<String>> recorridosMasSeguros (){
        List<List<String>> caminos = new LinkedList<List<String>> ();
        if (!this.bosque.isEmpty())
            buscarCasaCaperucita (this.bosque, caminos);
        return caminos;
    }
    
    private void buscarCasaCaperucita (Graph<String> bosque, List<List<String>> caminos){
        Vertex<String> casa = bosque.search("Casa Caperucita");
        if (casa != null){
            boolean [] marca = new boolean [bosque.getSize()];
            List<String> caminoAct = new LinkedList<String> ();
            buscarCaminos (bosque, casa, caminos, marca, caminoAct);
        }
    }
    
    private void buscarCaminos (Graph<String> bosque, Vertex<String> aux, List<List<String>> caminos, boolean [] marca, List<String> caminoAct){
        caminoAct.add(aux.getData());
        marca [aux.getPosition()] = true;
        if (aux.getData().equals("Casa abuelita")){
            caminos.add(new LinkedList<String> (caminoAct));
        } else {
            List<Edge<String>> adyacentes = bosque.getEdges(aux);
            for (Edge<String> e : adyacentes){
                Vertex<String> v = e.getTarget();
                if ((!marca[v.getPosition()]) && (e.getWeight() < 5))
                    buscarCaminos (bosque, e.getTarget(), caminos, marca, caminoAct);
            }
        }
        caminoAct.remove(caminoAct.size() - 1);
        marca [aux.getPosition()] = false;
    }
}
