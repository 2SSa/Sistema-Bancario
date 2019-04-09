/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionamiento;

/**
 *
 * @author panch
 */
public class AgenciaBancaria {
    private String nombreAgencia;
    private int id;
    private String direccion;
    private String numeroTelefono;
    private int numeroCajas;
    private int noServicioCliente;
    private double efectivo;
    private boolean tipoAgencia;
    private int cajasAutobanco;
    private int cantidadUsado;

    public AgenciaBancaria() {
    }

    public AgenciaBancaria(String nombreAgencia, int id, String direccion, String numeroTelefono, int numeroCajas, int noServicioCliente, double efectivo, boolean tipoAgencia, int cajasAutobanco, int cantidadUsado) {
        this.nombreAgencia = nombreAgencia;
        this.id = id;
        this.direccion = direccion;
        this.numeroTelefono = numeroTelefono;
        this.numeroCajas = numeroCajas;
        this.noServicioCliente = noServicioCliente;
        this.efectivo = efectivo;
        this.tipoAgencia = tipoAgencia;
        this.cajasAutobanco = cajasAutobanco;
        this.cantidadUsado = cantidadUsado;
    }

    public int getCantidadUsado() {
        return cantidadUsado;
    }

    public void setCantidadUsado(int cantidadUsado) {
        this.cantidadUsado = cantidadUsado;
    }

    
    public boolean getTipoAgencia() {
        return tipoAgencia;
    }

    public void setTipoAgencia(boolean tipoAgencia) {
        this.tipoAgencia = tipoAgencia;
    }

    public int getCajasAutobanco() {
        return cajasAutobanco;
    }

    public void setCajasAutobanco(int cajasAutobanco) {
        this.cajasAutobanco = cajasAutobanco;
    }


    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public int getNumeroCajas() {
        return numeroCajas;
    }

    public void setNumeroCajas(int numeroCajas) {
        this.numeroCajas = numeroCajas;
    }

    public int getNoServicioCliente() {
        return noServicioCliente;
    }

    public void setNoServicioCliente(int noServicioCliente) {
        this.noServicioCliente = noServicioCliente;
    }

    public double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(double efectivo) {
        this.efectivo = efectivo;
    }
    
    
}
