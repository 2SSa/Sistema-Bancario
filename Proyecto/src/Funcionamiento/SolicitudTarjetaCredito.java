/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionamiento;

/**
 *
 * @author Jose Santos
 */
public class SolicitudTarjetaCredito {
    private int idSolicitud;
    private int cliente;

    public SolicitudTarjetaCredito() {
    }

    public SolicitudTarjetaCredito(int idSolicitud, int cliente) {
        this.idSolicitud = idSolicitud;
        this.cliente = cliente;
    }

    
    
    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }
    
    
}
