package LocalizarDispositivos;

import static java.lang.System.out;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

/**
 *
 * @author Edgerard
 */
public class NetworkScaner {
    public static void getListaDispositivos(){
        
    }
    
    public static void iniciarScaner() throws SocketException{
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        for (NetworkInterface netint : Collections.list(nets))
            displayInterfaceInformation(netint);
    }

    static void displayInterfaceInformation(NetworkInterface netint) throws SocketException {
        out.printf("Interface Display name: %s\n", netint.getDisplayName());
        out.printf("Name: %s\n", netint.getName());
        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
        
        
        ArrayList<InetAddress> direcciones= Collections.list(inetAddresses);
        if(!direcciones.isEmpty()){
            for (InetAddress inetAddress : direcciones) {
                
                System.out.println("HostName: " + inetAddress.getHostName());
                System.out.println("HostAddress: " + inetAddress.getHostAddress());
                //System.out.println("Address" + inetAddress.getAddress());
                //out.printf("InetAddress: %s\n", inetAddress);
                System.out.println("-------------------");
            }
        }else{
            System.out.println("Null");
        }
        out.printf("\n");
     }
}
