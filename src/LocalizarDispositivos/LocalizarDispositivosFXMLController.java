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
	//	Declaración del hilo del escaner
	private Thread hiloEscaner;
	
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
	
	@FXML
	Text escan_msg_txt = new Text();

	//Lista de los datos que se mostrarán en la tabla
	ObservableList<DispositivoItem> datos;
    @FXML
    private Text titulo;
    @FXML
    private Button btn_e;

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

		tabla.setItems(datos);	// Se asignan los datos a la tabla
	}

	private void cargarDatos() {	// Ejecuta el método para extraer los datos de la red
		try {
			datos.clear();	//	Elimina los datos previos que se encuentren en la lista
			
			// Lista que guarda los dispositivos obtenidos del escaner de la red
			ArrayList<DispositivoItem> lista = NetworkScaner.getListaDispositivos();
			
			// Foreach para asignar los datos a la tabla
			for(DispositivoItem tmp : lista){
				datos.add(tmp);
			}
			
			escan_msg_txt.setVisible(false); //	Vuelve invisible el mensaje de escaneo
		} catch (Exception ex) {
			System.out.println("Error al cargar los datos \n" + ex);
		}
	}
	
	// Método que se utiliza para actualizar los datos mediante el botón "escanear"
	@FXML
	public void escanearDispositivos(ActionEvent ev) {
		escan_msg_txt.setVisible(true);	//	Vuelve visible el mensaje de escaneo
		
		// Inicia el proceso de escanear en un hilo aparte
		inicializarHiloEscaner();
	}
	
	private void inicializarHiloEscaner(){
		hiloEscaner = new Thread(){
			@Override
			public void run(){
				cargarDatos();
			}
		};
		hiloEscaner.start();
	}
}