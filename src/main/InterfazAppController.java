/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author SHEILA ALEJANDRE
 */
public class InterfazAppController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField txt_user;
    @FXML
    private JFXPasswordField txt_pass;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void entrar(ActionEvent ev) throws IOException {
        if (txt_user.getText().equals("root") && txt_pass.getText().equals("123456")) {
            Stage primaryStage = new Stage();
            Parent raiz = FXMLLoader.load(getClass().getResource("homepage.fxml"));
            Scene escena = new Scene(raiz);
            primaryStage.setTitle("Inicio");
            primaryStage.setScene(escena);
            primaryStage.show();
            ((Node) (ev.getSource())).getScene().getWindow().hide();/* para esconder la otra pantalla*/
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrectos");
        }

    }
}
