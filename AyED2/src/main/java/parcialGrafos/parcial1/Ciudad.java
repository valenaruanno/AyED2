/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialGrafos.parcial1;

/**
 *
 * @author valen aruanno
 */
public class Ciudad {
    private String nombre;
    private int cantDias;

    public Ciudad(int cantDias, String nombre) {
        this.nombre = nombre;
        this.cantDias = cantDias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantDias() {
        return cantDias;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }
    
    
}
