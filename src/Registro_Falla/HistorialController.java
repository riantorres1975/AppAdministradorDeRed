/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registro_Falla;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Markoski
 */
public class HistorialController implements Initializable {
    @FXML TextArea historial;
          
            
 public static String datos="";
    RegistroController ventana1=new RegistroController();
    
    
    public void insertar(){
        datos=ventana1.guardar_dato;
        historial.setText(datos);
    }
    
    public void volver(ActionEvent event) throws IOException{
        Stage primaryStage=new Stage();
        Parent hola =FXMLLoader.load(getClass().getResource("Registro.fxml"));
        Scene escena = new Scene(hola);
        primaryStage.setScene(escena);
        primaryStage.show();
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        insertar();
    }    
    
}
