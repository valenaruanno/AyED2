/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2.ejercicio9;

/**
 *
 * @author valen aruanno
 */
public class SyD {
    private int suma;
    private int dif;

    public SyD(int suma, int dif) {
        this.suma = suma;
        this.dif = dif;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public int getDif() {
        return dif;
    }

    public void setDif(int dif) {
        this.dif = dif;
    }
    
    public String toString (){
        return this.suma + " | " + this.dif;
    }
}
