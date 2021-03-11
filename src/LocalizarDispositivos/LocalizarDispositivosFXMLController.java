package LocalizarDispositivos;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Edgerard
 */
public class LocalizarDispositivosFXMLController implements Initializable {
    
    @FXML private TableView<DispositivoItem> tabla = new TableView();
    
    @FXML TableColumn<DispositivoItem, String> _NombreInterfaz = new TableColumn<>();
    @FXML TableColumn<DispositivoItem, String> _Nombre = new TableColumn<>();
    @FXML TableColumn<DispositivoItem, String> _HostName = new TableColumn<>();
    @FXML TableColumn<DispositivoItem, String> _HostAddress = new TableColumn<>();
    
    @FXML ObservableList<DispositivoItem>datos;
    
    private int mostrar = 0;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        _NombreInterfaz.setCellValueFactory(new PropertyValueFactory<>("NombreInterfaz"));
        _Nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        _HostName.setCellValueFactory(new PropertyValueFactory<>("HostName"));
        _HostAddress.setCellValueFactory(new PropertyValueFactory<>("HostAddress"));
        
        datos = FXCollections.observableArrayList();
        
        cargarDatos();
        
        tabla.setItems(datos);
        
        tabla.getSelectionModel().selectedItemProperty().addListener(   (observable,oldValue,newValue)->mostrarDatos(newValue));
    }
    
    private void cargarDatos(){
        try {
            datos.add(new DispositivoItem("prueba1", "prueba2", "prueba3", "prueba4"));
            datos.add(new DispositivoItem("prueba2", "prueba3", "prueba3", "prueba4"));
            datos.add(new DispositivoItem("prueba4", "prueba2", "prueba3", "prueba4"));
            datos.add(new DispositivoItem("prueba5", "prueba2", "prueba3", "prueba4"));
        } catch (Exception ex) {
            System.out.println("Error al cargar los datos \n" + ex);
        }
    }
    
    private void mostrarDatos(DispositivoItem aux){
        if(mostrar == 0){
            System.out.println("mostrar = "+
            aux.getNombre()
            );
        }else{
            mostrar = 0;
        }
    }
    
    
    @FXML
    public void escanearDispositivos(ActionEvent ev){
        mostrar = 1;
        System.out.println("mostrar = 1");
        datos.clear();
        cargarDatos();
    }
}
