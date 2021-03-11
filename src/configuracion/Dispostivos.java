package configuracion;

/**
 *
 * @author Whoami
 */
public class Dispostivos {

    private String ip_Dispositivo;
    private String configuracion;
    private String modeloDipositivo;
    private String tipoDispositivo;
    private int ID_Dipositivo;

    public int getID_Dipositivo() {
        return ID_Dipositivo;
    }

    public void setID_Dipositivo(int ID_Dipositivo) {
        this.ID_Dipositivo = ID_Dipositivo;
    }

    public void setIp_Dispositivo(String ip_Dispositivo) {
        this.ip_Dispositivo = ip_Dispositivo;
    }

    public void setConfiguracion(String configuracion) {
        this.configuracion = configuracion;
    }

    public void setModeloDipositivo(String modeloDipositivo) {
        this.modeloDipositivo = modeloDipositivo;
    }

    public void setTipoDispositivo(String tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    public String getIp_Dispositivo() {
        return ip_Dispositivo;
    }

    public String getConfiguracion() {
        return configuracion;
    }

    public String getModeloDipositivo() {
        return modeloDipositivo;
    }

    public String getTipoDispositivo() {
        return tipoDispositivo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n ID Dispositivo: ");
        sb.append(ID_Dipositivo);
        sb.append("\n Modelo de dipositivo: ");
        sb.append(modeloDipositivo);
        sb.append("\n Tipo de Dispositivo:) ");
        sb.append(tipoDispositivo);
        sb.append("\n Ip Dipositivo: ");
        sb.append(ip_Dispositivo);
        sb.append("\n Configuración: ");
        sb.append(configuracion);

        return sb.toString();
    }

}
