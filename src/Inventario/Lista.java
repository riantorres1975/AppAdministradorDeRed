/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventario;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author DELL
 */
public class Lista {
    private final SimpleStringProperty Cant;
    private final SimpleStringProperty Arti;
    
    public Lista(String Arti,String Cant){
        this.Arti=new SimpleStringProperty(Arti);
        this.Cant=new SimpleStringProperty(Cant);
    }
    
     public String getCant() {
        return Cant.get();
    }
 
    public String getArti() {
        return Arti.get();
    }
    
    public void setCant(String Canti){
        Cant.set(Canti);
    }
    
    public void setArti(String Artic){
        Arti.set(Artic);
    }
}
