/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialGrafos.parcial2024;

import java.util.LinkedList;
import java.util.List;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

/**
 *
 * @author valen aruanno
 */
public class ParcialGrafo {
    public List<Estacion> menosTransbordos (Graph<String> maps, String origen){
        List<Estacion> lista = new LinkedList<Estacion> ();
        if (!maps.isEmpty()){
            Vertex<String> aux = maps.search(origen);
            if (aux != null){
                boolean [] marca = new boolean [maps.getSize()];
                procesar (maps, aux, lista, marca, 0);
            }
        }
        return lista;
    }
    
    public void procesar (Graph<String> maps, Vertex<String> origen, List<Estacion> lista, boolean [] marca, int cantT){
        marca[origen.getPosition()] = true;
        List<Edge<String>> adyacentes = maps.getEdges(origen);
        if (adyacentes.size() == 1){
            lista.add(new Estacion (origen.getData(), cantT));
        } else {
            if (adyacentes.size() > 2)
                cantT++;
            for (Edge<String> e: adyacentes){
                Vertex<String> v = e.getTarget();
                if (!marca[v.getPosition()])
                    procesar (maps, v, lista, marca, cantT);
            }
        }
        marca[origen.getPosition()] = false;
    }
    
    public static void main (String [] args){
        /*Graph<String> grafo = new Graph<String> ();

        // Agregar estaciones
        grafo.agregarEstacion("Butanta");
        grafo.agregarEstacion("Pinheiros");
        grafo.agregarEstacion("Faria Lima");
        grafo.agregarEstacion("Paulista");
        grafo.agregarEstacion("Clinicas");
        grafo.agregarEstacion("Republica");
        grafo.agregarEstacion("Luz");
        grafo.agregarEstacion("Trianon");
        grafo.agregarEstacion("Brigadeiro");
        grafo.agregarEstacion("Paraiso");
        grafo.agregarEstacion("Saude");
        grafo.agregarEstacion("Vila Madalena");
        grafo.agregarEstacion("Armenia");
        grafo.agregarEstacion("Tiradentes");
        grafo.agregarEstacion("Vila Olimpica");
        grafo.agregarEstacion("Cidade Jardim");
        grafo.agregarEstacion("Hebraica");
        grafo.agregarEstacion("C. Universitaria");
        grafo.agregarEstacion("Vila Lobos");

        // Agregar conexiones según la imagen
        /*grafo.agregarConexion("Butanta", "Pinheiros");
        grafo.agregarConexion("Pinheiros", "Butanta");
        grafo.agregarConexion("Pinheiros", "Faria Lima");
        grafo.agregarConexion("Faria Lima", "Pinheiros");
        grafo.agregarConexion("Faria Lima", "Paulista");
        grafo.agregarConexion("Paulista", "Faria Lima");
        grafo.agregarConexion("Paulista", "Republica");
        grafo.agregarConexion("Republica", "Paulista");
        grafo.agregarConexion("Republica", "Luz");
        grafo.agregarConexion("Luz", "Republica");
        grafo.agregarConexion("Paulista", "Clinicas");
        grafo.agregarConexion("Clinicas", "Paulista");
        grafo.agregarConexion("Vila Madalena", "Clinicas");
        grafo.agregarConexion("Clinicas", "Vila Madalena");
        grafo.agregarConexion("Paulista", "Trianon");
        grafo.agregarConexion("Trianon", "Paulista");
        grafo.agregarConexion("Trianon", "Brigadeiro");
        grafo.agregarConexion("Brigadeiro", "Trianon");
        grafo.agregarConexion("Republica", "Paraiso");
        grafo.agregarConexion("Paraiso", "Republica");
        grafo.agregarConexion("Paraiso", "Saude");
        grafo.agregarConexion("Saude", "Paraiso");
        grafo.agregarConexion("Pinheiros", "C. Universitaria");
        grafo.agregarConexion("C. Universitaria", "Pinheiros");
        grafo.agregarConexion("C. Universitaria", "Vila Lobos");
        grafo.agregarConexion("Vila Lobos", "C. Universitaria");
        grafo.agregarConexion("Pinheiros", "Hebraica");
        grafo.agregarConexion("Hebraica", "Pinheiros");
        grafo.agregarConexion("Hebraica", "Cidade Jardim");
        grafo.agregarConexion("Cidade Jardim", "Hebraica");
        grafo.agregarConexion("Cidade Jardim", "Vila Olimpica");
        grafo.agregarConexion("Vila Olimpica", "Cidade Jardim");
        grafo.agregarConexion("Paulista", "Tira Dentes");
        grafo.agregarConexion("Tira Dentes", "Paulista");
        grafo.agregarConexion("Tira Dentes", "Republica");
        grafo.agregarConexion("Republica", "Tira Dentes");
        grafo.agregarConexion("Armenia", "Tira Dentes");
        grafo.agregarConexion("Tira Dentes", "Armenia");*/
    }
}
