/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author x230
 */
public class HomepageController implements Initializable {

    @FXML
    private JFXButton search;

    @FXML
    private JFXButton ajustes;
    @FXML
    private FontAwesomeIconView home;
    @FXML
    private JFXButton bugs;
    @FXML
    private FontAwesomeIconView img_bug;
    @FXML
    private JFXButton inventario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void search_dispo(ActionEvent ev) throws IOException {
//        Stage primaryStage = new Stage();
//        Parent raiz = FXMLLoader.load(getClass().getResource("lo de buscar dispo.fxml"));
//        Scene escena = new Scene(raiz);
//        primaryStage.setTitle("LOCALIZAR DISPOSITIVO");
//        primaryStage.setScene(escena);
//        primaryStage.show();
//        ((Node) (ev.getSource())).getScene().getWindow().hide();/* para esconder la otra pantalla*/
    }

    @FXML
    private void ir_inventario(ActionEvent event) throws IOException {
//        Stage primaryStage = new Stage();
//        Parent raiz = FXMLLoader.load(getClass().getResource("inventario.fxml"));
//        Scene escena = new Scene(raiz);
//        primaryStage.setTitle("INVENTARIO");
//        primaryStage.setScene(escena);
//        primaryStage.show();
//        ((Node) (event.getSource())).getScene().getWindow().hide();/* para esconder la otra pantalla*/
    }

    @FXML
    private void ir_ajustes(ActionEvent event) throws IOException {
//        Stage primaryStage = new Stage();
//        Parent raiz = FXMLLoader.load(getClass().getResource("AJUSTES.fxml"));
//        Scene escena = new Scene(raiz);
//        primaryStage.setTitle("AJUSTES");
//        primaryStage.setScene(escena);
//        primaryStage.show();
//        ((Node) (event.getSource())).getScene().getWindow().hide();/* para esconder la otra pantalla*/
    }

    @FXML
    private void registro_fallas(ActionEvent event) throws IOException {
//        Stage primaryStage = new Stage();
//        Parent raiz = FXMLLoader.load(getClass().getResource("FALLAS.fxml"));
//        Scene escena = new Scene(raiz);
//        primaryStage.setTitle("FALLAS");
//        primaryStage.setScene(escena);
//        primaryStage.show();
//        ((Node) (event.getSource())).getScene().getWindow().hide();/* para esconder la otra pantalla*/
    }

}
