package LocalizarDispositivos;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Edgerard
 */
public class LocalizarDispositivosFXMLController implements Initializable {

	// TableView FXML
	@FXML
	private TableView<DispositivoItem> tabla = new TableView();

	// Columnas de la tabla
	@FXML
	TableColumn<DispositivoItem, String> _NombreInterfaz = new TableColumn<>();
	@FXML
	TableColumn<DispositivoItem, String> _Nombre = new TableColumn<>();
	@FXML
	TableColumn<DispositivoItem, String> _HostName = new TableColumn<>();
	@FXML
	TableColumn<DispositivoItem, String> _HostAddress = new TableColumn<>();

	//Lista de los datos que se mostrarán en la tabla
	ObservableList<DispositivoItem> datos;
    @FXML
    private Text titulo;
    @FXML
    private Button btn_e;

	//private int mostrar = 0;

	/**
	 * Initializes the controller class.
	 *
	 * @param url
	 * @param rb
	 */
	
	// Método que inicializa el archivo FXML
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// Vinculación de las columnas con los datos de la tabla
		_NombreInterfaz.setCellValueFactory(new PropertyValueFactory<>("NombreInterfaz"));
		_Nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
		_HostName.setCellValueFactory(new PropertyValueFactory<>("HostName"));
		_HostAddress.setCellValueFactory(new PropertyValueFactory<>("HostAddress"));

		datos = FXCollections.observableArrayList();

		cargarDatos();	// Método que ejecuta la función que extrae los dispositivos

		tabla.setItems(datos);	// Se asignan los datos a la tabla

		// Método para definir la acción que se realizará al seleccionar un elemento de la tabla
		tabla.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> mostrarDatos(newValue));
	}

	private void cargarDatos() {	// Ejecuta el método para extraer los datos de la red
		try {
			// Lista que guarda los dispositivos obtenidos del escaner de la red
			ArrayList<DispositivoItem> lista = NetworkScaner.getListaDispositivos();
			
			// Foreach para asignar los datos a la tabla
			for(DispositivoItem tmp : lista){
				datos.add(tmp);
			}
		} catch (Exception ex) {
			System.out.println("Error al cargar los datos \n" + ex);
		}
	}

	private void mostrarDatos(DispositivoItem aux) { // Método que se ejecuta cuando se selecciona un elemento en la tabla (no implementado)
	}
	
	// Método que se utiliza para actualizar los datos mediante el botón "escanear"
	@FXML
	public void escanearDispositivos(ActionEvent ev) {
		datos.clear();
		cargarDatos();
	}
}