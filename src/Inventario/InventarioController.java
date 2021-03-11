/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class InventarioController implements Initializable {

    @FXML private TableView<Lista> tabla=new TableView();
    @FXML TableColumn<Lista, String> Arti;
    @FXML TableColumn<Lista, String> Cant;
    
    @FXML TextField txtA;
    @FXML TextField txtC;
    
    ObservableList<Lista> datos;
    int mostrar;
    
    @FXML
    private void Back (ActionEvent ev) throws IOException{
        Stage primaryStage=new Stage();
            Parent raiz=FXMLLoader.load (getClass().getResource("/main/interfazApp.fxml"));
            Scene escena=new Scene(raiz);
            primaryStage.setScene(escena);
            primaryStage.show();
           ((Node)(ev.getSource())).getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Arti.setCellValueFactory(new PropertyValueFactory<Lista, String>("Arti"));
        Cant.setCellValueFactory(new PropertyValueFactory<Lista, String>("Cant"));
        
        datos=FXCollections.observableArrayList();
        tabla.setItems(datos);
    }

    @FXML
    public void Agregar(){
        datos.add(new Lista(txtA.getText(),txtC.getText()));
        txtA.clear();
        txtC.clear();
    }
    
    @FXML
    private void Eliminar(){
        int selectedIndex = tabla.getSelectionModel().getSelectedIndex();
        if(selectedIndex >= 0){
            Lista ArticuloSelec = tabla.getSelectionModel().getSelectedItem();
            tabla.getItems().remove(selectedIndex);
        }
        else{
            JOptionPane.showMessageDialog(null, "No hay articulo seleccionado");
        }
    }
    
    @FXML
    private void Modificar(){
        mostrar=1;
        Lista ArticuloSelec= tabla.getSelectionModel().getSelectedItem();
        int selectedIndex = tabla.getSelectionModel().getSelectedIndex();
        if(ArticuloSelec != null){
            ArticuloSelec.setArti(txtA.getText());
            ArticuloSelec.setCant(txtC.getText());
            datos.set(selectedIndex, ArticuloSelec);
        }
        else{
           JOptionPane.showMessageDialog(null, "No hay articulo seleccionado");
        }
    }
}
