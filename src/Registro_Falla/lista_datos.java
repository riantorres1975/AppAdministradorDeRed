/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registro_Falla;

/**
 *
 * @author Markoski
 */
public class lista_datos {
    String descripcion, tipo_falla;
    
    public void Agregar_falla(String tipo,String descri){
        this.tipo_falla=tipo;
        this.descripcion=descri;
    }
    public String gettipofalla(){
        return tipo_falla;
    }
    
    public String getdescripcion(){
        return descripcion;
    }
    
}
