package LocalizarDispositivos;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

/**
 *
 * @author Edgerard
 */
public class NetworkScaner {
//	Clase que se encarga de analizar la red y extraer los dispositivos de la red

	public static ArrayList<DispositivoItem> getListaDispositivos() throws Exception {
		//	Lista para almacenar los dispositivos
		ArrayList<DispositivoItem> lista = new ArrayList<>();
		
		//	Obtiene las interfaces conectadas a la red y las guarda en una lista
		Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
		
		// Foreach para revisar las direcciones de cada interfaz
		for (NetworkInterface netint : Collections.list(nets)) {
			//	Obtiene las direcciones de la interfaz específica y las guarda en una lista
			Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
			
			ArrayList<InetAddress> direcciones = Collections.list(inetAddresses);
			
			//	Foreach para guardar tanto las interfaces como sus direcciones
			String hostname;
			for (InetAddress inetAddress : direcciones) {
				if(inetAddress.getHostName().equals(inetAddress.getHostAddress())){
					hostname = "(Desconocido)";
				}else{
					hostname = inetAddress.getHostName();
				}
				lista.add(new DispositivoItem(netint.getDisplayName(), netint.getName(), hostname, inetAddress.getHostAddress()));
			}
		}
		// retorna la lista creada
		return lista;
	}
}
