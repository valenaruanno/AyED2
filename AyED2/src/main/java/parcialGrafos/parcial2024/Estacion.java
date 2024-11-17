/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialGrafos.parcial2024;

/**
 *
 * @author valen aruanno
 */
public class Estacion {
    private String nombre;
    private int cantTransbordos;

    public Estacion(String nombre, int cantTransbordos) {
        this.nombre = nombre;
        this.cantTransbordos = cantTransbordos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantTransbordos() {
        return cantTransbordos;
    }

    public void setCantTransbordos(int cantTransbordos) {
        this.cantTransbordos = cantTransbordos;
    }
    
    
}
