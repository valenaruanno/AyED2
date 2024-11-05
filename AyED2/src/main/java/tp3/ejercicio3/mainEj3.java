/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ejercicio3;

import tp3.ejercicio1.GeneralTree;

/**
 *
 * @author valen
 */
public class mainEj3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
           // TODO code application logic here
        GeneralTree <Integer> HII = new GeneralTree <Integer> (8);
        GeneralTree <Integer> HID = new GeneralTree <Integer> (23);
        GeneralTree <Integer> HI = new GeneralTree <Integer> (16);
        HI.addChild(HII);
        HI.addChild(HID);
    
        GeneralTree <Integer> HMI = new GeneralTree <Integer> (9);
        GeneralTree <Integer> HM = new GeneralTree <Integer> (7);
        HM.addChild(HMI);
        
        GeneralTree <Integer> HDI = new GeneralTree <Integer> (1);
        GeneralTree <Integer> HDD = new GeneralTree <Integer> (3);
        GeneralTree <Integer> HD = new GeneralTree <Integer> (17);
        HD.addChild(HDI);
        HD.addChild(HDD);
        
        GeneralTree <Integer> arbol = new GeneralTree <Integer> (15);
        arbol.addChild(HI);
        arbol.addChild(HM);
        arbol.addChild(HD);
        
            System.out.println("La altura del arbol es: " + arbol.altura());
            System.out.println("El nivel del 7 es: " + arbol.nivel(7));
            System.out.println("El ancho maximo es: " + arbol.ancho());
    }
}
