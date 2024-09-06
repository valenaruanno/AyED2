/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.ejercicio8;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author valen
 */
public class Queue <T> extends Sequence {
    private List <T> data;
    
    public Queue (){
        this.data = new ArrayList <T> ();
    }
    
    public void enQueue (T dato){
        data.add(dato);
    }
    public T deQueue (){
        return data.remove(0);
    }
    
    public T head (){
        return data.get(0);
    }
    
    public boolean isEmpty (){
        return data.size() == 0;
    }
    
    public int size (){
        return data.size();
    }
    
    public String toString (){
        String str = "[";
        for (T d: data)
            str = str + d + ", ";
        str = str.substring(0, str.length() - 2) + "]";
        return str;
        }
}
