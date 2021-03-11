/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuracion;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Whoami
 */
public class ConfiguracionController implements Initializable {

    static ArrayList<Dispostivos> dispostivos = new ArrayList();
    @FXML
    TextArea historialConfig;
    @FXML
    TextField txt_modeloDipostipo;
    @FXML
    TextField txt_TipoDeipositivo;
    @FXML
    TextField txt_ipDispositivo;
    @FXML
    TextField txt_configDipositivo;
    @FXML
    TextField txt_ID_Dipositivo;
    @FXML
    Button btnAgreagr;

    int contador = 0;
    String datos = "";

    public void btnAgregar() {

        agregarConfiguracion();
        mostrarDipositivos();
        LimpiarTextField();
        contador++;

    }

    public void LimpiarTextField() {

        txt_TipoDeipositivo.setText(" ");
        txt_configDipositivo.setText(" ");
        txt_modeloDipostipo.setText(" ");
        txt_ipDispositivo.setText(" ");

    }

    public void BuscarDipos() {

        if (dispostivos.indexOf(Integer.parseInt(txt_ID_Dipositivo.getText())-1) !=-1) {
            datos = dispostivos.get(Integer.parseInt(txt_ID_Dipositivo.getText()) - 1).toString();
            historialConfig.setText(datos);
        } else {
            System.out.println("No se encontro..!" + dispostivos.size());
            historialConfig.clear();
            mostrarDipositivos();

        }
        txt_ID_Dipositivo.setText(" ");
    }

    //Método para leer coches e introducirlos en el array
    public void agregarConfiguracion() {

        int ID_Dispositivo;
        String ip_Dispositivo;
        String configuracion;
        String modeloDipositivo;
        String tipoDispositivo;

        //Variable auxiliar que contendrá la referencia a cada dipositivo nuevo.
        Dispostivos aux;

        ID_Dispositivo = contador;
        ip_Dispositivo = txt_ipDispositivo.getText();
        configuracion = txt_configDipositivo.getText();
        modeloDipositivo = txt_modeloDipostipo.getText();
        tipoDispositivo = txt_TipoDeipositivo.getText();

        aux = new Dispostivos();

        //se asignan valores a los atributos del nuevo objeto
        aux.setID_Dipositivo(ID_Dispositivo);
        aux.setIp_Dispositivo(ip_Dispositivo);
        aux.setConfiguracion(configuracion);
        aux.setModeloDipositivo(modeloDipositivo);
        aux.setTipoDispositivo(tipoDispositivo);

        //se añade el objeto al final del array
        dispostivos.add(aux);

    }//fin método 

    public void mostrarDipositivos() {

        for (int i = contador; i < dispostivos.size(); i++) {
            //System.out.println(dispostivos.get(i));  //se invoca el método toString de la clase Dipos
            //datos += "\n Dipositivo ID: " + String.valueOf(contador + 1);
            datos += dispostivos.get(i).toString();
            datos += "\n -----------------------------------------------------------------------------------------";
        }

        historialConfig.setText(datos);
    }//fin de metodo

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
