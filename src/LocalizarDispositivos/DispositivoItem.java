package LocalizarDispositivos;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Edgerard
 */
public class DispositivoItem {	// Clase que contiene los datos de los dispositivos de la red

	private final SimpleStringProperty NombreInterfaz;
	private final SimpleStringProperty Nombre;
	private final SimpleStringProperty HostName;
	private final SimpleStringProperty HostAddress;

	public DispositivoItem(String _nombreInterfaz, String _nombre, String _hostName, String _hostAddress) throws Exception {
		this.NombreInterfaz = new SimpleStringProperty(_nombreInterfaz);
		this.Nombre = new SimpleStringProperty(_nombre);
		this.HostName = new SimpleStringProperty(_hostName);
		this.HostAddress = new SimpleStringProperty(_hostAddress);
	}

	//GETTERS
	public String getNombreInterfaz() {
		return NombreInterfaz.get();
	}

	public String getNombre() {
		return Nombre.get();
	}

	public String getHostName() {
		return HostName.get();
	}

	public String getHostAddress() {
		return HostAddress.get();
	}

	//SETTERS
	public void setNombreInterfaz(String newValues) {
		this.NombreInterfaz.set(newValues);
	}

	public void setNombre(String newValues) {
		this.Nombre.set(newValues);
	}

	public void setHostName(String newValues) {
		this.HostName.set(newValues);
	}

	public void setHostAddress(String newValues) {
		this.HostAddress.set(newValues);
	}
}
