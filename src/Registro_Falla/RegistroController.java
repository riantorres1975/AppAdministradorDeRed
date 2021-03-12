/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registro_Falla;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Markoski
 */
public class RegistroController implements Initializable {

    String nombre_falla = "";
    ArrayList<lista_datos> lista = new ArrayList<>();
    lista_datos list1;
    public static String guardar_dato;
    @FXML
    private TextArea descri;
    @FXML
    SplitMenuButton barra_menu;
    @FXML
    private Button agregar;

    @FXML
    public void falla_externa(ActionEvent art) {
        nombre_falla = "Falla Externa";
        barra_menu.setText(nombre_falla);
    }

    @FXML
    public void falla_dispositivo(ActionEvent art) {
        nombre_falla = "Falla del Dispositivo";
        barra_menu.setText(nombre_falla);
    }

    @FXML
    public void falla_configuracion(ActionEvent art) {
        nombre_falla = "Falla de la Configuracion";
        barra_menu.setText(nombre_falla);
    }

    @FXML
    public void boton_agregar(ActionEvent event) {
        list1 = new lista_datos();
        list1.Agregar_falla(nombre_falla, descri.getText());
        lista.add(list1);
        descri.setText("");
        barra_menu.setText("Selecciona Tipo de Falla");
    }

    @FXML
    public void boton_historial(ActionEvent event) throws IOException {
        HistorialController ventana2 = new HistorialController();
        barra_menu.setText("Selecciona Tipo de Falla");
        recorrer_lista();
        guardar_dato = ventana2.datos + guardar_dato;
        Stage primaryStage = new Stage();
        Parent hola = FXMLLoader.load(getClass().getResource("historial.fxml"));
        Scene escena = new Scene(hola);
        primaryStage.setScene(escena);
        primaryStage.show();
        ((Node) event.getSource()).getScene().getWindow().hide();

    }

    public void recorrer_lista() {
        String datos = null;
        datos = "";
        for (int i = 0; i < lista.size(); i++) {
            datos = datos + "Tipo de falla: " + lista.get(i).gettipofalla() + "\n Descripcion: " + lista.get(i).getdescripcion() + "\n";
            datos = datos + "---------------------------------------\n";
        }
        guardar_dato = datos;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btn_back(ActionEvent ev) throws IOException {
        Stage primaryStage = new Stage();
        Parent raiz = FXMLLoader.load(getClass().getResource("/main/homepage.fxml"));
        Scene escena = new Scene(raiz);
        primaryStage.setScene(escena);
        primaryStage.show();
        ((Node) (ev.getSource())).getScene().getWindow().hide();
    }

}
